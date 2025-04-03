package com.hao_xiao_zi.springboot;

import com.alibaba.druid.pool.DruidDataSource;
import com.hao_xiao_zi.springboot.config.ServiceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
//该注解用来开启属性配置功能，并指明为哪些类服务，之后找到该类，通过读取@ConfigurationProperties注解的属性值来获取具体读哪些值
//注意：使用该注解默认会为标注的类创建JavaBean对象,所以不能和@Component注解同时使用
//使用该注解的好处可以清晰看出为哪些类做了属性配置
@EnableConfigurationProperties({ServiceConfig.class})
public class Springboot12ConfigurationApplication {

    @Bean
    @ConfigurationProperties(prefix = "datasource")
    public DruidDataSource getDruidDataSource(){
        DruidDataSource dataSource = new DruidDataSource();
//        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        return dataSource;
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(Springboot12ConfigurationApplication.class, args);
        ServiceConfig bean = run.getBean(ServiceConfig.class);
        System.out.println(bean);
        DruidDataSource bean1 = run.getBean(DruidDataSource.class);
        System.out.println(bean1.getDriverClassName());
    }

}
