package com.ruoyi.business.service;

import java.util.List;

import com.ruoyi.business.domain.Lessee;

/**
 * 承租人Service接口
 *
 * @author ruoyi
 * @date 2022-03-04
 */
public interface ILesseeService {
    /**
     * 查询承租人
     *
     * @param id 承租人主键
     * @return 承租人
     */
    public Lessee selectLesseeById(Long id);

    /**
     * 查询承租人列表
     *
     * @param lessee 承租人
     * @return 承租人集合
     */
    public List<Lessee> selectLesseeList(Lessee lessee);

    /**
     * 新增承租人
     *
     * @param lessee 承租人
     * @return 结果
     */
    public int insertLessee(Lessee lessee);

    /**
     * 修改承租人
     *
     * @param lessee 承租人
     * @return 结果
     */
    public int updateLessee(Lessee lessee);

    /**
     * 批量删除承租人
     *
     * @param ids 需要删除的承租人主键集合
     * @return 结果
     */
    public int deleteLesseeByIds(Long[] ids);

    /**
     * 删除承租人信息
     *
     * @param id 承租人主键
     * @return 结果
     */
    public int deleteLesseeById(Long id);
}
