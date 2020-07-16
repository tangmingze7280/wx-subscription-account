package cn.wx.mzpro.wxentrance.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.wx.mzpro.wxentrance.entity.WxCron;
import cn.wx.mzpro.wxentrance.mapper.WxCronMapper;
import cn.wx.mzpro.wxentrance.service.IWxCronService;
import cn.wx.mzpro.wxentrance.util.PageQuery;
import cn.wx.mzpro.wxentrance.util.Result;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 
 * @since 2020-07-16
 */
@Service
@Transactional
@SuppressWarnings("all")
@Slf4j
public class WxCronServiceImpl extends ServiceImpl<WxCronMapper, WxCron> implements IWxCronService {

    @Autowired
    private WxCronMapper wxCronMapper;

    @Override
    public Result<?> deleteById(int id) {
        WxCron wxCron = wxCronMapper.selectById(id);
        // wxCron.setIsDelete(true);
        // wxCron.setModifyTime(new Timestamp(new Date().getTime()));
        int i = wxCronMapper.updateById(wxCron );
        if (i > 0) {
            return Result.info("删除成功！");
        }
        return Result.info("删除失败！");
    }

    @Override
    public Result<IPage<WxCron>> queryByPage(PageQuery pageQuery) {
        Map<String,String> queryMap = new HashMap<>();
        QueryWrapper<WxCron> queryWrapper = new QueryWrapper<WxCron>();
        if (StringUtils.isNotBlank(pageQuery.getFilter())) {
            // 处理查询条件
            queryMap = pageQuery.convertFilterToMap();
            // queryWrapper.lambda().like(WxCron::getName, queryMap.get("name"));
        }

        // queryWrapper.lambda().eq(WxCron::getIsDelete, 0);
        queryWrapper.orderByDesc("id");
        IPage<WxCron> page = new Page<WxCron>(pageQuery.getPage(), pageQuery.getSize());
        page = wxCronMapper.selectPage(page, queryWrapper);
        return Result.info("列表" , page);
    }

}
