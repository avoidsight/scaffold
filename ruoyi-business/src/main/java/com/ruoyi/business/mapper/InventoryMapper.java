package com.ruoyi.business.mapper;

import com.ruoyi.business.domain.Inventory;
import com.ruoyi.business.domain.InventoryDetail;
import com.ruoyi.business.domain.InventoryFee;
import com.ruoyi.business.domain.Settle;
import com.ruoyi.business.domain.param.InventoryBookParam;
import com.ruoyi.business.domain.param.InventoryParam;
import com.ruoyi.business.domain.vo.InventoryBookVo;
import com.ruoyi.business.domain.vo.InventoryFeeVo;
import com.ruoyi.business.domain.vo.InventoryResultVo;
import com.ruoyi.business.domain.vo.InventoryVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 库存出入库Mapper接口
 *
 * @author ruoyi
 * @date 2022-03-11
 */
public interface InventoryMapper {
    /**
     * 查询库存出入库
     *
     * @param id 库存出入库主键
     * @return 库存出入库
     */
    InventoryResultVo selectInventoryById(Long id);

    /**
     * 查询出入库汇总数据
     * @param inventoryIds 出入库单id
     * @return 进度单
     */
    Settle selectSettle(Long[] inventoryIds);

    /**
     * 查询杂费明细
     * @param inventoryId 出入库单id
     * @return 杂费明细
     */
    List<InventoryFeeVo> selectInventoryFee(Long inventoryId);

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
     * 删除库存出入库
     *
     * @param id 库存出入库主键
     * @return 结果
     */
    int deleteInventoryById(Long id);

    /**
     * 批量删除库存出入库
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    int deleteInventoryByIds(Long[] ids);

    /**
     * 批量删除库存出入库明细
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    int deleteInventoryDetailByInventoryIds(Long[] ids);

    /**
     * 批量新增库存出入库明细
     *
     * @param inventoryDetailList 库存出入库明细列表
     * @return 结果
     */
    int batchInventoryDetail(List<InventoryDetail> inventoryDetailList);


    /**
     * 通过库存出入库主键删除库存出入库明细信息
     *
     * @param id 库存出入库ID
     * @return 结果
     */
    int deleteInventoryDetailByInventoryId(Long id);

    /**
     * 批量删除库存出入库杂费明细
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    int deleteInventoryFeeByInventoryIds(Long[] ids);

    /**
     * 批量新增库存出入库杂费明细
     *
     * @param inventoryFeeList 库存出入库杂费明细列表
     * @return 结果
     */
    int batchInventoryFee(List<InventoryFee> inventoryFeeList);


    /**
     * 通过库存出入库主键删除库存出入库杂费明细信息
     *
     * @param id 库存出入库ID
     * @return 结果
     */
    int deleteInventoryFeeByInventoryId(Long id);

    /**
     * 根据主键id更新statistics_status
     * @param idList
     * @return
     */
    int updateStatisticsStatusById(@Param("idList")List<Long> idList,@Param("status")Long status);

    /**
     * 根据id获取附件
     * @param idList
     * @return
     */
    List<String> selectResourcesById(@Param("idList")List<Long> idList);
}
