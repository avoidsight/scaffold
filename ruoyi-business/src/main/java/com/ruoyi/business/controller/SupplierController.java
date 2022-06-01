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
import com.ruoyi.business.domain.Supplier;
import com.ruoyi.business.service.ISupplierService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 供应商Controller
 *
 * @author ruoyi
 * @date 2022-05-12
 */
@Api(tags = "供应商")
@RestController
@RequestMapping("/api/v2/business/supplier" )
public class SupplierController extends BaseController {
    @Autowired
    private ISupplierService supplierService;

    /**
     * 查询供应商列表
     */
    @ApiOperation("查询供应商列表")
    // @PreAuthorize("@ss.hasPermi('business:supplier:list')" )
    @GetMapping("/list" )
    public TableDataInfo list(Supplier supplier) {
        startPage();
        List<Supplier> list = supplierService.selectSupplierList(supplier);
        return getDataTable(list);
    }

    /**
     * 导出供应商列表
     */
    @ApiOperation("导出供应商列表")
    // @PreAuthorize("@ss.hasPermi('business:supplier:export')" )
    @Log(title = "供应商" , businessType = BusinessType.EXPORT)
    @PostMapping("/export" )
    public void export(HttpServletResponse response, Supplier supplier) {
        List<Supplier> list = supplierService.selectSupplierList(supplier);
        ExcelUtil<Supplier> util = new ExcelUtil<Supplier>(Supplier. class);
        util.exportExcel(response, list, "供应商数据" );
    }

    /**
     * 获取供应商详细信息
     */
    @ApiOperation("获取供应商详细信息")
    // @PreAuthorize("@ss.hasPermi('business:supplier:query')" )
    @GetMapping(value = "/{id}" )
    public AjaxResult getInfo(@PathVariable("id" ) Long id) {
        return AjaxResult.success(supplierService.selectSupplierById(id));
    }

    /**
     * 新增供应商
     */
    @ApiOperation("新增供应商")
    // @PreAuthorize("@ss.hasPermi('business:supplier:add')" )
    @Log(title = "供应商" , businessType = BusinessType.INSERT)
    @PostMapping("/add")
    public AjaxResult add(@RequestBody Supplier supplier) {
        supplier.setCreateBy(getUsername());
        return toAjax(supplierService.insertSupplier(supplier));
    }

    /**
     * 修改供应商
     */
    @ApiOperation("修改供应商")
    // @PreAuthorize("@ss.hasPermi('business:supplier:edit')" )
    @Log(title = "供应商" , businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    public AjaxResult edit(@RequestBody Supplier supplier) {
        supplier.setUpdateBy(getUsername());
        return toAjax(supplierService.updateSupplier(supplier));
    }

    /**
     * 删除供应商
     */
    @ApiOperation("删除供应商")
    // @PreAuthorize("@ss.hasPermi('business:supplier:remove')" )
    @Log(title = "供应商" , businessType = BusinessType.DELETE)
    @PostMapping("/delete/{ids}" )
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(supplierService.deleteSupplierByIds(ids));
    }
}
