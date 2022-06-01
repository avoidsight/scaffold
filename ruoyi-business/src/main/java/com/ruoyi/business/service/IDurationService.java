package com.ruoyi.business.service;

import java.util.List;

import com.ruoyi.business.domain.Duration;

/**
 * 统计期间管理Service接口
 *
 * @author ruoyi
 * @date 2022-03-08
 */
public interface IDurationService {
    /**
     * 查询统计期间管理
     *
     * @param id 统计期间管理主键
     * @return 统计期间管理
     */
    public Duration selectDurationById(Long id);

    /**
     * 查询统计期间管理列表
     *
     * @param duration 统计期间管理
     * @return 统计期间管理集合
     */
    public List<Duration> selectDurationList(Duration duration);

    /**
     * 新增统计期间管理
     *
     * @param duration 统计期间管理
     * @return 结果
     */
    public int insertDuration(Duration duration);

    /**
     * 修改统计期间管理
     *
     * @param duration 统计期间管理
     * @return 结果
     */
    public int updateDuration(Duration duration);

    /**
     * 批量删除统计期间管理
     *
     * @param ids 需要删除的统计期间管理主键集合
     * @return 结果
     */
    public int deleteDurationByIds(Long[] ids);

    /**
     * 删除统计期间管理信息
     *
     * @param id 统计期间管理主键
     * @return 结果
     */
    public int deleteDurationById(Long id);
}
