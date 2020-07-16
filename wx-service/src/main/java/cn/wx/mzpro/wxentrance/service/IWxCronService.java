package cn.wx.mzpro.wxentrance.service;

import cn.wx.mzpro.wxentrance.entity.WxCron;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import cn.wx.mzpro.wxentrance.util.PageQuery;
import cn.wx.mzpro.wxentrance.util.Result;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 
 * @since 2020-07-16
 */

public interface IWxCronService extends IService<WxCron> {

    Result<?> deleteById(int id);

    Result<IPage<WxCron>> queryByPage(PageQuery pageQuery);

}
