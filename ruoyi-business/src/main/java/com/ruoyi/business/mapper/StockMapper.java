package com.ruoyi.business.mapper;

import com.ruoyi.business.domain.vo.InventoryDetailVo;
import com.ruoyi.business.domain.vo.StockAmountVo;

import java.util.List;

public interface StockMapper {
    /**
     * 查询库存实况
     * @return 库存实况
     */
    StockAmountVo selectRealtimeStockAmount();

    /**
     * 查询实时库存明细
     * @return 实时库存明细
     */
    List<InventoryDetailVo> selectRealtimeStockDetail();

    /**
     * 查询长期租赁明细
     * @return 长期租赁明细
     */
    List<InventoryDetailVo> selectLongRentalDetail();
}
