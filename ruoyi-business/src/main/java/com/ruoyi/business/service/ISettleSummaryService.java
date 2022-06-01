package com.ruoyi.business.service;

import java.util.List;

import com.ruoyi.business.domain.SettleSummary;
import com.ruoyi.business.domain.SettleSummarySettle;
import com.ruoyi.business.domain.param.SettleSummaryAddParam;
import com.ruoyi.business.domain.param.SettleSummarySearchParam;
import com.ruoyi.business.domain.vo.SeSummaryVo;
import com.ruoyi.business.domain.vo.SettleDetailVo;
import com.ruoyi.business.domain.vo.SettleSumVo;

/**
 * 进度对账单汇总Service接口
 *
 * @author ruoyi
 * @date 2022-05-06
 */
public interface ISettleSummaryService {
    /**
     * 查询进度对账单汇总
     *
     * @param id 进度对账单汇总主键
     * @return 进度对账单汇总
     */
    SettleSumVo selectSettleSummaryById(Long id);

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
     * @param param 进度对账单汇总参数
     * @return 结果
     */
    int insertSettleSummary(SettleSummaryAddParam param);

    /**
     * 修改进度对账单汇总
     *
     * @param settleSummary 进度对账单汇总
     * @return 结果
     */
    int updateSettleSummary(SettleSummary settleSummary);

    /**
     * 批量删除进度对账单汇总
     *
     * @param ids 需要删除的进度对账单汇总主键集合
     * @return 结果
     */
    int deleteSettleSummaryByIds(Long[] ids);

    /**
     * 删除进度对账单汇总信息
     *
     * @param id 进度对账单汇总主键
     * @return 结果
     */
    int deleteSettleSummaryById(Long id);

    /**
     * 进度对账单汇总
     * @param ids 参数
     * @return 进度对账汇总信息
     */
    SettleSumVo summary(Long[] ids);

    /**
     * 获取进度对账单明细全部信息
     *
     * @param id 进度对账单主键id
     * @return 进度对账单明细全部信息
     */
    SettleDetailVo getSettleDetail(Long id);
}
