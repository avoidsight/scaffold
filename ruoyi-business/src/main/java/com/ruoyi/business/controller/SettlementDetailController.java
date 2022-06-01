package com.ruoyi.business.controller;

import java.util.Arrays;
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
import com.ruoyi.business.domain.SettlementDetail;
import com.ruoyi.business.service.ISettlementDetailService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 结算明细Controller
 *
 * @author ruoyi
 * @date 2022-05-06
 */
@Api(tags = "结算明细")
@RestController
@RequestMapping("/api/v2/business/detail" )
public class SettlementDetailController extends BaseController {
    @Autowired
    private ISettlementDetailService settlementDetailService;

    /**
     * 查询结算明细列表
     */
    @ApiOperation("查询结算明细列表")
    // @PreAuthorize("@ss.hasPermi('business:detail:list')" )
    @GetMapping("/list" )
    public TableDataInfo list(SettlementDetail settlementDetail) {
        startPage();
        List<SettlementDetail> list = settlementDetailService.selectSettlementDetailList(settlementDetail);
        return getDataTable(list);
    }

    /**
     * 导出结算明细列表
     */
    @ApiOperation("导出结算明细列表")
    // @PreAuthorize("@ss.hasPermi('business:detail:export')" )
    @Log(title = "结算明细" , businessType = BusinessType.EXPORT)
    @PostMapping("/export" )
    public void export(HttpServletResponse response, SettlementDetail settlementDetail) {
        List<SettlementDetail> list = settlementDetailService.selectSettlementDetailList(settlementDetail);
        ExcelUtil<SettlementDetail> util = new ExcelUtil<SettlementDetail>(SettlementDetail. class);
        util.exportExcel(response, list, "结算明细数据" );
    }

    /**
     * 获取结算明细详细信息
     */
    @ApiOperation("获取结算明细详细信息")
    // @PreAuthorize("@ss.hasPermi('business:detail:query')" )
    @GetMapping(value = "/{id}" )
    public AjaxResult getInfo(@PathVariable("id" ) Long id) {
        return AjaxResult.success(settlementDetailService.selectSettlementDetailById(id));
    }

    /**
     * 新增结算明细
     */
    @ApiOperation("新增结算明细")
    // @PreAuthorize("@ss.hasPermi('business:detail:add')" )
    @Log(title = "结算明细" , businessType = BusinessType.INSERT)
    @PostMapping("/add")
    public AjaxResult add(@RequestBody SettlementDetail settlementDetail) {
        settlementDetail.setCreateBy(getUsername());
        return toAjax(settlementDetailService.insertSettlementDetail(settlementDetail));
    }

    /**
     * 修改结算明细
     */
    @ApiOperation("修改结算明细")
    // @PreAuthorize("@ss.hasPermi('business:detail:edit')" )
    @Log(title = "结算明细" , businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    public AjaxResult edit(@RequestBody SettlementDetail settlementDetail) {
        settlementDetail.setUpdateBy(getUsername());
        return toAjax(settlementDetailService.updateSettlementDetail(settlementDetail));
    }
}
