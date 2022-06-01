package com.ruoyi.business.service.impl;

import com.ruoyi.business.domain.vo.InventoryDetailVo;
import com.ruoyi.business.domain.vo.StockAmountVo;
import com.ruoyi.business.mapper.StockMapper;
import com.ruoyi.business.service.IStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockServiceImpl implements IStockService {
    @Autowired
    private StockMapper stockMapper;

    @Override
    public StockAmountVo selectRealtimeStockAmount() {
        return stockMapper.selectRealtimeStockAmount().calculate();
    }

    @Override
    public List<InventoryDetailVo> selectRealtimeStockDetail() {
        return stockMapper.selectRealtimeStockDetail();
    }

    @Override
    public List<InventoryDetailVo> selectLongRentalDetail() {
        return stockMapper.selectLongRentalDetail();
    }
}
