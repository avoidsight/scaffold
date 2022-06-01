package com.ruoyi.business.service.impl;

import java.util.List;
        import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.business.mapper.ExpenseMapper;
import com.ruoyi.business.domain.Expense;
import com.ruoyi.business.service.IExpenseService;

/**
 * 费用类型设置Service业务层处理
 *
 * @author ruoyi
 * @date 2022-03-09
 */
@Service
public class ExpenseServiceImpl implements IExpenseService {
    @Autowired
    private ExpenseMapper expenseMapper;

    /**
     * 查询费用类型设置
     *
     * @param id 费用类型设置主键
     * @return 费用类型设置
     */
    @Override
    public Expense selectExpenseById(Long id) {
        return expenseMapper.selectExpenseById(id);
    }

    /**
     * 查询费用类型设置列表
     *
     * @param expense 费用类型设置
     * @return 费用类型设置
     */
    @Override
    public List<Expense> selectExpenseList(Expense expense) {
        return expenseMapper.selectExpenseList(expense);
    }

    /**
     * 新增费用类型设置
     *
     * @param expense 费用类型设置
     * @return 结果
     */
    @Override
    public int insertExpense(Expense expense) {
                expense.setCreateTime(DateUtils.getNowDate());
            return expenseMapper.insertExpense(expense);
    }

    /**
     * 修改费用类型设置
     *
     * @param expense 费用类型设置
     * @return 结果
     */
    @Override
    public int updateExpense(Expense expense) {
                expense.setUpdateTime(DateUtils.getNowDate());
        return expenseMapper.updateExpense(expense);
    }

    /**
     * 批量删除费用类型设置
     *
     * @param ids 需要删除的费用类型设置主键
     * @return 结果
     */
    @Override
    public int deleteExpenseByIds(Long[] ids) {
        return expenseMapper.deleteExpenseByIds(ids);
    }

    /**
     * 删除费用类型设置信息
     *
     * @param id 费用类型设置主键
     * @return 结果
     */
    @Override
    public int deleteExpenseById(Long id) {
        return expenseMapper.deleteExpenseById(id);
    }
}
