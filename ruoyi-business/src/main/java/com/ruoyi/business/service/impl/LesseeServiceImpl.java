package com.ruoyi.business.service.impl;

import java.util.List;
        import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.business.mapper.LesseeMapper;
import com.ruoyi.business.domain.Lessee;
import com.ruoyi.business.service.ILesseeService;

/**
 * 承租人Service业务层处理
 *
 * @author ruoyi
 * @date 2022-03-04
 */
@Service
public class LesseeServiceImpl implements ILesseeService {
    @Autowired
    private LesseeMapper lesseeMapper;

    /**
     * 查询承租人
     *
     * @param id 承租人主键
     * @return 承租人
     */
    @Override
    public Lessee selectLesseeById(Long id) {
        return lesseeMapper.selectLesseeById(id);
    }

    /**
     * 查询承租人列表
     *
     * @param lessee 承租人
     * @return 承租人
     */
    @Override
    public List<Lessee> selectLesseeList(Lessee lessee) {
        return lesseeMapper.selectLesseeList(lessee);
    }

    /**
     * 新增承租人
     *
     * @param lessee 承租人
     * @return 结果
     */
    @Override
    public int insertLessee(Lessee lessee) {
                lessee.setCreateTime(DateUtils.getNowDate());
            return lesseeMapper.insertLessee(lessee);
    }

    /**
     * 修改承租人
     *
     * @param lessee 承租人
     * @return 结果
     */
    @Override
    public int updateLessee(Lessee lessee) {
                lessee.setUpdateTime(DateUtils.getNowDate());
        return lesseeMapper.updateLessee(lessee);
    }

    /**
     * 批量删除承租人
     *
     * @param ids 需要删除的承租人主键
     * @return 结果
     */
    @Override
    public int deleteLesseeByIds(Long[] ids) {
        return lesseeMapper.deleteLesseeByIds(ids);
    }

    /**
     * 删除承租人信息
     *
     * @param id 承租人主键
     * @return 结果
     */
    @Override
    public int deleteLesseeById(Long id) {
        return lesseeMapper.deleteLesseeById(id);
    }
}
