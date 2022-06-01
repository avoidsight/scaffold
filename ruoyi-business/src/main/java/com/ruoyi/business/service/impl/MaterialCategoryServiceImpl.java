package com.ruoyi.business.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

import com.ruoyi.common.utils.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.business.domain.MaterialSpecs;
import com.ruoyi.business.mapper.MaterialCategoryMapper;
import com.ruoyi.business.domain.MaterialCategory;
import com.ruoyi.business.service.IMaterialCategoryService;

/**
 * 物料分类Service业务层处理
 *
 * @author ruoyi
 * @date 2022-03-23
 */
@Service
public class MaterialCategoryServiceImpl implements IMaterialCategoryService {
    @Autowired
    private MaterialCategoryMapper materialCategoryMapper;

    /**
     * 查询物料分类
     *
     * @param id 物料分类主键
     * @return 物料分类
     */
    @Override
    public MaterialCategory selectMaterialCategoryById(Long id) {
        return materialCategoryMapper.selectMaterialCategoryById(id);
    }

    /**
     * 查询物料分类列表
     *
     * @param materialCategory 物料分类
     * @return 物料分类
     */
    @Override
    public List<MaterialCategory> selectMaterialCategoryList(MaterialCategory materialCategory) {
        return materialCategoryMapper.selectMaterialCategoryList(materialCategory);
    }

    /**
     * 新增物料分类
     *
     * @param materialCategory 物料分类
     * @return 结果
     */
        @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertMaterialCategory(MaterialCategory materialCategory) {
        materialCategory.setCreateTime(DateUtils.getNowDate());
        int rows = materialCategoryMapper.insertMaterialCategory(materialCategory);
        insertMaterialSpecs(materialCategory);
        return rows;
    }

    /**
     * 修改物料分类
     *
     * @param materialCategory 物料分类
     * @return 结果
     */
        @Transactional(rollbackFor = Exception.class)
    @Override
    public int updateMaterialCategory(MaterialCategory materialCategory) {
        materialCategory.setUpdateTime(DateUtils.getNowDate());
        materialCategoryMapper.deleteMaterialSpecsByCategoryCode(materialCategory.getId());
        insertMaterialSpecs(materialCategory);
        return materialCategoryMapper.updateMaterialCategory(materialCategory);
    }

    /**
     * 批量删除物料分类
     *
     * @param ids 需要删除的物料分类主键
     * @return 结果
     */
        @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteMaterialCategoryByIds(Long[] ids) {
        materialCategoryMapper.deleteMaterialSpecsByCategoryCodes(ids);
        return materialCategoryMapper.deleteMaterialCategoryByIds(ids);
    }

    /**
     * 删除物料分类信息
     *
     * @param id 物料分类主键
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteMaterialCategoryById(Long id) {
        materialCategoryMapper.deleteMaterialSpecsByCategoryCode(id);
        return materialCategoryMapper.deleteMaterialCategoryById(id);
    }

    /**
     * 新增物料规格信息
     *
     * @param materialCategory 物料分类对象
     */
    public void insertMaterialSpecs(MaterialCategory materialCategory) {
        List<MaterialSpecs> materialSpecsList = materialCategory.getMaterialSpecsList();
        Long id = materialCategory.getId();
        if (StringUtils.isNotNull(materialSpecsList)) {
            List<MaterialSpecs> list = new ArrayList<MaterialSpecs>();
            for (MaterialSpecs materialSpecs :materialSpecsList)
            {
                materialSpecs.setCategoryCode(id);
                list.add(materialSpecs);
            }
            if (list.size() > 0) {
                    materialCategoryMapper.batchMaterialSpecs(list);
            }
        }
    }
}
