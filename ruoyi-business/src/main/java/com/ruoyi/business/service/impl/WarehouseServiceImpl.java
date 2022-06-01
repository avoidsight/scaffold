package com.ruoyi.business.service.impl;

import java.util.List;
        import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.business.mapper.WarehouseMapper;
import com.ruoyi.business.domain.Warehouse;
import com.ruoyi.business.service.IWarehouseService;

/**
 * 仓库管理Service业务层处理
 *
 * @author ruoyi
 * @date 2022-03-04
 */
@Service
public class WarehouseServiceImpl implements IWarehouseService {
    @Autowired
    private WarehouseMapper warehouseMapper;

    /**
     * 查询仓库管理
     *
     * @param id 仓库管理主键
     * @return 仓库管理
     */
    @Override
    public Warehouse selectWarehouseById(Long id) {
        return warehouseMapper.selectWarehouseById(id);
    }

    /**
     * 查询仓库管理列表
     *
     * @param warehouse 仓库管理
     * @return 仓库管理
     */
    @Override
    public List<Warehouse> selectWarehouseList(Warehouse warehouse) {
        return warehouseMapper.selectWarehouseList(warehouse);
    }

    /**
     * 新增仓库管理
     *
     * @param warehouse 仓库管理
     * @return 结果
     */
    @Override
    public int insertWarehouse(Warehouse warehouse) {
                warehouse.setCreateTime(DateUtils.getNowDate());
            return warehouseMapper.insertWarehouse(warehouse);
    }

    /**
     * 修改仓库管理
     *
     * @param warehouse 仓库管理
     * @return 结果
     */
    @Override
    public int updateWarehouse(Warehouse warehouse) {
                warehouse.setUpdateTime(DateUtils.getNowDate());
        return warehouseMapper.updateWarehouse(warehouse);
    }

    /**
     * 批量删除仓库管理
     *
     * @param ids 需要删除的仓库管理主键
     * @return 结果
     */
    @Override
    public int deleteWarehouseByIds(Long[] ids) {
        return warehouseMapper.deleteWarehouseByIds(ids);
    }

    /**
     * 删除仓库管理信息
     *
     * @param id 仓库管理主键
     * @return 结果
     */
    @Override
    public int deleteWarehouseById(Long id) {
        return warehouseMapper.deleteWarehouseById(id);
    }
}
