package com.ruoyi.web.controller.common;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.config.RuoYiConfig;
import com.ruoyi.common.constant.Constants;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.core.redis.RedisCache;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.common.utils.file.FileUtils;
import com.ruoyi.framework.config.ServerConfig;
import com.ruoyi.system.mapper.SysUserMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.RandomUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * 通用请求处理
 *
 * @author ruoyi
 */
@Api(tags = "通用服务")
@RequestMapping("/api/v2/common")
@RestController
public class CommonController {
    private static final Logger log = LoggerFactory.getLogger(CommonController.class);

    @Autowired
    private ServerConfig serverConfig;

    @Autowired
    private RedisCache redisCache;

    @Autowired
    private SysUserMapper userMapper;

    @Value("${sms.url}")
    private String smsUrl;

    @Value("${sms.templateCode}")
    private String templateCode;

    /**
     * 通用下载请求
     *
     * @param fileName 文件名称
     * @param delete   是否删除
     */
    @GetMapping("/download" )
    public void fileDownload(String fileName, Boolean delete, HttpServletResponse response, HttpServletRequest request) {
        try {
            if (!FileUtils.checkAllowDownload(fileName)) {
                throw new Exception(StringUtils.format("文件名称({})非法，不允许下载。 " , fileName));
            }
            String realFileName = System.currentTimeMillis() + fileName.substring(fileName.indexOf("_" ) + 1);
            String filePath = RuoYiConfig.getDownloadPath() + fileName;

            response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
            FileUtils.setAttachmentResponseHeader(response, realFileName);
            FileUtils.writeBytes(filePath, response.getOutputStream());
            if (delete) {
                FileUtils.deleteFile(filePath);
            }
        } catch (Exception e) {
            log.error("下载文件失败" , e);
        }
    }

    /**
     * 通用上传请求
     */
    @ApiOperation("上传附件")
    @PostMapping("/upload" )
    public AjaxResult uploadFile(MultipartFile file) throws Exception {
        try {
            // 上传文件路径
            String filePath = RuoYiConfig.getUploadPath();
            // 上传并返回新文件名称
            String fileName = FileUploadUtils.upload(filePath, file);
            String url = serverConfig.getUrl() + fileName;
            AjaxResult ajax = AjaxResult.success();
            ajax.put("fileName" , fileName);
            ajax.put("url" , url);
            return ajax;
        } catch (Exception e) {
            return AjaxResult.error(e.getMessage());
        }
    }

    /**
     * 本地资源通用下载
     */
    @ApiOperation("下载附件")
    @GetMapping("/download/resource" )
    public void resourceDownload(String resource, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        try {
            if (!FileUtils.checkAllowDownload(resource)) {
                throw new Exception(StringUtils.format("资源文件({})非法，不允许下载。 " , resource));
            }
            // 本地资源路径
            String localPath = RuoYiConfig.getProfile();
            // 数据库资源地址
            String downloadPath = localPath + StringUtils.substringAfter(resource, Constants.RESOURCE_PREFIX);
            // 下载名称
            String downloadName = StringUtils.substringAfterLast(downloadPath, "/" );
            response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
            FileUtils.setAttachmentResponseHeader(response, downloadName);
            FileUtils.writeBytes(downloadPath, response.getOutputStream());
        } catch (Exception e) {
            log.error("下载文件失败" , e);
        }
    }

    /**
     * 短信发送
     */
    @ApiOperation("发送短信")
    @PostMapping("/sms/send")
    public AjaxResult sendSms(String phoneNumber) {
        // 根据手机号查找用户
        SysUser sysUser = userMapper.checkPhoneUnique(phoneNumber);
        if(Objects.isNull(sysUser)) {
            throw new ServiceException("用户不存在");
        }
        // 获取验证码, 保存redis, 5分钟过期
        String smsCode = String.valueOf(RandomUtils.nextInt(100000, 999999));
        String verifyKey = Constants.SMS_CODE_KEY + phoneNumber;
        redisCache.setCacheObject(verifyKey, smsCode, Constants.SMS_EXPIRATION, TimeUnit.MINUTES);
        // 发送短信
        String requestBody = generateRequestParam(phoneNumber, templateCode, smsCode);
        String res = HttpUtil.post(smsUrl, requestBody);
        return AjaxResult.success(JSONObject.parseObject(res).get("msg"));
    }

    private String generateRequestParam(String phoneNumber, String templateCode, String smsCode) {
        JSONObject body = new JSONObject();
        body.put("phoneNumbers", phoneNumber);
        body.put("templateCode", templateCode);
        JSONObject param = new JSONObject();
        param.put("key", "code");
        param.put("value", smsCode);
        body.put("templateParams", new JSONObject[]{param});
        return body.toString();
    }

    public static void main(String[] args) {
        CommonController commonController = new CommonController();
        String code = commonController.generateRequestParam("13321133844", "SMS_187757511", "520111");

        String res = HttpUtil.post("https://testics.scg.cn/api/Sms.Send", code);
        Object msg = JSONObject.parseObject(res).get("msg");
        System.out.println(msg);
    }
}
