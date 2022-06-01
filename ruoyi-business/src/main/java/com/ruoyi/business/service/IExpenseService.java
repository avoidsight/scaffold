package com.ruoyi.business.service;

import java.util.List;

import com.ruoyi.business.domain.Expense;

/**
 * 费用类型设置Service接口
 *
 * @author ruoyi
 * @date 2022-03-09
 */
public interface IExpenseService {
    /**
     * 查询费用类型设置
     *
     * @param id 费用类型设置主键
     * @return 费用类型设置
     */
    public Expense selectExpenseById(Long id);

    /**
     * 查询费用类型设置列表
     *
     * @param expense 费用类型设置
     * @return 费用类型设置集合
     */
    public List<Expense> selectExpenseList(Expense expense);

    /**
     * 新增费用类型设置
     *
     * @param expense 费用类型设置
     * @return 结果
     */
    public int insertExpense(Expense expense);

    /**
     * 修改费用类型设置
     *
     * @param expense 费用类型设置
     * @return 结果
     */
    public int updateExpense(Expense expense);

    /**
     * 批量删除费用类型设置
     *
     * @param ids 需要删除的费用类型设置主键集合
     * @return 结果
     */
    public int deleteExpenseByIds(Long[] ids);

    /**
     * 删除费用类型设置信息
     *
     * @param id 费用类型设置主键
     * @return 结果
     */
    public int deleteExpenseById(Long id);
}
