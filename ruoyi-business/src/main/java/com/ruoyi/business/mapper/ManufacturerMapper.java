package com.ruoyi.business.mapper;

import java.util.List;

import com.ruoyi.business.domain.Manufacturer;

/**
 * 生产商Mapper接口
 *
 * @author ruoyi
 * @date 2022-05-09
 */
public interface ManufacturerMapper {
    /**
     * 查询生产商
     *
     * @param id 生产商主键
     * @return 生产商
     */
    Manufacturer selectManufacturerById(Long id);

    /**
     * 查询生产商列表
     *
     * @param manufacturer 生产商
     * @return 生产商集合
     */
    List<Manufacturer> selectManufacturerList(Manufacturer manufacturer);

    /**
     * 新增生产商
     *
     * @param manufacturer 生产商
     * @return 结果
     */
    int insertManufacturer(Manufacturer manufacturer);

    /**
     * 修改生产商
     *
     * @param manufacturer 生产商
     * @return 结果
     */
    int updateManufacturer(Manufacturer manufacturer);

    /**
     * 删除生产商
     *
     * @param id 生产商主键
     * @return 结果
     */
    int deleteManufacturerById(Long id);

    /**
     * 批量删除生产商
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    int deleteManufacturerByIds(Long[] ids);
}
