package pers.javid.mall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("pers.javid.mall.dao")
public class MallAplication {
    public static void main(String[] args){
        SpringApplication.run(MallAplication.class,args);
    }
}
