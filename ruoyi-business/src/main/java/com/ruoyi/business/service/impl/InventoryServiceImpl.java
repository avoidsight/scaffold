package com.ruoyi.business.service.impl;

import com.ruoyi.business.domain.Inventory;
import com.ruoyi.business.domain.InventoryDetail;
import com.ruoyi.business.domain.InventoryFee;
import com.ruoyi.business.domain.param.InventoryBookParam;
import com.ruoyi.business.domain.param.InventoryParam;
import com.ruoyi.business.domain.vo.InventoryBookVo;
import com.ruoyi.business.domain.vo.InventoryFeeVo;
import com.ruoyi.business.domain.vo.InventoryResultVo;
import com.ruoyi.business.domain.vo.InventoryVo;
import com.ruoyi.business.mapper.InventoryMapper;
import com.ruoyi.business.service.IContractService;
import com.ruoyi.business.service.IInventoryService;
import com.ruoyi.common.annotation.DataScope;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 库存出入库Service业务层处理
 *
 * @author ruoyi
 * @date 2022-03-11
 */
@Service
public class InventoryServiceImpl implements IInventoryService {
    @Autowired
    private InventoryMapper inventoryMapper;

    @Autowired
    private IContractService contractService;

    /**
     * 查询库存出入库
     *
     * @param id 库存出入库主键
     * @return 库存出入库
     */
    @Override
    public InventoryResultVo selectInventoryById(Long id) {
        InventoryResultVo inventory = inventoryMapper.selectInventoryById(id);
        List<InventoryFeeVo> inventoryDetailVoList = inventoryMapper.selectInventoryFee(id);
        inventory.setInventoryFeeList(inventoryDetailVoList);
        inventory.setContractVo(contractService.selectContractById(inventory.getContractId()));
        return inventory;
    }

    /**
     * 查询库存出入库列表
     *
     * @param inventory 库存出入库
     * @return 库存出入库
     */
    @Override
    @DataScope(deptAlias = "d", userAlias = "i")
    public List<InventoryVo> selectInventoryList(InventoryParam inventory) {
        return inventoryMapper.selectInventoryList(inventory);
    }

    @Override
    public List<InventoryBookVo> selectInventoryBookList(InventoryBookParam param) {
        return inventoryMapper.selectInventoryBookList(param);
    }

    /**
     * 新增库存出入库
     *
     * @param inventory 库存出入库
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertInventory(Inventory inventory) {
        int rows = inventoryMapper.insertInventory(inventory);
        insertInventoryDetail(inventory);
        insertInventoryFee(inventory);
        return rows;
    }

    /**
     * 修改库存出入库
     *
     * @param inventory 库存出入库
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateInventory(Inventory inventory) {
        inventoryMapper.deleteInventoryDetailByInventoryId(inventory.getId());
        inventoryMapper.deleteInventoryFeeByInventoryId(inventory.getId());
        insertInventoryDetail(inventory);
        insertInventoryFee(inventory);
        return inventoryMapper.updateInventory(inventory);
    }

    /**
     * 批量删除库存出入库
     *
     * @param ids 需要删除的库存出入库主键
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteInventoryByIds(Long[] ids) {
        inventoryMapper.deleteInventoryDetailByInventoryIds(ids);
        inventoryMapper.deleteInventoryFeeByInventoryIds(ids);
        return inventoryMapper.deleteInventoryByIds(ids);
    }

    /**
     * 删除库存出入库信息
     *
     * @param id 库存出入库主键
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteInventoryById(Long id) {
        inventoryMapper.deleteInventoryDetailByInventoryId(id);
        inventoryMapper.deleteInventoryFeeByInventoryId(id);
        return inventoryMapper.deleteInventoryById(id);
    }

    /**
     * 新增库存出入库明细信息
     *
     * @param inventory 库存出入库对象
     */
    public void insertInventoryDetail(Inventory inventory) {
        List<InventoryDetail> inventoryDetailList = inventory.getInventoryDetailList();
        Long id = inventory.getId();
        if (StringUtils.isNotNull(inventoryDetailList)) {
            List<InventoryDetail> list = new ArrayList<InventoryDetail>();
            for (InventoryDetail inventoryDetail : inventoryDetailList) {
                inventoryDetail.setInventoryId(id);
                inventoryDetail.create();
                list.add(inventoryDetail);
            }
            if (list.size() > 0) {
                inventoryMapper.batchInventoryDetail(list);
            }
        }
    }

    /**
     * 新增库存出入库杂费明细信息
     *
     * @param inventory 库存出入库对象
     */
    public void insertInventoryFee(Inventory inventory) {
        List<InventoryFee> inventoryFeeList = inventory.getInventoryFeeList();
        Long id = inventory.getId();
        if (StringUtils.isNotNull(inventoryFeeList)) {
            List<InventoryFee> list = new ArrayList<InventoryFee>();
            for (InventoryFee inventoryFee :inventoryFeeList)
            {
                inventoryFee.setInventoryId(id);
                inventoryFee.create();
                list.add(inventoryFee);
            }
            if (list.size() > 0) {
                inventoryMapper.batchInventoryFee(list);
            }
        }
    }
}