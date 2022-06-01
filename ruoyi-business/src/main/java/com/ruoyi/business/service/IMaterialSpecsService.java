package com.ruoyi.business.service;

import java.util.List;

import com.ruoyi.business.domain.MaterialSpecs;

/**
 * 物料规格Service接口
 *
 * @author ruoyi
 * @date 2022-03-18
 */
public interface IMaterialSpecsService {
    /**
     * 查询物料规格
     *
     * @param id 物料规格主键
     * @return 物料规格
     */
    MaterialSpecs selectMaterialSpecsById(Long id);

    /**
     * 查询物料规格列表
     *
     * @param materialSpecs 物料规格
     * @return 物料规格集合
     */
    List<MaterialSpecs> selectMaterialSpecsList(MaterialSpecs materialSpecs);

    /**
     * 新增物料规格
     *
     * @param materialSpecs 物料规格
     * @return 结果
     */
    int insertMaterialSpecs(MaterialSpecs materialSpecs);

    /**
     * 修改物料规格
     *
     * @param materialSpecs 物料规格
     * @return 结果
     */
    int updateMaterialSpecs(MaterialSpecs materialSpecs);

    /**
     * 批量删除物料规格
     *
     * @param ids 需要删除的物料规格主键集合
     * @return 结果
     */
    int deleteMaterialSpecsByIds(Long[] ids);

    /**
     * 删除物料规格信息
     *
     * @param id 物料规格主键
     * @return 结果
     */
    int deleteMaterialSpecsById(Long id);
}
