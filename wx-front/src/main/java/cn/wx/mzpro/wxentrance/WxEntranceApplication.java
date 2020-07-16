package cn.wx.mzpro.wxentrance;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"cn.wx.mzpro"})
@MapperScan(basePackages = {"cn.wx.mzpro.wxentrance.mapper"})
public class WxEntranceApplication {

    public static void main(String[] args) {
        SpringApplication.run(WxEntranceApplication.class, args);
    }

}
