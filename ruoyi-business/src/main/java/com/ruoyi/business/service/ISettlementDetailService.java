package com.ruoyi.business.service;

import java.util.List;

import com.ruoyi.business.domain.SettlementDetail;

/**
 * 结算明细Service接口
 *
 * @author ruoyi
 * @date 2022-05-06
 */
public interface ISettlementDetailService {
    /**
     * 查询结算明细
     *
     * @param id 结算明细主键
     * @return 结算明细
     */
    SettlementDetail selectSettlementDetailById(Long id);

    /**
     * 查询结算明细列表
     *
     * @param settlementDetail 结算明细
     * @return 结算明细集合
     */
    List<SettlementDetail> selectSettlementDetailList(SettlementDetail settlementDetail);

    /**
     * 新增结算明细
     *
     * @param settlementDetail 结算明细
     * @return 结果
     */
    int insertSettlementDetail(SettlementDetail settlementDetail);

    /**
     * 修改结算明细
     *
     * @param settlementDetail 结算明细
     * @return 结果
     */
    int updateSettlementDetail(SettlementDetail settlementDetail);

    /**
     * 删除结算明细信息
     *
     * @param id 结算明细主键
     * @return 结果
     */
    int deleteSettlementDetailById(Long id);
}
