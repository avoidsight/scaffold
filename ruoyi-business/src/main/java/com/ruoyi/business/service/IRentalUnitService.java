package com.ruoyi.business.service;

import java.util.List;

import com.ruoyi.business.domain.RentalUnit;

/**
 * 租赁商Service接口
 *
 * @author ruoyi
 * @date 2022-05-09
 */
public interface IRentalUnitService {
    /**
     * 查询租赁商
     *
     * @param id 租赁商主键
     * @return 租赁商
     */
    RentalUnit selectRentalUnitById(Long id);

    /**
     * 查询租赁商列表
     *
     * @param rentalUnit 租赁商
     * @return 租赁商集合
     */
    List<RentalUnit> selectRentalUnitList(RentalUnit rentalUnit);

    /**
     * 新增租赁商
     *
     * @param rentalUnit 租赁商
     * @return 结果
     */
    int insertRentalUnit(RentalUnit rentalUnit);

    /**
     * 修改租赁商
     *
     * @param rentalUnit 租赁商
     * @return 结果
     */
    int updateRentalUnit(RentalUnit rentalUnit);

    /**
     * 批量删除租赁商
     *
     * @param ids 需要删除的租赁商主键集合
     * @return 结果
     */
    int deleteRentalUnitByIds(Long[] ids);

    /**
     * 删除租赁商信息
     *
     * @param id 租赁商主键
     * @return 结果
     */
    int deleteRentalUnitById(Long id);
}
