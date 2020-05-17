package pers.javid.mall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ProductClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProductClientApplication.class,args);
    }
}
