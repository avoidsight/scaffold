package com.ruoyi.business.controller;

import com.ruoyi.business.domain.Billing;
import com.ruoyi.business.service.IBillingService;
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
 * 计费模板Controller
 *
 * @author ruoyi
 * @date 2022-03-15
 */
@Api(tags = "计费模板")
@RestController
@RequestMapping("/api/v2/business/billing" )
public class BillingController extends BaseController {
    @Autowired
    private IBillingService billingService;

    /**
     * 查询计费模板列表
     */
    @ApiOperation("查询计费模板列表")
    // @PreAuthorize("@ss.hasPermi('business:billing:list')" )
    @GetMapping("/list" )
    public TableDataInfo list(Billing billing) {
        startPage();
        List<Billing> list = billingService.selectBillingList(billing);
        return getDataTable(list);
    }

    /**
     * 导出计费模板列表
     */
    @ApiOperation("导出计费模板列表")
    // @PreAuthorize("@ss.hasPermi('business:billing:export')" )
    @Log(title = "计费模板" , businessType = BusinessType.EXPORT)
    @PostMapping("/export" )
    public void export(HttpServletResponse response, Billing billing) {
        List<Billing> list = billingService.selectBillingList(billing);
        ExcelUtil<Billing> util = new ExcelUtil<Billing>(Billing. class);
        util.exportExcel(response, list, "计费模板数据" );
    }

    /**
     * 获取计费模板详细信息
     */
    @ApiOperation("获取计费模板详细信息")
    // @PreAuthorize("@ss.hasPermi('business:billing:query')" )
    @GetMapping(value = "/{id}" )
    public AjaxResult getInfo(@PathVariable("id" ) Long id) {
        return AjaxResult.success(billingService.selectBillingById(id));
    }

    /**
     * 新增计费模板
     */
    @ApiOperation("新增计费模板")
    // @PreAuthorize("@ss.hasPermi('business:billing:add')" )
    @Log(title = "计费模板" , businessType = BusinessType.INSERT)
    @PostMapping("/add")
    public AjaxResult add(@RequestBody Billing billing) {
        billing.setCreateBy(getUsername());
        return toAjax(billingService.insertBilling(billing));
    }

    /**
     * 修改计费模板
     */
    @ApiOperation("修改计费模板")
    // @PreAuthorize("@ss.hasPermi('business:billing:edit')" )
    @Log(title = "计费模板" , businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    public AjaxResult edit(@RequestBody Billing billing) {
        billing.setUpdateBy(getUsername());
        return toAjax(billingService.updateBilling(billing));
    }

    /**
     * 删除计费模板
     */
    @ApiOperation("删除计费模板")
    // @PreAuthorize("@ss.hasPermi('business:billing:remove')" )
    @Log(title = "计费模板" , businessType = BusinessType.DELETE)
    @PostMapping("/delete/{ids}" )
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(billingService.deleteBillingByIds(ids));
    }
}
