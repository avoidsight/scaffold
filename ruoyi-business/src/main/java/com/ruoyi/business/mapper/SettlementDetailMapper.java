package com.ruoyi.business.mapper;

import java.util.List;

import com.ruoyi.business.domain.SettlementDetail;
import org.apache.ibatis.annotations.Param;

/**
 * 结算明细Mapper接口
 *
 * @author ruoyi
 * @date 2022-05-06
 */
public interface SettlementDetailMapper {
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
     * 通过结算单id获取出入库单id
     * @param longList
     * @return
     */
    List<Long> selectInventoryId(Long[] longList);

    /**
     * 新增结算明细
     *
     * @param settlementDetail 结算明细
     * @return 结果
     */
    int insertSettlementDetail(SettlementDetail settlementDetail);

    int batchSaveSettlementDetail(List<SettlementDetail> settlementDetailList);

    int updateBatchSettlementDetail(List<SettlementDetail> settlementDetailList);
    /**
     * 修改结算明细
     *
     * @param settlementDetail 结算明细
     * @return 结果
     */
    int updateSettlementDetail(SettlementDetail settlementDetail);

    /**
     * 删除结算明细
     *
     * @param id 结算明细主键
     * @return 结果
     */
    int deleteSettlementDetailById(Long id);

    /**
     * 批量删除结算明细
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    int deleteSettlementDetailByIds(Long[] ids);
}
