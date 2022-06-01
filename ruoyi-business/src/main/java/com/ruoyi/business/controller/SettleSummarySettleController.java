package com.ruoyi.business.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.business.domain.SettleSummarySettle;
import com.ruoyi.business.service.ISettleSummarySettleService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 汇总单与进度单关系Controller
 *
 * @author ruoyi
 * @date 2022-05-06
 */
@Api(tags = "汇总单与进度单关系")
@RestController
@RequestMapping("/api/v2/business/summarySettle" )
public class SettleSummarySettleController extends BaseController {
    @Autowired
    private ISettleSummarySettleService settleSummarySettleService;

    /**
     * 查询汇总单与进度单关系列表
     */
    @ApiOperation("查询汇总单与进度单关系列表")
    // @PreAuthorize("@ss.hasPermi('business:settle:list')" )
    @GetMapping("/list" )
    public TableDataInfo list(SettleSummarySettle settleSummarySettle) {
        startPage();
        List<SettleSummarySettle> list = settleSummarySettleService.selectSettleSummarySettleList(settleSummarySettle);
        return getDataTable(list);
    }

    /**
     * 导出汇总单与进度单关系列表
     */
    @ApiOperation("导出汇总单与进度单关系列表")
    // @PreAuthorize("@ss.hasPermi('business:settle:export')" )
    @Log(title = "汇总单与进度单关系" , businessType = BusinessType.EXPORT)
    @PostMapping("/export" )
    public void export(HttpServletResponse response, SettleSummarySettle settleSummarySettle) {
        List<SettleSummarySettle> list = settleSummarySettleService.selectSettleSummarySettleList(settleSummarySettle);
        ExcelUtil<SettleSummarySettle> util = new ExcelUtil<SettleSummarySettle>(SettleSummarySettle. class);
        util.exportExcel(response, list, "汇总单与进度单关系数据" );
    }

    /**
     * 获取汇总单与进度单关系详细信息
     */
    @ApiOperation("获取汇总单与进度单关系详细信息")
    // @PreAuthorize("@ss.hasPermi('business:settle:query')" )
    @GetMapping(value = "/{id}" )
    public AjaxResult getInfo(@PathVariable("id" ) Long id) {
        return AjaxResult.success(settleSummarySettleService.selectSettleSummarySettleById(id));
    }

    /**
     * 新增汇总单与进度单关系
     */
    @ApiOperation("新增汇总单与进度单关系")
    // @PreAuthorize("@ss.hasPermi('business:settle:add')" )
    @Log(title = "汇总单与进度单关系" , businessType = BusinessType.INSERT)
    @PostMapping("/add")
    public AjaxResult add(@RequestBody SettleSummarySettle settleSummarySettle) {
        settleSummarySettle.setCreateBy(getUsername());
        return toAjax(settleSummarySettleService.insertSettleSummarySettle(settleSummarySettle));
    }

    /**
     * 修改汇总单与进度单关系
     */
    @ApiOperation("修改汇总单与进度单关系")
    // @PreAuthorize("@ss.hasPermi('business:settle:edit')" )
    @Log(title = "汇总单与进度单关系" , businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    public AjaxResult edit(@RequestBody SettleSummarySettle settleSummarySettle) {
        settleSummarySettle.setUpdateBy(getUsername());
        return toAjax(settleSummarySettleService.updateSettleSummarySettle(settleSummarySettle));
    }

    /**
     * 删除汇总单与进度单关系
     */
    @ApiOperation("删除汇总单与进度单关系")
    // @PreAuthorize("@ss.hasPermi('business:settle:remove')" )
    @Log(title = "汇总单与进度单关系" , businessType = BusinessType.DELETE)
    @PostMapping("/delete/{ids}" )
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(settleSummarySettleService.deleteSettleSummarySettleByIds(ids));
    }
}
