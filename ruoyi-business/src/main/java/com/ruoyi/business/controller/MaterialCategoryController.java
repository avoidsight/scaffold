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
import com.ruoyi.business.domain.MaterialCategory;
import com.ruoyi.business.service.IMaterialCategoryService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 物料分类Controller
 *
 * @author ruoyi
 * @date 2022-03-23
 */
@Api(tags = "物料分类")
@RestController
@RequestMapping("/api/v2/business/category" )
public class MaterialCategoryController extends BaseController {
    @Autowired
    private IMaterialCategoryService materialCategoryService;

    /**
     * 查询物料分类列表
     */
    @ApiOperation("查询物料分类列表")
    // @PreAuthorize("@ss.hasPermi('business:category:list')" )
    @GetMapping("/list" )
    public TableDataInfo list(MaterialCategory materialCategory) {
        startPage();
        List<MaterialCategory> list = materialCategoryService.selectMaterialCategoryList(materialCategory);
        return getDataTable(list);
    }

    /**
     * 导出物料分类列表
     */
    @ApiOperation("导出物料分类列表")
    // @PreAuthorize("@ss.hasPermi('business:category:export')" )
    @Log(title = "物料分类" , businessType = BusinessType.EXPORT)
    @PostMapping("/export" )
    public void export(HttpServletResponse response, MaterialCategory materialCategory) {
        List<MaterialCategory> list = materialCategoryService.selectMaterialCategoryList(materialCategory);
        ExcelUtil<MaterialCategory> util = new ExcelUtil<MaterialCategory>(MaterialCategory. class);
        util.exportExcel(response, list, "物料分类数据" );
    }

    /**
     * 获取物料分类详细信息
     */
    @ApiOperation("获取物料分类详细信息")
    // @PreAuthorize("@ss.hasPermi('business:category:query')" )
    @GetMapping(value = "/{id}" )
    public AjaxResult getInfo(@PathVariable("id" ) Long id) {
        return AjaxResult.success(materialCategoryService.selectMaterialCategoryById(id));
    }

    /**
     * 新增物料分类
     */
    @ApiOperation("新增物料分类")
    // @PreAuthorize("@ss.hasPermi('business:category:add')" )
    @Log(title = "物料分类" , businessType = BusinessType.INSERT)
    @PostMapping("/add")
    public AjaxResult add(@RequestBody MaterialCategory materialCategory) {
        materialCategory.setCreateBy(getUsername());
        return toAjax(materialCategoryService.insertMaterialCategory(materialCategory));
    }

    /**
     * 修改物料分类
     */
    @ApiOperation("修改物料分类")
    // @PreAuthorize("@ss.hasPermi('business:category:edit')" )
    @Log(title = "物料分类" , businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    public AjaxResult edit(@RequestBody MaterialCategory materialCategory) {
        materialCategory.setUpdateBy(getUsername());
        return toAjax(materialCategoryService.updateMaterialCategory(materialCategory));
    }

    /**
     * 删除物料分类
     */
    @ApiOperation("删除物料分类")
    // @PreAuthorize("@ss.hasPermi('business:category:remove')" )
    @Log(title = "物料分类" , businessType = BusinessType.DELETE)
    @PostMapping("/delete/{ids}" )
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(materialCategoryService.deleteMaterialCategoryByIds(ids));
    }
}
