package com.ruoyi.business.controller;

import com.ruoyi.business.domain.Manufacturer;
import com.ruoyi.business.service.IManufacturerService;
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
 * 生产商Controller
 *
 * @author ruoyi
 * @date 2022-05-09
 */
@Api(tags = "生产商")
@RestController
@RequestMapping("/api/v2/business/manufacturer" )
public class ManufacturerController extends BaseController {
    @Autowired
    private IManufacturerService manufacturerService;

    /**
     * 查询生产商列表
     */
    @ApiOperation("查询生产商列表")
    // @PreAuthorize("@ss.hasPermi('business:manufacturer:list')" )
    @GetMapping("/list" )
    public TableDataInfo list(Manufacturer manufacturer) {
        startPage();
        List<Manufacturer> list = manufacturerService.selectManufacturerList(manufacturer);
        return getDataTable(list);
    }

    /**
     * 导出生产商列表
     */
    @ApiOperation("导出生产商列表")
    // @PreAuthorize("@ss.hasPermi('business:manufacturer:export')" )
    @Log(title = "生产商" , businessType = BusinessType.EXPORT)
    @PostMapping("/export" )
    public void export(HttpServletResponse response, Manufacturer manufacturer) {
        List<Manufacturer> list = manufacturerService.selectManufacturerList(manufacturer);
        ExcelUtil<Manufacturer> util = new ExcelUtil<Manufacturer>(Manufacturer. class);
        util.exportExcel(response, list, "生产商数据" );
    }

    /**
     * 获取生产商详细信息
     */
    @ApiOperation("获取生产商详细信息")
    // @PreAuthorize("@ss.hasPermi('business:manufacturer:query')" )
    @GetMapping(value = "/{id}" )
    public AjaxResult getInfo(@PathVariable("id" ) Long id) {
        return AjaxResult.success(manufacturerService.selectManufacturerById(id));
    }

    /**
     * 新增生产商
     */
    @ApiOperation("新增生产商")
    // @PreAuthorize("@ss.hasPermi('business:manufacturer:add')" )
    @Log(title = "生产商" , businessType = BusinessType.INSERT)
    @PostMapping("/add")
    public AjaxResult add(@RequestBody Manufacturer manufacturer) {
        manufacturer.setCreateBy(getUsername());
        return toAjax(manufacturerService.insertManufacturer(manufacturer));
    }

    /**
     * 修改生产商
     */
    @ApiOperation("修改生产商")
    // @PreAuthorize("@ss.hasPermi('business:manufacturer:edit')" )
    @Log(title = "生产商" , businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    public AjaxResult edit(@RequestBody Manufacturer manufacturer) {
        manufacturer.setUpdateBy(getUsername());
        return toAjax(manufacturerService.updateManufacturer(manufacturer));
    }

    /**
     * 删除生产商
     */
    @ApiOperation("删除生产商")
    // @PreAuthorize("@ss.hasPermi('business:manufacturer:remove')" )
    @Log(title = "生产商" , businessType = BusinessType.DELETE)
    @PostMapping("/delete/{ids}" )
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(manufacturerService.deleteManufacturerByIds(ids));
    }
}
