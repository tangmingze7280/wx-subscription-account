package cn.wx.mzpro.wxentrance.config;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class MybatisPlusConfig {

    private Logger logger = LoggerFactory.getLogger(MybatisPlusConfig.class);

    /**
     * mybatis-plus SQL执行效率插件【生产环境可以关闭】3.3.1版本已删除
     */
   /* @Bean
    public PerformanceInterceptor performanceInterceptor() {
        logger.info("mybatis-plus SQL执行效率插件【生产环境可以关闭】");
        return new PerformanceInterceptor();
    }*/

    /**
     * mybatis-plus分页插件<br>
     * 文档：http://mp.baomidou.com<br>
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        logger.info("mybatis-plus 分页插件");
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        //paginationInterceptor.setLocalPage(true);// 开启 PageHelper 的支持
        return paginationInterceptor;
    }

}