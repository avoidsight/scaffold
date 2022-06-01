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
import com.ruoyi.business.domain.Expense;
import com.ruoyi.business.service.IExpenseService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 费用类型设置Controller
 *
 * @author ruoyi
 * @date 2022-03-09
 */
@Api(tags = "费用类型设置")
@RestController
@RequestMapping("/api/v2/business/expense" )
public class ExpenseController extends BaseController {
    @Autowired
    private IExpenseService expenseService;

    /**
     * 查询费用类型设置列表
     */
    @ApiOperation("查询费用类型设置列表")
    // @PreAuthorize("@ss.hasPermi('business:expense:list')" )
    @GetMapping("/list" )
    public TableDataInfo list(Expense expense) {
        startPage();
        List<Expense> list = expenseService.selectExpenseList(expense);
        return getDataTable(list);
    }

    /**
     * 导出费用类型设置列表
     */
    @ApiOperation("导出费用类型设置列表")
    // @PreAuthorize("@ss.hasPermi('business:expense:export')" )
    @Log(title = "费用类型设置" , businessType = BusinessType.EXPORT)
    @PostMapping("/export" )
    public void export(HttpServletResponse response, Expense expense) {
        List<Expense> list = expenseService.selectExpenseList(expense);
        ExcelUtil<Expense> util = new ExcelUtil<Expense>(Expense. class);
        util.exportExcel(response, list, "费用类型设置数据" );
    }

    /**
     * 获取费用类型设置详细信息
     */
    @ApiOperation("获取费用类型设置详细信息")
    // @PreAuthorize("@ss.hasPermi('business:expense:query')" )
    @GetMapping(value = "/{id}" )
    public AjaxResult getInfo(@PathVariable("id" ) Long id) {
        return AjaxResult.success(expenseService.selectExpenseById(id));
    }

    /**
     * 新增费用类型设置
     */
    @ApiOperation("新增费用类型设置")
    // @PreAuthorize("@ss.hasPermi('business:expense:add')" )
    @Log(title = "费用类型设置" , businessType = BusinessType.INSERT)
    @PostMapping("/add")
    public AjaxResult add(@RequestBody Expense expense) {
        expense.setCreateBy(getUsername());
        return toAjax(expenseService.insertExpense(expense));
    }

    /**
     * 修改费用类型设置
     */
    @ApiOperation("修改费用类型设置")
    // @PreAuthorize("@ss.hasPermi('business:expense:edit')" )
    @Log(title = "费用类型设置" , businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    public AjaxResult edit(@RequestBody Expense expense) {
        expense.setUpdateBy(getUsername());
        return toAjax(expenseService.updateExpense(expense));
    }

    /**
     * 删除费用类型设置
     */
    @ApiOperation("删除费用类型设置")
    // @PreAuthorize("@ss.hasPermi('business:expense:remove')" )
    @Log(title = "费用类型设置" , businessType = BusinessType.DELETE)
    @PostMapping("/delete/{ids}" )
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(expenseService.deleteExpenseByIds(ids));
    }
}
