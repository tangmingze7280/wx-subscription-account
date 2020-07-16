package ${package.ServiceImpl};

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import ${superServiceImplClassPackage};
import ${package.Entity}.${entity};
import ${package.Mapper}.${table.mapperName};
import ${package.Service}.${table.serviceName};
import ${cfg.parentPackage}.util.PageQuery;
import ${cfg.parentPackage}.util.Result;
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
 * ${table.comment!} 服务实现类
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
@Service
@Transactional
@SuppressWarnings("all")
@Slf4j
<#if kotlin>
open class ${table.serviceImplName} : ${superServiceImplClass}<${table.mapperName}, ${entity}>(), ${table.serviceName} {

}
<#else>
public class ${table.serviceImplName} extends ${superServiceImplClass}<${table.mapperName}, ${entity}> implements ${table.serviceName} {

    @Autowired
    private ${table.mapperName} ${table.entityPath}Mapper;

    @Override
    public Result<?> deleteById(int id) {
        ${entity} ${table.entityPath} = ${table.entityPath}Mapper.selectById(id);
        // ${table.entityPath}.setIsDelete(true);
        // ${table.entityPath}.setModifyTime(new Timestamp(new Date().getTime()));
        int i = ${table.entityPath}Mapper.updateById(${table.entityPath} );
        if (i > 0) {
            return Result.info("删除成功！");
        }
        return Result.info("删除失败！");
    }

    @Override
    public Result<IPage<${entity}>> queryByPage(PageQuery pageQuery) {
        Map<String,String> queryMap = new HashMap<>();
        QueryWrapper<${entity}> queryWrapper = new QueryWrapper<${entity}>();
        if (StringUtils.isNotBlank(pageQuery.getFilter())) {
            // 处理查询条件
            queryMap = pageQuery.convertFilterToMap();
            // queryWrapper.lambda().like(${entity}::getName, queryMap.get("name"));
        }

        // queryWrapper.lambda().eq(${entity}::getIsDelete, 0);
        queryWrapper.orderByDesc("id");
        IPage<${entity}> page = new Page<${entity}>(pageQuery.getPage(), pageQuery.getSize());
        page = ${table.entityPath}Mapper.selectPage(page, queryWrapper);
        return Result.info("${table.comment!}列表" , page);
    }

}
</#if>
