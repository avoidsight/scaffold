package com.ruoyi.business.controller;

import com.ruoyi.business.domain.RentalUnit;
import com.ruoyi.business.service.IRentalUnitService;
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
 * 租赁商Controller
 *
 * @author ruoyi
 * @date 2022-05-09
 */
@Api(tags = "租赁商")
@RestController
@RequestMapping("/api/v2/business/rentalUnit" )
public class RentalUnitController extends BaseController {
    @Autowired
    private IRentalUnitService rentalUnitService;

    /**
     * 查询租赁商列表
     */
    @ApiOperation("查询租赁商列表")
    // @PreAuthorize("@ss.hasPermi('business:rentalUnit:list')" )
    @GetMapping("/list" )
    public TableDataInfo list(RentalUnit rentalUnit) {
        startPage();
        List<RentalUnit> list = rentalUnitService.selectRentalUnitList(rentalUnit);
        return getDataTable(list);
    }

    /**
     * 导出租赁商列表
     */
    @ApiOperation("导出租赁商列表")
    // @PreAuthorize("@ss.hasPermi('business:rentalUnit:export')" )
    @Log(title = "租赁商" , businessType = BusinessType.EXPORT)
    @PostMapping("/export" )
    public void export(HttpServletResponse response, RentalUnit rentalUnit) {
        List<RentalUnit> list = rentalUnitService.selectRentalUnitList(rentalUnit);
        ExcelUtil<RentalUnit> util = new ExcelUtil<RentalUnit>(RentalUnit. class);
        util.exportExcel(response, list, "租赁商数据" );
    }

    /**
     * 获取租赁商详细信息
     */
    @ApiOperation("获取租赁商详细信息")
    // @PreAuthorize("@ss.hasPermi('business:rentalUnit:query')" )
    @GetMapping(value = "/{id}" )
    public AjaxResult getInfo(@PathVariable("id" ) Long id) {
        return AjaxResult.success(rentalUnitService.selectRentalUnitById(id));
    }

    /**
     * 新增租赁商
     */
    @ApiOperation("新增租赁商")
    // @PreAuthorize("@ss.hasPermi('business:rentalUnit:add')" )
    @Log(title = "租赁商" , businessType = BusinessType.INSERT)
    @PostMapping("/add")
    public AjaxResult add(@RequestBody RentalUnit rentalUnit) {
        rentalUnit.setCreateBy(getUsername());
        return toAjax(rentalUnitService.insertRentalUnit(rentalUnit));
    }

    /**
     * 修改租赁商
     */
    @ApiOperation("修改租赁商")
    // @PreAuthorize("@ss.hasPermi('business:rentalUnit:edit')" )
    @Log(title = "租赁商" , businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    public AjaxResult edit(@RequestBody RentalUnit rentalUnit) {
        rentalUnit.setUpdateBy(getUsername());
        return toAjax(rentalUnitService.updateRentalUnit(rentalUnit));
    }

    /**
     * 删除租赁商
     */
    @ApiOperation("删除租赁商")
    // @PreAuthorize("@ss.hasPermi('business:rentalUnit:remove')" )
    @Log(title = "租赁商" , businessType = BusinessType.DELETE)
    @PostMapping("/delete/{ids}" )
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(rentalUnitService.deleteRentalUnitByIds(ids));
    }
}
