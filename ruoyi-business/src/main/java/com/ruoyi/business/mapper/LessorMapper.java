package com.ruoyi.business.mapper;

import java.util.List;

import com.ruoyi.business.domain.Lessor;

/**
 * 出租人Mapper接口
 *
 * @author ruoyi
 * @date 2022-03-04
 */
public interface LessorMapper {
    /**
     * 查询出租人
     *
     * @param id 出租人主键
     * @return 出租人
     */
    public Lessor selectLessorById(Long id);

    /**
     * 查询出租人列表
     *
     * @param lessor 出租人
     * @return 出租人集合
     */
    public List<Lessor> selectLessorList(Lessor lessor);

    /**
     * 新增出租人
     *
     * @param lessor 出租人
     * @return 结果
     */
    public int insertLessor(Lessor lessor);

    /**
     * 修改出租人
     *
     * @param lessor 出租人
     * @return 结果
     */
    public int updateLessor(Lessor lessor);

    /**
     * 删除出租人
     *
     * @param id 出租人主键
     * @return 结果
     */
    public int deleteLessorById(Long id);

    /**
     * 批量删除出租人
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteLessorByIds(Long[] ids);
}
