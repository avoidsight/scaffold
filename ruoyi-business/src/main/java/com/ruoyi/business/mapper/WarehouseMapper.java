package com.ruoyi.business.mapper;

import java.util.List;

import com.ruoyi.business.domain.Warehouse;

/**
 * 仓库管理Mapper接口
 *
 * @author ruoyi
 * @date 2022-03-04
 */
public interface WarehouseMapper {
    /**
     * 查询仓库管理
     *
     * @param id 仓库管理主键
     * @return 仓库管理
     */
    public Warehouse selectWarehouseById(Long id);

    /**
     * 查询仓库管理列表
     *
     * @param warehouse 仓库管理
     * @return 仓库管理集合
     */
    public List<Warehouse> selectWarehouseList(Warehouse warehouse);

    /**
     * 新增仓库管理
     *
     * @param warehouse 仓库管理
     * @return 结果
     */
    public int insertWarehouse(Warehouse warehouse);

    /**
     * 修改仓库管理
     *
     * @param warehouse 仓库管理
     * @return 结果
     */
    public int updateWarehouse(Warehouse warehouse);

    /**
     * 删除仓库管理
     *
     * @param id 仓库管理主键
     * @return 结果
     */
    public int deleteWarehouseById(Long id);

    /**
     * 批量删除仓库管理
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteWarehouseByIds(Long[] ids);
}
