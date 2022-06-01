package com.ruoyi.business.mapper;

import java.util.List;

import com.ruoyi.business.domain.SettleSummarySettle;

/**
 * 汇总单与进度单关系Mapper接口
 *
 * @author ruoyi
 * @date 2022-05-06
 */
public interface SettleSummarySettleMapper {
    /**
     * 查询汇总单与进度单关系
     *
     * @param id 汇总单与进度单关系主键
     * @return 汇总单与进度单关系
     */
    SettleSummarySettle selectSettleSummarySettleById(Long id);

    /**
     * 查询汇总单与进度单关系列表
     *
     * @param settleSummarySettle 汇总单与进度单关系
     * @return 汇总单与进度单关系集合
     */
    List<SettleSummarySettle> selectSettleSummarySettleList(SettleSummarySettle settleSummarySettle);

    /**
     * 新增汇总单与进度单关系
     *
     * @param settleSummarySettle 汇总单与进度单关系
     * @return 结果
     */
    int insertSettleSummarySettle(SettleSummarySettle settleSummarySettle);

    /**
     * 修改汇总单与进度单关系
     *
     * @param settleSummarySettle 汇总单与进度单关系
     * @return 结果
     */
    int updateSettleSummarySettle(SettleSummarySettle settleSummarySettle);

    /**
     * 删除汇总单与进度单关系
     *
     * @param id 汇总单与进度单关系主键
     * @return 结果
     */
    int deleteSettleSummarySettleById(Long id);

    /**
     * 批量删除汇总单与进度单关系
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    int deleteSettleSummarySettleByIds(Long[] ids);
}
