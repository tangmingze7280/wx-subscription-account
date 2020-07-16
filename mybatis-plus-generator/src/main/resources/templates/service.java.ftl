package ${package.Service};

import ${package.Entity}.${entity};
import ${superServiceClassPackage};
import com.baomidou.mybatisplus.core.metadata.IPage;
import ${cfg.parentPackage}.util.PageQuery;
import ${cfg.parentPackage}.util.Result;

/**
 * <p>
 * ${table.comment!} 服务类
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */

<#if kotlin>
interface ${table.serviceName} : ${superServiceClass}<${entity}>
<#else>
public interface ${table.serviceName} extends ${superServiceClass}<${entity}> {

    Result<?> deleteById(int id);

    Result<IPage<${entity}>> queryByPage(PageQuery pageQuery);

}
</#if>
