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
import com.ruoyi.business.domain.Lessee;
import com.ruoyi.business.service.ILesseeService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 承租人Controller
 *
 * @author ruoyi
 * @date 2022-03-04
 */
@Api(tags = "承租人")
@RestController
@RequestMapping("/api/v2/business/lessee" )
public class LesseeController extends BaseController {
    @Autowired
    private ILesseeService lesseeService;

    /**
     * 查询承租人列表
     */
    @ApiOperation("查询承租人列表")
    // @PreAuthorize("@ss.hasPermi('business:lessee:list')" )
    @GetMapping("/list" )
    public TableDataInfo list(Lessee lessee) {
        startPage();
        List<Lessee> list = lesseeService.selectLesseeList(lessee);
        return getDataTable(list);
    }

    /**
     * 导出承租人列表
     */
    @ApiOperation("导出承租人列表")
    // @PreAuthorize("@ss.hasPermi('business:lessee:export')" )
    @Log(title = "承租人" , businessType = BusinessType.EXPORT)
    @PostMapping("/export" )
    public void export(HttpServletResponse response, Lessee lessee) {
        List<Lessee> list = lesseeService.selectLesseeList(lessee);
        ExcelUtil<Lessee> util = new ExcelUtil<Lessee>(Lessee. class);
        util.exportExcel(response, list, "承租人数据" );
    }

    /**
     * 获取承租人详细信息
     */
    @ApiOperation("获取承租人详细信息")
    // @PreAuthorize("@ss.hasPermi('business:lessee:query')" )
    @GetMapping(value = "/{id}" )
    public AjaxResult getInfo(@PathVariable("id" ) Long id) {
        return AjaxResult.success(lesseeService.selectLesseeById(id));
    }

    /**
     * 新增承租人
     */
    @ApiOperation("新增承租人")
    // @PreAuthorize("@ss.hasPermi('business:lessee:add')" )
    @Log(title = "承租人" , businessType = BusinessType.INSERT)
    @PostMapping("/add")
    public AjaxResult add(@RequestBody Lessee lessee) {
        lessee.setCreateBy(getUsername());
        return toAjax(lesseeService.insertLessee(lessee));
    }

    /**
     * 修改承租人
     */
    @ApiOperation("修改承租人")
    // @PreAuthorize("@ss.hasPermi('business:lessee:edit')" )
    @Log(title = "承租人" , businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    public AjaxResult edit(@RequestBody Lessee lessee) {
        lessee.setUpdateBy(getUsername());
        return toAjax(lesseeService.updateLessee(lessee));
    }

    /**
     * 删除承租人
     */
    @ApiOperation("删除承租人")
    // @PreAuthorize("@ss.hasPermi('business:lessee:remove')" )
    @Log(title = "承租人" , businessType = BusinessType.DELETE)
    @PostMapping("/delete/{ids}" )
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(lesseeService.deleteLesseeByIds(ids));
    }
}
