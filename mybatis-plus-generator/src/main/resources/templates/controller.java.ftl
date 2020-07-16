package ${package.Controller};

import ${package.Entity}.${entity};
import ${package.Service}.${table.serviceName};
import com.baomidou.mybatisplus.core.metadata.IPage;
import ${cfg.parentPackage}.util.PageQuery;
import ${cfg.parentPackage}.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

<#if restControllerStyle>
import org.springframework.web.bind.annotation.RestController;
<#else>
import org.springframework.stereotype.Controller;
</#if>
<#if superControllerClassPackage??>
import ${superControllerClassPackage};
</#if>


/**
 * <p>
 * ${table.comment!} 内部接口
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
<#if restControllerStyle>
@RestController
<#else>
@Controller
</#if>
@RequestMapping("<#if package.ModuleName??>/${package.ModuleName}</#if>/<#if controllerMappingHyphenStyle??>${controllerMappingHyphen}<#else>${table.entityPath}</#if>")
<#if kotlin>
class ${table.controllerName}<#if superControllerClass??> : ${superControllerClass}()</#if>
<#else>
<#if superControllerClass??>
public class ${table.controllerName} extends ${superControllerClass} {
<#else>
public class ${table.controllerName} {
</#if>

    @Autowired
    public ${table.serviceName} ${table.entityPath}Service;

    /**
    * 新增
    *
    * @param ${table.entityPath}
    * @return
    */
    @RequestMapping(method = RequestMethod.POST)
    public Result<?> save(@RequestBody ${entity} ${table.entityPath}){
        boolean save = ${table.entityPath}Service.save(${table.entityPath});
         if (save) {
            return Result.info("新增成功");
        } else {
            return Result.fail("新增失败");
        }
    }

    /**
    * 修改
    *
    * @param ${table.entityPath}
    * @return
    */
    @RequestMapping(method = RequestMethod.PUT)
    public Result<${entity}> update(@RequestBody ${entity} ${table.entityPath}) {
        boolean save = ${table.entityPath}Service.updateById(${table.entityPath});
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
        return ${table.entityPath}Service.deleteById(id);
    }

    /**
    * 查询详情
    *
    * @param id 主键id
    * @return
    */
    @RequestMapping(value = "/{id}" , method = RequestMethod.GET)
    public Result<${entity}> findOne(@PathVariable int id) {
        return Result.info(${table.entityPath}Service.getById(id));
    }

    /**
    * 分页查询
    *
    * @param pageQuery 分页查询
    * @return
    */
    @RequestMapping(value = "queryByPage",method = RequestMethod.GET)
    public Result<IPage<${entity}>> queryByPage(PageQuery pageQuery) {
        return ${table.entityPath}Service.queryByPage(pageQuery);
    }
}
</#if>
