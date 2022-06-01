package com.ruoyi.business.controller;

import com.ruoyi.business.domain.Inventory;
import com.ruoyi.business.domain.param.InventoryBookParam;
import com.ruoyi.business.domain.param.InventoryParam;
import com.ruoyi.business.domain.vo.InventoryBookVo;
import com.ruoyi.business.domain.vo.InventoryVo;
import com.ruoyi.business.service.IInventoryService;
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
 * 库存出入库Controller
 *
 * @author ruoyi
 * @date 2022-03-11
 */
@Api(tags = "库存出入库")
@RestController
@RequestMapping("/api/v2/business/inventory" )
public class InventoryController extends BaseController {
    @Autowired
    private IInventoryService inventoryService;

    /**
     * 查询库存出入库列表
     */
    @ApiOperation("查询库存出入库列表")
    // @PreAuthorize("@ss.hasPermi('business:inventory:list')" )
    @GetMapping("/list" )
    public TableDataInfo list(InventoryParam inventory) {
        startPage();
        List<InventoryVo> list = inventoryService.selectInventoryList(inventory);
        return getDataTable(list);
    }

    /**
     * 导出库存出入库列表
     */
    @ApiOperation("导出库存出入库列表")
    // @PreAuthorize("@ss.hasPermi('business:inventory:export')" )
    @Log(title = "库存出入库" , businessType = BusinessType.EXPORT)
    @PostMapping("/export" )
    public void export(HttpServletResponse response, InventoryParam inventory) {
        List<InventoryVo> list = inventoryService.selectInventoryList(inventory);
        ExcelUtil<InventoryVo> util = new ExcelUtil<>(InventoryVo. class);
        util.exportExcel(response, list, "库存出入库数据" );
    }

    /**
     * 获取库存出入库详细信息
     */
    @ApiOperation("获取库存出入库详细信息")
    // @PreAuthorize("@ss.hasPermi('business:inventory:query')" )
    @GetMapping(value = "/{id}" )
    public AjaxResult getInfo(@PathVariable("id" ) Long id) {
        return AjaxResult.success(inventoryService.selectInventoryById(id));
    }

    /**
     * 新增库存出入库
     */
    @ApiOperation("新增库存出入库")
    // @PreAuthorize("@ss.hasPermi('business:inventory:add')" )
    @Log(title = "库存出入库" , businessType = BusinessType.INSERT)
    @PostMapping("/add")
    public AjaxResult add(@RequestBody Inventory inventory) {
        inventory.create();
        inventory.setDeptId(getDeptId());
        return toAjax(inventoryService.insertInventory(inventory));
    }

    /**
     * 修改库存出入库
     */
    @ApiOperation("修改库存出入库")
    // @PreAuthorize("@ss.hasPermi('business:inventory:edit')" )
    @Log(title = "库存出入库" , businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    public AjaxResult edit(@RequestBody Inventory inventory) {
        inventory.update();
        return toAjax(inventoryService.updateInventory(inventory));
    }

    /**
     * 删除库存出入库
     */
    @ApiOperation("删除库存出入库")
    // @PreAuthorize("@ss.hasPermi('business:inventory:remove')" )
    @Log(title = "库存出入库" , businessType = BusinessType.DELETE)
    @PostMapping("/delete/{ids}" )
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(inventoryService.deleteInventoryByIds(ids));
    }

    /**
     * 出入库台账
     */
    @ApiOperation("出入库单台账查询")
    // @PreAuthorize("@ss.hasPermi('business:inventory:query:all')")
    @GetMapping("/query/books")
    public TableDataInfo<InventoryBookVo> queryAll(InventoryBookParam param) {
        startPage();
        List<InventoryBookVo> list = inventoryService.selectInventoryBookList(param);
        return getDataTable(list);
    }

    /**
     * 导出库存出入库列表
     */
    @ApiOperation("导出出入库台账列表")
    // @PreAuthorize("@ss.hasPermi('business:inventory:export')" )
    @Log(title = "出入库台账" , businessType = BusinessType.EXPORT)
    @PostMapping("/export/books" )
    public void exportBooks(HttpServletResponse response, InventoryBookParam inventory) {
        List<InventoryBookVo> list = inventoryService.selectInventoryBookList(inventory);
        ExcelUtil<InventoryBookVo> util = new ExcelUtil<>(InventoryBookVo. class);
        util.exportExcel(response, list, "库存出入库台账数据" );
    }
}