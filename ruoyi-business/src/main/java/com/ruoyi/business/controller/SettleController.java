package com.ruoyi.business.controller;

import com.ruoyi.business.domain.Settle;
import com.ruoyi.business.domain.param.InventoryParam;
import com.ruoyi.business.domain.param.SettleAddParam;
import com.ruoyi.business.domain.param.SettleParam;
import com.ruoyi.business.domain.vo.SettleListVo;
import com.ruoyi.business.domain.vo.SettleSummaryVo;
import com.ruoyi.business.service.ISettleService;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 结算管理Controller
 *
 * @author ruoyi
 * @date 2022-03-11
 */
@Api(tags = "结算管理")
@RestController
@RequestMapping("/api/v2/business/settle" )
public class SettleController extends BaseController {
    @Autowired
    private ISettleService settleService;

    @ApiOperation("进度对账列表")
    @GetMapping("/list")
    public TableDataInfo<SettleListVo> list(SettleParam param) {
        startPage();
        List<SettleListVo> list = settleService.list(param);
        return getDataTable(list);
    }

    @ApiOperation("创建进度对账单")
    @PostMapping("/add")
    @Log(title = "进度对账单" , businessType = BusinessType.INSERT)
    public AjaxResult add(@RequestBody SettleAddParam param) {
        return toAjax(settleService.insertSettle(param));
    }


    @ApiOperation("获取进度对账单详细信息")
    // @PreAuthorize("@ss.hasPermi('business:settle:query')" )
    @GetMapping(value = "/{id}" )
    public AjaxResult getInfo(@PathVariable("id" ) Long id) {
        return AjaxResult.success(settleService.selectSettleById(id));
    }

    @ApiOperation("进度对账汇总")
    @GetMapping("/summary")
    public TableDataInfo<SettleSummaryVo> summary(SettleParam param) {
        startPage();
        List<SettleSummaryVo> list = settleService.summary(param);
        return getDataTable(list);
    }

    @ApiOperation("查询已结算和未结算的重量")
    @GetMapping("/weight")
    public AjaxResult getWeight(InventoryParam param) {
        return AjaxResult.success(settleService.selectSettleWeight(param));
    }

    /**
     * 修改进度对账单
     */
    @ApiOperation("修改进度对账单")
    // @PreAuthorize("@ss.hasPermi('business:settle:edit')" )
    @Log(title = "进度对账单" , businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    public AjaxResult edit(@RequestBody Settle settle) {
        settle.setUpdateBy(getUsername());
        return toAjax(settleService.updateSettle(settle));
    }

    /**
     * 删除进度对账单
     */
    @ApiOperation("删除进度对账单")
    // @PreAuthorize("@ss.hasPermi('business:settle:remove')" )
    @Log(title = "进度对账单" , businessType = BusinessType.DELETE)
    @PostMapping("/delete/{ids}" )
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(settleService.deleteSettleByIds(ids));
    }

}
