package com.ruoyi.business.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.business.mapper.ManufacturerMapper;
import com.ruoyi.business.domain.Manufacturer;
import com.ruoyi.business.service.IManufacturerService;

/**
 * 生产商Service业务层处理
 *
 * @author ruoyi
 * @date 2022-05-09
 */
@Service
public class ManufacturerServiceImpl implements IManufacturerService {
    @Autowired
    private ManufacturerMapper manufacturerMapper;

    /**
     * 查询生产商
     *
     * @param id 生产商主键
     * @return 生产商
     */
    @Override
    public Manufacturer selectManufacturerById(Long id) {
        return manufacturerMapper.selectManufacturerById(id);
    }

    /**
     * 查询生产商列表
     *
     * @param manufacturer 生产商
     * @return 生产商
     */
    @Override
    public List<Manufacturer> selectManufacturerList(Manufacturer manufacturer) {
        return manufacturerMapper.selectManufacturerList(manufacturer);
    }

    /**
     * 新增生产商
     *
     * @param manufacturer 生产商
     * @return 结果
     */
    @Override
    public int insertManufacturer(Manufacturer manufacturer) {
        manufacturer.setCreateTime(DateUtils.getNowDate());
        return manufacturerMapper.insertManufacturer(manufacturer);
    }

    /**
     * 修改生产商
     *
     * @param manufacturer 生产商
     * @return 结果
     */
    @Override
    public int updateManufacturer(Manufacturer manufacturer) {
        manufacturer.setUpdateTime(DateUtils.getNowDate());
        return manufacturerMapper.updateManufacturer(manufacturer);
    }

    /**
     * 批量删除生产商
     *
     * @param ids 需要删除的生产商主键
     * @return 结果
     */
    @Override
    public int deleteManufacturerByIds(Long[] ids) {
        return manufacturerMapper.deleteManufacturerByIds(ids);
    }

    /**
     * 删除生产商信息
     *
     * @param id 生产商主键
     * @return 结果
     */
    @Override
    public int deleteManufacturerById(Long id) {
        return manufacturerMapper.deleteManufacturerById(id);
    }
}
