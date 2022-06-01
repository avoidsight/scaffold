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
import com.ruoyi.business.domain.MaterialSpecs;
import com.ruoyi.business.service.IMaterialSpecsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 物料规格Controller
 *
 * @author ruoyi
 * @date 2022-03-18
 */
@Api(tags = "物料规格")
@RestController
@RequestMapping("/api/v2/business/specs" )
public class MaterialSpecsController extends BaseController {
    @Autowired
    private IMaterialSpecsService materialSpecsService;

    /**
     * 查询物料规格列表
     */
    @ApiOperation("查询物料规格列表")
    // @PreAuthorize("@ss.hasPermi('business:specs:list')" )
    @GetMapping("/list" )
    public TableDataInfo list(MaterialSpecs materialSpecs) {
        startPage();
        List<MaterialSpecs> list = materialSpecsService.selectMaterialSpecsList(materialSpecs);
        return getDataTable(list);
    }

    /**
     * 导出物料规格列表
     */
    @ApiOperation("导出物料规格列表")
    // @PreAuthorize("@ss.hasPermi('business:specs:export')" )
    @Log(title = "物料规格" , businessType = BusinessType.EXPORT)
    @PostMapping("/export" )
    public void export(HttpServletResponse response, MaterialSpecs materialSpecs) {
        List<MaterialSpecs> list = materialSpecsService.selectMaterialSpecsList(materialSpecs);
        ExcelUtil<MaterialSpecs> util = new ExcelUtil<MaterialSpecs>(MaterialSpecs. class);
        util.exportExcel(response, list, "物料规格数据" );
    }

    /**
     * 获取物料规格详细信息
     */
    @ApiOperation("获取物料规格详细信息")
    // @PreAuthorize("@ss.hasPermi('business:specs:query')" )
    @GetMapping(value = "/{id}" )
    public AjaxResult getInfo(@PathVariable("id" ) Long id) {
        return AjaxResult.success(materialSpecsService.selectMaterialSpecsById(id));
    }

    /**
     * 新增物料规格
     */
    @ApiOperation("新增物料规格")
    // @PreAuthorize("@ss.hasPermi('business:specs:add')" )
    @Log(title = "物料规格" , businessType = BusinessType.INSERT)
    @PostMapping("/add")
    public AjaxResult add(@RequestBody MaterialSpecs materialSpecs) {
        materialSpecs.setCreateBy(getUsername());
        return toAjax(materialSpecsService.insertMaterialSpecs(materialSpecs));
    }

    /**
     * 修改物料规格
     */
    @ApiOperation("修改物料规格")
    // @PreAuthorize("@ss.hasPermi('business:specs:edit')" )
    @Log(title = "物料规格" , businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    public AjaxResult edit(@RequestBody MaterialSpecs materialSpecs) {
        materialSpecs.setUpdateBy(getUsername());
        return toAjax(materialSpecsService.updateMaterialSpecs(materialSpecs));
    }

    /**
     * 删除物料规格
     */
    @ApiOperation("删除物料规格")
    // @PreAuthorize("@ss.hasPermi('business:specs:remove')" )
    @Log(title = "物料规格" , businessType = BusinessType.DELETE)
    @PostMapping("/delete/{ids}" )
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(materialSpecsService.deleteMaterialSpecsByIds(ids));
    }
}
