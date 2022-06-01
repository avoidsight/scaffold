package com.ruoyi.business.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ruoyi.business.domain.param.BillingAccountParam;
import com.ruoyi.business.domain.param.LeaseSettlementParam;
import com.ruoyi.business.domain.vo.*;
import com.ruoyi.business.service.IContractService;
import com.ruoyi.common.utils.StringUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.compress.utils.Lists;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.business.domain.Settlement;
import com.ruoyi.business.service.ISettlementService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 结算Controller
 *
 * @author ruoyi
 * @date 2022-05-06
 */
@Api(tags = "结算")
@RestController
@RequestMapping("/api/v2/business/settlement" )
public class SettlementController extends BaseController {
    @Autowired
    private ISettlementService settlementService;

    @Autowired
    private IContractService iContractService;

    /**
     * 查询结算列表
     */
    @ApiOperation("查询结算列表")
    // @PreAuthorize("@ss.hasPermi('business:settlement:list')" )
    @GetMapping("/list" )
    public TableDataInfo<SettlementVo> list(BillingAccountParam billingAccountParam) {
        startPage();
        List<SettlementVo> list = settlementService.selectSettlementList(billingAccountParam);
        return getDataTable(list);
    }


    /**
     * 租赁结算清单查询结算列表
     */
    @ApiOperation("租赁结算清单查询结算列表")
    // @PreAuthorize("@ss.hasPermi('business:settlement:list')" )
    @GetMapping("/listLeaseSettlement/{settleId}")
    public AjaxResult listLeaseSettlement(@PathVariable("settleId") Long settleId) {
        List<LeaseSettlementChecklistVo> settlementChecklistVos = settlementService.listLeaseSettlement(settleId);
        LeaseSettlementChecklistHeaderVo leaseSettlementChecklistHeaderVo = settlementService.getLeaseSettlementChecklistHeaderById(settleId);

        LeaseSettlementVo jsonObjectResult = new LeaseSettlementVo();
        jsonObjectResult.setChecklistHeaderVo(leaseSettlementChecklistHeaderVo);
        jsonObjectResult.setList(settlementChecklistVos);
        return AjaxResult.success(jsonObjectResult);
    }

    /**
     * 租赁结算清单查询结算列表(编辑按钮进入)
     */
    @ApiOperation("租赁结算清单查询结算列表(编辑按钮进入)")
    // @PreAuthorize("@ss.hasPermi('business:settlement:list')" )
    @GetMapping("/listLeaseSettlementEdit/{settlementId}")
    public AjaxResult listLeaseSettlementEdit(@PathVariable("settlementId") Long settlementId) {
//        LeaseSettlementParam leaseSettlementParam
        List<LeaseSettlementChecklistVo> settlementChecklistVos = settlementService.listLeaseSettlementEdit(settlementId);
        Settlement settlement = settlementService.selectSettlementById(settlementId);
        LeaseSettlementVo jsonObjectResult = new LeaseSettlementVo();
        if(!ObjectUtils.isEmpty(settlement)){
            LeaseSettlementChecklistHeaderVo leaseSettlementChecklistHeaderVo = settlementService.getLeaseSettlementChecklistHeaderById(settlement.getSettleId());
            jsonObjectResult.setChecklistHeaderVo(leaseSettlementChecklistHeaderVo);
            jsonObjectResult.setList(settlementChecklistVos);
        }

        return AjaxResult.success(jsonObjectResult);
    }



    /**
     * 新增结算
     */
    @ApiOperation("新增或修改结算")
    // @PreAuthorize("@ss.hasPermi('business:settlement:add')" )
    @Log(title = "新增或修改" , businessType = BusinessType.INSERT)
    @PostMapping("/addOrEdit")
    public AjaxResult addOrEdit(@RequestBody LeaseSettlementVo leaseSettlementVo) {
//        settlement.setCreateBy(getUsername());
        return toAjax(settlementService.insertSettlement(leaseSettlementVo));
    }

    /**
     * 删除结算
     */
    @ApiOperation("删除结算")
    // @PreAuthorize("@ss.hasPermi('business:settlement:remove')" )
    @Log(title = "结算" , businessType = BusinessType.DELETE)
    @PostMapping("/delete/{ids}" )
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(settlementService.deleteSettlementByIds(ids));
    }

}
