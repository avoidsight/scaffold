package com.ruoyi.business.controller;

import com.ruoyi.business.domain.Contract;
import com.ruoyi.business.domain.ContractBilling;
import com.ruoyi.business.domain.param.ContractParam;
import com.ruoyi.business.domain.param.ExternalMaterialParam;
import com.ruoyi.business.domain.vo.ContractVo;
import com.ruoyi.business.domain.vo.ExternalMaterialVo;
import com.ruoyi.business.service.IContractService;
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
 * 合同Controller
 *
 * @author menmenz
 * @date 2022-03-07
 */
@Api(tags = "合同")
@RestController
@RequestMapping("/api/v2/business/contract" )
public class ContractController extends BaseController {
    @Autowired
    private IContractService contractService;

    /**
     * 查询合同列表
     */
    @ApiOperation("查询合同列表")
    // @PreAuthorize("@ss.hasPermi('business:contract:list')" )
    @GetMapping("/list" )
    public TableDataInfo list(ContractParam contract) {
        startPage();
        List<ContractVo> list = contractService.selectContractList(contract);
        TableDataInfo<ContractVo> dataTable = getDataTable(list);
        return dataTable;
    }


    /**
     * 导出合同列表
     */
    @ApiOperation("导出合同列表")
    // @PreAuthorize("@ss.hasPermi('business:contract:export')" )
    @Log(title = "合同" , businessType = BusinessType.EXPORT)
    @PostMapping("/export" )
    public void export(HttpServletResponse response, ContractParam contract) {
        List<ContractVo> list = contractService.selectContractList(contract);
        ExcelUtil<ContractVo> util = new ExcelUtil<>(ContractVo. class);
        util.exportExcel(response, list, "合同数据" );
    }

    /**
     * 获取合同详细信息
     */
    @ApiOperation("获取合同详细信息")
    // @PreAuthorize("@ss.hasPermi('business:contract:query')" )
    @GetMapping(value = "/{id}" )
    public AjaxResult getInfo(@PathVariable("id" ) Long id) {
        return AjaxResult.success(contractService.selectContractById(id));
    }

    /**
     * 新增合同
     */
    @ApiOperation("新增合同")
    // @PreAuthorize("@ss.hasPermi('business:contract:add')" )
    @Log(title = "合同" , businessType = BusinessType.INSERT)
    @PostMapping("/add")
    public AjaxResult add(@RequestBody Contract contract) {
        contract.setCreateBy(getUsername());
        return toAjax(contractService.insertContract(contract));
    }

    /**
     * 修改合同
     */
    @ApiOperation("修改合同")
    // @PreAuthorize("@ss.hasPermi('business:contract:edit')" )
    @Log(title = "合同" , businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    public AjaxResult edit(@RequestBody Contract contract) {
        contract.setUpdateBy(getUsername());
        return toAjax(contractService.updateContract(contract));
    }

    /**
     * 删除合同
     */
    @ApiOperation("删除合同")
    // @PreAuthorize("@ss.hasPermi('business:contract:remove')" )
    @Log(title = "合同" , businessType = BusinessType.DELETE)
    @PostMapping("/delete/{ids}" )
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(contractService.deleteContractByIds(ids));
    }

    /**
     * 查询外部物料详情
     */
    @ApiOperation("查询外部物料")
    @GetMapping("/material/external")
    public TableDataInfo getInfo(ExternalMaterialParam param) {
        List<ExternalMaterialVo> list = contractService.selectExternalMaterial(param);
        TableDataInfo<ExternalMaterialVo> dataTable = getDataTable(list);
        return dataTable;
    }

    @ApiOperation("查询合同计费模板列表")
    // @PreAuthorize("@ss.hasPermi('business:billing:list')" )
    @GetMapping("/billing/{contractId}" )
    public TableDataInfo list(@PathVariable("contractId" ) Long contractId, @RequestParam(required = false) String expenseType) {
        startPage();
        List<ContractBilling> list = contractService.selectContractBillingList(contractId, expenseType);
        return getDataTable(list);
    }
}
