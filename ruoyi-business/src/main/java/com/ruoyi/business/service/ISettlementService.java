package com.ruoyi.business.service;

import java.util.List;
import java.util.Map;

import com.ruoyi.business.domain.Settlement;
import com.ruoyi.business.domain.param.BillingAccountParam;
import com.ruoyi.business.domain.vo.LeaseSettlementChecklistHeaderVo;
import com.ruoyi.business.domain.vo.LeaseSettlementChecklistVo;
import com.ruoyi.business.domain.vo.LeaseSettlementVo;
import com.ruoyi.business.domain.vo.SettlementVo;

/**
 * 结算Service接口
 *
 * @author ruoyi
 * @date 2022-05-06
 */
public interface ISettlementService {
    /**
     * 查询结算
     *
     * @param id 结算主键
     * @return 结算
     */
    Settlement selectSettlementById(Long id);

    /**
     * 查询结算列表
     *
     * @param billingAccountParam 结算
     * @return 结算集合
     */
    List<SettlementVo> selectSettlementList(BillingAccountParam billingAccountParam);

    /**
     * 新增结算
     *
     * @param settlement 结算
     * @return 结果
     */
    int insertSettlement(LeaseSettlementVo settlement);

    /**
     * 修改结算
     *
     * @param settlement 结算
     * @return 结果
     */
    int updateSettlement(Settlement settlement);

    /**
     * 批量删除结算
     *
     * @param ids 需要删除的结算主键集合
     * @return 结果
     */
    int deleteSettlementByIds(Long[] ids);

    /**
     * 删除结算信息
     *
     * @param id 结算主键
     * @return 结果
     */
    int deleteSettlementById(Long id);

    /**
     * 租赁结算清单查询结算列表
     * @param id 进度对账单id
     * @return
     */
    List<LeaseSettlementChecklistVo> listLeaseSettlement(Long id);


    /**
     * 租赁结算清单查询结算列表(编辑进入)
     * @param id 进度对账单id
     * @return
     */
    List<LeaseSettlementChecklistVo> listLeaseSettlementEdit(Long id);

    /**
     *查询要结算的头部信息
     * @param id 进度对账单id
     * @return
     */
    LeaseSettlementChecklistHeaderVo getLeaseSettlementChecklistHeaderById(Long id);
}
