package cn.wx.mzpro.wxentrance.controller;

import cn.wx.mzpro.wxentrance.entity.WxCron;
import cn.wx.mzpro.wxentrance.service.IWxCronService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import cn.wx.mzpro.wxentrance.util.PageQuery;
import cn.wx.mzpro.wxentrance.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * <p>
 *  内部接口
 * </p>
 *
 * @author 
 * @since 2020-07-16
 */
@RestController
@RequestMapping("/wxCron")
public class WxCronController {

    @Autowired
    public IWxCronService wxCronService;

    /**
    * 新增
    *
    * @param wxCron
    * @return
    */
    @RequestMapping(method = RequestMethod.POST)
    public Result<?> save(@RequestBody WxCron wxCron){
        boolean save = wxCronService.save(wxCron);
         if (save) {
            return Result.info("新增成功");
        } else {
            return Result.fail("新增失败");
        }
    }

    /**
    * 修改
    *
    * @param wxCron
    * @return
    */
    @RequestMapping(method = RequestMethod.PUT)
    public Result<WxCron> update(@RequestBody WxCron wxCron) {
        boolean save = wxCronService.updateById(wxCron);
        if (save) {
            return Result.info("修改成功");
        } else {
            return Result.fail("修改失败");
        }
    }

    /**
    * 删除
    *
    * @param id 主键id
    * @return
    */
    @RequestMapping(value = "/{id}" , method = RequestMethod.DELETE)
    public Result<?> delete(@PathVariable int id) {
        return wxCronService.deleteById(id);
    }

    /**
    * 查询详情
    *
    * @param id 主键id
    * @return
    */
    @RequestMapping(value = "/{id}" , method = RequestMethod.GET)
    public Result<WxCron> findOne(@PathVariable int id) {
        return Result.info(wxCronService.getById(id));
    }

    /**
    * 分页查询
    *
    * @param pageQuery 分页查询
    * @return
    */
    @RequestMapping(value = "queryByPage",method = RequestMethod.GET)
    public Result<IPage<WxCron>> queryByPage(PageQuery pageQuery) {
        return wxCronService.queryByPage(pageQuery);
    }
    @GetMapping("list")
    public List<WxCron> list() {
        return wxCronService.list();
    }
}
