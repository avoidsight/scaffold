package com.ruoyi.business.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.business.mapper.RentalUnitMapper;
import com.ruoyi.business.domain.RentalUnit;
import com.ruoyi.business.service.IRentalUnitService;

/**
 * 租赁商Service业务层处理
 *
 * @author ruoyi
 * @date 2022-05-09
 */
@Service
public class RentalUnitServiceImpl implements IRentalUnitService {
    @Autowired
    private RentalUnitMapper rentalUnitMapper;

    /**
     * 查询租赁商
     *
     * @param id 租赁商主键
     * @return 租赁商
     */
    @Override
    public RentalUnit selectRentalUnitById(Long id) {
        return rentalUnitMapper.selectRentalUnitById(id);
    }

    /**
     * 查询租赁商列表
     *
     * @param rentalUnit 租赁商
     * @return 租赁商
     */
    @Override
    public List<RentalUnit> selectRentalUnitList(RentalUnit rentalUnit) {
        return rentalUnitMapper.selectRentalUnitList(rentalUnit);
    }

    /**
     * 新增租赁商
     *
     * @param rentalUnit 租赁商
     * @return 结果
     */
    @Override
    public int insertRentalUnit(RentalUnit rentalUnit) {
        rentalUnit.setCreateTime(DateUtils.getNowDate());
        return rentalUnitMapper.insertRentalUnit(rentalUnit);
    }

    /**
     * 修改租赁商
     *
     * @param rentalUnit 租赁商
     * @return 结果
     */
    @Override
    public int updateRentalUnit(RentalUnit rentalUnit) {
        rentalUnit.setUpdateTime(DateUtils.getNowDate());
        return rentalUnitMapper.updateRentalUnit(rentalUnit);
    }

    /**
     * 批量删除租赁商
     *
     * @param ids 需要删除的租赁商主键
     * @return 结果
     */
    @Override
    public int deleteRentalUnitByIds(Long[] ids) {
        return rentalUnitMapper.deleteRentalUnitByIds(ids);
    }

    /**
     * 删除租赁商信息
     *
     * @param id 租赁商主键
     * @return 结果
     */
    @Override
    public int deleteRentalUnitById(Long id) {
        return rentalUnitMapper.deleteRentalUnitById(id);
    }
}
