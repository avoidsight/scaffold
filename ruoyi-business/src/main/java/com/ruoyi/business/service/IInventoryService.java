package com.ruoyi.business.service;

import java.util.List;

import com.ruoyi.business.domain.Inventory;
import com.ruoyi.business.domain.param.InventoryBookParam;
import com.ruoyi.business.domain.param.InventoryParam;
import com.ruoyi.business.domain.vo.InventoryBookVo;
import com.ruoyi.business.domain.vo.InventoryResultVo;
import com.ruoyi.business.domain.vo.InventoryVo;

/**
 * 库存出入库Service接口
 *
 * @author ruoyi
 * @date 2022-03-11
 */
public interface IInventoryService {
    /**
     * 查询库存出入库
     *
     * @param id 库存出入库主键
     * @return 库存出入库
     */
    InventoryResultVo selectInventoryById(Long id);

    /**
     * 查询库存出入库列表
     *
     * @param inventory 库存出入库
     * @return 库存出入库集合
     */
    List<InventoryVo> selectInventoryList(InventoryParam inventory);

    /**
     * 查询出入库单台账
     * @param param 台账查询参数
     * @return 出入库台账集合
     */
    List<InventoryBookVo> selectInventoryBookList(InventoryBookParam param);

    /**
     * 新增库存出入库
     *
     * @param inventory 库存出入库
     * @return 结果
     */
    int insertInventory(Inventory inventory);

    /**
     * 修改库存出入库
     *
     * @param inventory 库存出入库
     * @return 结果
     */
    int updateInventory(Inventory inventory);

    /**
     * 批量删除库存出入库
     *
     * @param ids 需要删除的库存出入库主键集合
     * @return 结果
     */
    int deleteInventoryByIds(Long[] ids);

    /**
     * 删除库存出入库信息
     *
     * @param id 库存出入库主键
     * @return 结果
     */
    int deleteInventoryById(Long id);
}
