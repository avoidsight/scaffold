package com.ruoyi.business.service.impl;

import java.util.List;
        import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.business.mapper.LessorMapper;
import com.ruoyi.business.domain.Lessor;
import com.ruoyi.business.service.ILessorService;

/**
 * 出租人Service业务层处理
 *
 * @author ruoyi
 * @date 2022-03-04
 */
@Service
public class LessorServiceImpl implements ILessorService {
    @Autowired
    private LessorMapper lessorMapper;

    /**
     * 查询出租人
     *
     * @param id 出租人主键
     * @return 出租人
     */
    @Override
    public Lessor selectLessorById(Long id) {
        return lessorMapper.selectLessorById(id);
    }

    /**
     * 查询出租人列表
     *
     * @param lessor 出租人
     * @return 出租人
     */
    @Override
    public List<Lessor> selectLessorList(Lessor lessor) {
        return lessorMapper.selectLessorList(lessor);
    }

    /**
     * 新增出租人
     *
     * @param lessor 出租人
     * @return 结果
     */
    @Override
    public int insertLessor(Lessor lessor) {
                lessor.setCreateTime(DateUtils.getNowDate());
            return lessorMapper.insertLessor(lessor);
    }

    /**
     * 修改出租人
     *
     * @param lessor 出租人
     * @return 结果
     */
    @Override
    public int updateLessor(Lessor lessor) {
                lessor.setUpdateTime(DateUtils.getNowDate());
        return lessorMapper.updateLessor(lessor);
    }

    /**
     * 批量删除出租人
     *
     * @param ids 需要删除的出租人主键
     * @return 结果
     */
    @Override
    public int deleteLessorByIds(Long[] ids) {
        return lessorMapper.deleteLessorByIds(ids);
    }

    /**
     * 删除出租人信息
     *
     * @param id 出租人主键
     * @return 结果
     */
    @Override
    public int deleteLessorById(Long id) {
        return lessorMapper.deleteLessorById(id);
    }
}
