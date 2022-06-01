package com.ruoyi.business.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.business.domain.Lessor;
import com.ruoyi.business.service.ILessorService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 出租人Controller
 *
 * @author ruoyi
 * @date 2022-03-04
 */
@Api(tags = "出租人")
@RestController
@RequestMapping("/api/v2/business/lessor" )
public class LessorController extends BaseController {
    @Autowired
    private ILessorService lessorService;

    /**
     * 查询出租人列表
     */
    @ApiOperation("查询出租人列表")
    // @PreAuthorize("@ss.hasPermi('business:lessor:list')" )
    @GetMapping("/list" )
    public TableDataInfo list(Lessor lessor) {
        startPage();
        List<Lessor> list = lessorService.selectLessorList(lessor);
        return getDataTable(list);
    }

    /**
     * 导出出租人列表
     */
    @ApiOperation("导出出租人列表")
    // @PreAuthorize("@ss.hasPermi('business:lessor:export')" )
    @Log(title = "出租人" , businessType = BusinessType.EXPORT)
    @PostMapping("/export" )
    public void export(HttpServletResponse response, Lessor lessor) {
        List<Lessor> list = lessorService.selectLessorList(lessor);
        ExcelUtil<Lessor> util = new ExcelUtil<Lessor>(Lessor. class);
        util.exportExcel(response, list, "出租人数据" );
    }

    /**
     * 获取出租人详细信息
     */
    @ApiOperation("获取出租人详细信息")
    // @PreAuthorize("@ss.hasPermi('business:lessor:query')" )
    @GetMapping(value = "/{id}" )
    public AjaxResult getInfo(@PathVariable("id" ) Long id) {
        return AjaxResult.success(lessorService.selectLessorById(id));
    }

    /**
     * 新增出租人
     */
    @ApiOperation("新增出租人")
    // @PreAuthorize("@ss.hasPermi('business:lessor:add')" )
    @Log(title = "出租人" , businessType = BusinessType.INSERT)
    @PostMapping("/add")
    public AjaxResult add(@RequestBody Lessor lessor) {
        lessor.setCreateBy(getUsername());
        return toAjax(lessorService.insertLessor(lessor));
    }

    /**
     * 修改出租人
     */
    @ApiOperation("修改出租人")
    // @PreAuthorize("@ss.hasPermi('business:lessor:edit')" )
    @Log(title = "出租人" , businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    public AjaxResult edit(@RequestBody Lessor lessor) {
        lessor.setUpdateBy(getUsername());
        return toAjax(lessorService.updateLessor(lessor));
    }

    /**
     * 删除出租人
     */
    @ApiOperation("删除出租人")
    // @PreAuthorize("@ss.hasPermi('business:lessor:remove')" )
    @Log(title = "出租人" , businessType = BusinessType.DELETE)
    @PostMapping("/delete/{ids}" )
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(lessorService.deleteLessorByIds(ids));
    }
}
