package com.ruoyi.business.controller;

import com.ruoyi.business.domain.Duration;
import com.ruoyi.business.service.IDurationService;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 统计期间管理Controller
 *
 * @author ruoyi
 * @date 2022-03-08
 */
@Api(tags = "统计期间管理")
@RestController
@RequestMapping("/api/v2/business/duration" )
public class DurationController extends BaseController {
    @Autowired
    private IDurationService durationService;

    /**
     * 查询统计期间管理列表
     */
    @ApiOperation("查询统计期间管理列表")
    // @PreAuthorize("@ss.hasPermi('business:duration:list')" )
    @GetMapping("/list" )
    public TableDataInfo list(Duration duration) {
        startPage();
        List<Duration> list = durationService.selectDurationList(duration);
        return getDataTable(list);
    }

    /**
     * 导出统计期间管理列表
     */
    @ApiOperation("导出统计期间管理列表")
    // @PreAuthorize("@ss.hasPermi('business:duration:export')" )
    @Log(title = "统计期间管理" , businessType = BusinessType.EXPORT)
    @PostMapping("/export" )
    public void export(HttpServletResponse response, Duration duration) {
        List<Duration> list = durationService.selectDurationList(duration);
        ExcelUtil<Duration> util = new ExcelUtil<Duration>(Duration. class);
        util.exportExcel(response, list, "统计期间管理数据" );
    }

    /**
     * 获取统计期间管理详细信息
     */
    @ApiOperation("获取统计期间管理详细信息")
    // @PreAuthorize("@ss.hasPermi('business:duration:query')" )
    @GetMapping(value = "/{id}" )
    public AjaxResult getInfo(@PathVariable("id" ) Long id) {
        return AjaxResult.success(durationService.selectDurationById(id));
    }

    /**
     * 新增统计期间管理
     */
    @ApiOperation("新增统计期间管理")
    // @PreAuthorize("@ss.hasPermi('business:duration:add')" )
    @Log(title = "统计期间管理" , businessType = BusinessType.INSERT)
    @PostMapping("/add")
    public AjaxResult add(@RequestBody Duration duration) {
        duration.setCreateBy(getUsername());
        return toAjax(durationService.insertDuration(duration));
    }

    /**
     * 修改统计期间管理
     */
    @ApiOperation("修改统计期间管理")
    // @PreAuthorize("@ss.hasPermi('business:duration:edit')" )
    @Log(title = "统计期间管理" , businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    public AjaxResult edit(@RequestBody Duration duration) {
        duration.setUpdateBy(getUsername());
        return toAjax(durationService.updateDuration(duration));
    }

    /**
     * 删除统计期间管理
     */
    @ApiOperation("删除统计期间管理")
    // @PreAuthorize("@ss.hasPermi('business:duration:remove')" )
    @Log(title = "统计期间管理" , businessType = BusinessType.DELETE)
    @PostMapping("/delete/{ids}" )
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(durationService.deleteDurationByIds(ids));
    }
}
