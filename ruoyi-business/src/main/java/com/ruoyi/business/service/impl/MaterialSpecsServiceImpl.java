package com.ruoyi.business.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.business.mapper.MaterialSpecsMapper;
import com.ruoyi.business.domain.MaterialSpecs;
import com.ruoyi.business.service.IMaterialSpecsService;

/**
 * 物料规格Service业务层处理
 *
 * @author ruoyi
 * @date 2022-03-18
 */
@Service
public class MaterialSpecsServiceImpl implements IMaterialSpecsService {
    @Autowired
    private MaterialSpecsMapper materialSpecsMapper;

    /**
     * 查询物料规格
     *
     * @param id 物料规格主键
     * @return 物料规格
     */
    @Override
    public MaterialSpecs selectMaterialSpecsById(Long id) {
        return materialSpecsMapper.selectMaterialSpecsById(id);
    }

    /**
     * 查询物料规格列表
     *
     * @param materialSpecs 物料规格
     * @return 物料规格
     */
    @Override
    public List<MaterialSpecs> selectMaterialSpecsList(MaterialSpecs materialSpecs) {
        return materialSpecsMapper.selectMaterialSpecsList(materialSpecs);
    }

    /**
     * 新增物料规格
     *
     * @param materialSpecs 物料规格
     * @return 结果
     */
    @Override
    public int insertMaterialSpecs(MaterialSpecs materialSpecs) {
        materialSpecs.setCreateTime(DateUtils.getNowDate());
        return materialSpecsMapper.insertMaterialSpecs(materialSpecs);
    }

    /**
     * 修改物料规格
     *
     * @param materialSpecs 物料规格
     * @return 结果
     */
    @Override
    public int updateMaterialSpecs(MaterialSpecs materialSpecs) {
        materialSpecs.setUpdateTime(DateUtils.getNowDate());
        return materialSpecsMapper.updateMaterialSpecs(materialSpecs);
    }

    /**
     * 批量删除物料规格
     *
     * @param ids 需要删除的物料规格主键
     * @return 结果
     */
    @Override
    public int deleteMaterialSpecsByIds(Long[] ids) {
        return materialSpecsMapper.deleteMaterialSpecsByIds(ids);
    }

    /**
     * 删除物料规格信息
     *
     * @param id 物料规格主键
     * @return 结果
     */
    @Override
    public int deleteMaterialSpecsById(Long id) {
        return materialSpecsMapper.deleteMaterialSpecsById(id);
    }
}
