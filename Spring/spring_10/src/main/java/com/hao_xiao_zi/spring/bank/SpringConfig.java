package com.hao_xiao_zi.spring.bank;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-03-10
 * Time: 17:44
 */
@Configuration//使用注解的方式代替spring.xml配置文件
@ComponentScan({"com.hao_xiao_zi.spring.bank"})//组件扫描
@EnableTransactionManagement//开启事务注解驱动器，即基于注解进行事务管理
public class SpringConfig {

    @Bean("dataSource")//当spring看到该注解，就会调用该方法的返回值获取对象，将其纳入spring容器进行管理
    public DruidDataSource getDataSource(){
        //创建java对象
        DruidDataSource dataSource = new DruidDataSource();
        //属性赋值
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/test");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        return dataSource;
    }

    @Bean("jdbcTemplate")//当spring调用该方法时，发现需要参数，spring就会去查找容器当中是否有该类型的bean对象，有的话就会启动给我进行传参
    public JdbcTemplate getJdbcTemplate(DataSource dataSource){
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        return jdbcTemplate;
    }

    @Bean("transactionManager")
    public DataSourceTransactionManager getDataSourceTransactionManager(DataSource dataSource){
        DataSourceTransactionManager manager = new DataSourceTransactionManager();
        manager.setDataSource(dataSource);
        return manager;
    }
}
