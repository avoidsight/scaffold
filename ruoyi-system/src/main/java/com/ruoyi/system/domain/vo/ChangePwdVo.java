package com.ruoyi.system.domain.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("修改密码")
public class ChangePwdVo {
    @ApiModelProperty("手机号")
    private String phoneNumber;

    @ApiModelProperty("手机验证码")
    private String smsCode;

    @ApiModelProperty("新密码")
    private String newPwd;
}
