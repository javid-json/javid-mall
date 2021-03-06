package pers.javid.mall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("pers.javid.mall.dao")
public class CategoryApplication {
    public static void main(String[] args){
        SpringApplication.run(CategoryApplication.class,args);
    }
}
