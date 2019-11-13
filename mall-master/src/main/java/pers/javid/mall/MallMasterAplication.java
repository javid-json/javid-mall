package pers.javid.mall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@MapperScan("pers.javid.mall.dao")
@ServletComponentScan(basePackages = "pers.javid.mall.filter")
public class MallMasterAplication {
    public static void main(String[] args){
        SpringApplication.run(MallMasterAplication.class,args);
    }
}
