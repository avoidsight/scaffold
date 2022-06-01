package com.ruoyi.business.controller;

import java.util.List;

import com.ruoyi.business.domain.param.SettleAddParam;
import com.ruoyi.business.domain.param.SettleSummaryAddParam;
import com.ruoyi.business.domain.param.SettleSummarySearchParam;
import com.ruoyi.business.domain.vo.SeSummaryVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
import com.ruoyi.business.domain.SettleSummary;
import com.ruoyi.business.service.ISettleSummaryService;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 进度对账单汇总Controller
 *
 * @author ruoyi
 * @date 2022-05-06
 */
@Api(tags = "进度对账单汇总")
@RestController
@RequestMapping("/api/v2/business/summary" )
public class SettleSummaryController extends BaseController {
    @Autowired
    private ISettleSummaryService settleSummaryService;

    /**
     * 查询进度对账单汇总列表
     */
    @ApiOperation("查询进度对账单汇总列表")
    // @PreAuthorize("@ss.hasPermi('business:summary:list')" )
    @GetMapping("/list" )
    public TableDataInfo<SeSummaryVo> list(SettleSummarySearchParam param) {
        startPage();
        List<SeSummaryVo> list = settleSummaryService.selectSettleSummaryList(param);
        return getDataTable(list);
    }

    /**
     * 获取进度对账单汇总详细信息
     */
    @ApiOperation("获取进度对账单汇总详细信息")
    // @PreAuthorize("@ss.hasPermi('business:summary:query')" )
    @GetMapping(value = "/{id}" )
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(settleSummaryService.selectSettleSummaryById(id));
    }

    /**
     * 新增进度对账单汇总
     */
    @ApiOperation("新增进度对账单汇总")
    // @PreAuthorize("@ss.hasPermi('business:summary:add')" )
    @Log(title = "进度对账单汇总" , businessType = BusinessType.INSERT)
    @PostMapping("/add")
    public AjaxResult add(@RequestBody SettleSummaryAddParam param) {
        return toAjax(settleSummaryService.insertSettleSummary(param));
    }

    /**
     * 修改进度对账单汇总
     */
    @ApiOperation("修改进度对账单汇总")
    // @PreAuthorize("@ss.hasPermi('business:summary:edit')" )
    @Log(title = "进度对账单汇总" , businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    public AjaxResult edit(@RequestBody SettleSummary settleSummary) {
        settleSummary.setUpdateBy(getUsername());
        return toAjax(settleSummaryService.updateSettleSummary(settleSummary));
    }

    /**
     * 删除进度对账单汇总
     */
    @ApiOperation("删除进度对账单汇总")
    // @PreAuthorize("@ss.hasPermi('business:summary:remove')" )
    @Log(title = "进度对账单汇总" , businessType = BusinessType.DELETE)
    @PostMapping("/delete/{ids}" )
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(settleSummaryService.deleteSettleSummaryByIds(ids));
    }

    @ApiOperation("进度对账单汇总功能（传ids）")
    @GetMapping("/settleSummary/{ids}")
    public AjaxResult settleSummary(@PathVariable Long[] ids) {
        return AjaxResult.success(settleSummaryService.summary(ids));
    }

    @ApiOperation("获取进度对账单明细全部信息")
    @GetMapping("/getSettleDetail")
    public AjaxResult getSettleDetail (Long id) {
        return AjaxResult.success(settleSummaryService.getSettleDetail(id));
    }
}
