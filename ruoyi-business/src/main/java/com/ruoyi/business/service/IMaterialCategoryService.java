package com.ruoyi.business.service;

import java.util.List;

import com.ruoyi.business.domain.MaterialCategory;

/**
 * 物料分类Service接口
 *
 * @author ruoyi
 * @date 2022-03-23
 */
public interface IMaterialCategoryService {
    /**
     * 查询物料分类
     *
     * @param id 物料分类主键
     * @return 物料分类
     */
    MaterialCategory selectMaterialCategoryById(Long id);

    /**
     * 查询物料分类列表
     *
     * @param materialCategory 物料分类
     * @return 物料分类集合
     */
    List<MaterialCategory> selectMaterialCategoryList(MaterialCategory materialCategory);

    /**
     * 新增物料分类
     *
     * @param materialCategory 物料分类
     * @return 结果
     */
    int insertMaterialCategory(MaterialCategory materialCategory);

    /**
     * 修改物料分类
     *
     * @param materialCategory 物料分类
     * @return 结果
     */
    int updateMaterialCategory(MaterialCategory materialCategory);

    /**
     * 批量删除物料分类
     *
     * @param ids 需要删除的物料分类主键集合
     * @return 结果
     */
    int deleteMaterialCategoryByIds(Long[] ids);

    /**
     * 删除物料分类信息
     *
     * @param id 物料分类主键
     * @return 结果
     */
    int deleteMaterialCategoryById(Long id);
}
