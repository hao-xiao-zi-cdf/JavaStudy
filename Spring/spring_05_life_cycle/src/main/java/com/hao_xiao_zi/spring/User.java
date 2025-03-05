package com.hao_xiao_zi.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-03-05
 * Time: 20:56
 */
public class User implements BeanNameAware, BeanClassLoaderAware,
        BeanFactoryAware , InitializingBean,DisposableBean {
    private String name;

    public User(){
        System.out.println("第一步：实例化bean对象");
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("第二部：bean对象属性赋值");
    }

    //初始化和销毁Bean对象需要自己编写，并配置才会被调用
    public void initBean(){
        System.out.println("第四步：初始化Bean对象");
    }

    public void destroyBean(){
        System.out.println("第七步：销毁Bean对象");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("beanFactory：" + beanFactory);
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("类加载器：" + classLoader);
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("bean对象名称：" + name);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("destroy方法执行");
    }
}
