package com.ruoyi.business.service.impl;

import java.util.List;
        import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.business.mapper.DurationMapper;
import com.ruoyi.business.domain.Duration;
import com.ruoyi.business.service.IDurationService;

/**
 * 统计期间管理Service业务层处理
 *
 * @author ruoyi
 * @date 2022-03-08
 */
@Service
public class DurationServiceImpl implements IDurationService {
    @Autowired
    private DurationMapper durationMapper;

    /**
     * 查询统计期间管理
     *
     * @param id 统计期间管理主键
     * @return 统计期间管理
     */
    @Override
    public Duration selectDurationById(Long id) {
        return durationMapper.selectDurationById(id);
    }

    /**
     * 查询统计期间管理列表
     *
     * @param duration 统计期间管理
     * @return 统计期间管理
     */
    @Override
    public List<Duration> selectDurationList(Duration duration) {
        return durationMapper.selectDurationList(duration);
    }

    /**
     * 新增统计期间管理
     *
     * @param duration 统计期间管理
     * @return 结果
     */
    @Override
    public int insertDuration(Duration duration) {
                duration.setCreateTime(DateUtils.getNowDate());
            return durationMapper.insertDuration(duration);
    }

    /**
     * 修改统计期间管理
     *
     * @param duration 统计期间管理
     * @return 结果
     */
    @Override
    public int updateDuration(Duration duration) {
                duration.setUpdateTime(DateUtils.getNowDate());
        return durationMapper.updateDuration(duration);
    }

    /**
     * 批量删除统计期间管理
     *
     * @param ids 需要删除的统计期间管理主键
     * @return 结果
     */
    @Override
    public int deleteDurationByIds(Long[] ids) {
        return durationMapper.deleteDurationByIds(ids);
    }

    /**
     * 删除统计期间管理信息
     *
     * @param id 统计期间管理主键
     * @return 结果
     */
    @Override
    public int deleteDurationById(Long id) {
        return durationMapper.deleteDurationById(id);
    }
}
