package com.ruoyi.business.mapper;

import java.util.List;

import com.ruoyi.business.domain.MaterialCategory;
import com.ruoyi.business.domain.MaterialSpecs;

/**
 * 物料分类Mapper接口
 *
 * @author ruoyi
 * @date 2022-03-23
 */
public interface MaterialCategoryMapper {
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
     * 删除物料分类
     *
     * @param id 物料分类主键
     * @return 结果
     */
    int deleteMaterialCategoryById(Long id);

    /**
     * 批量删除物料分类
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    int deleteMaterialCategoryByIds(Long[] ids);

    /**
     * 批量删除物料规格
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    int deleteMaterialSpecsByCategoryCodes(Long[] ids);

    /**
     * 批量新增物料规格
     *
     * @param materialSpecsList 物料规格列表
     * @return 结果
     */
    int batchMaterialSpecs(List<MaterialSpecs> materialSpecsList);


    /**
     * 通过物料分类主键删除物料规格信息
     *
     * @param id 物料分类ID
     * @return 结果
     */
    int deleteMaterialSpecsByCategoryCode(Long id);
}
