package com.ruoyi.business.mapper;

import java.util.List;

import com.ruoyi.business.domain.SettleSummary;
import com.ruoyi.business.domain.SettleSummarySettle;
import com.ruoyi.business.domain.param.SettleSummaryAddParam;
import com.ruoyi.business.domain.param.SettleSummarySearchParam;
import com.ruoyi.business.domain.vo.*;
import org.apache.ibatis.annotations.Param;

/**
 * 进度对账单汇总Mapper接口
 *
 * @author ruoyi
 * @date 2022-05-06
 */
public interface SettleSummaryMapper {
    /**
     * 查询进度对账单汇总信息
     *
     * @param id 进度对账单汇总主键
     * @return 进度对账单汇总信息
     */
    SettleSumVo selectSettleSummaryInfoById(Long id);

    List<Long> getSettleIdsBySettleSummaryId(Long id);

    /**
     * 查询进度对账单汇总列表
     *
     * @param param 进度对账单汇总
     * @return 进度对账单汇总集合
     */
    List<SeSummaryVo> selectSettleSummaryList(SettleSummarySearchParam param);

    /**
     * 新增进度对账单汇总
     *
     * @param settleSummary 进度对账单汇总对象
     * @return 结果
     */
    int insertSettleSummary(SettleSummary settleSummary);

    /**
     * 批量新增汇总单与进度单关系
     *
     * @param settleSummarySettleList 汇总单与进度单关系列表
     * @return 结果
     */
    int batchSettleInventory(List<SettleSummarySettle> settleSummarySettleList);

    /**
     * 修改进度对账单汇总
     *
     * @param settleSummary 进度对账单汇总
     * @return 结果
     */
    int updateSettleSummary(SettleSummary settleSummary);

    /**
     * 删除进度对账单汇总
     *
     * @param id 进度对账单汇总主键
     * @return 结果
     */
    int deleteSettleSummaryById(Long id);

    /**
     * 批量删除进度对账单汇总
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    int deleteSettleSummaryByIds(Long[] ids);

    /**
     * 批量删除汇总单与进度单关系
     *
     * @param ids 需要删除的汇总主键集合
     * @return 结果
     */
    int deleteSettleSummarySettle(Long[] ids);

    /**
     * 获取开始时间之前的数据, 用于保存期初期末
     *
     * @param ids 进度对账单主键集合
     * @return 结果
     */
    SummaryVo getBeforeSummaryByIds(Long[] ids);

    /**
     * 进度对账单汇总
     *
     * @param ids 进度对账单主键集合
     * @return 进度对账汇总列表
     */
    List<SummaryVo> summaryByIds(Long[] ids);

    /**
     * 获取进度对账单汇总表头基本信息
     *
     * @param ids 进度对账单主键
     * @return 进度对账单汇总基本信息
     */
    SettleSumVo getSettleSummaryBaseInfoByIds(@Param("array") Long[] ids,@Param("summaryId")Long id);

    /**
     * 获取进度对账单明细前两张表信息
     * @param id 进度对账单主键
     * @param type 0: 入库, 1: 出库
     * @return 进度对账单明细前两张表信息
     */
    SummaryDetailVo getSettleDetailList(@Param("id") Long id, @Param("type")Integer type);

    /**
     * 获取进度对账单明细其他费用信息
     *
     * @param id 进度对账单主键
     * @return 进度对账单明细其他费用信息
     */
    List<SummaryDetailListVo> getOtherFeeById(Long id);
}
