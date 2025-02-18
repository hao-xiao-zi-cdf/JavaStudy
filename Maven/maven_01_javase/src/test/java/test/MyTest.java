package test;

import com.hao_xiao_zi.Main;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-02-18
 * Time: 21:36
 */
public class MyTest {

    //所有功能功能的测试都是通过编写测试方法完成的
    //测试方法编写要求：
    //1.访问权限修饰符为public
    //2.方法返回值为void
    //3.方法无参数
    //4.方法名建议带上test
    //5.添加@test注解

    @Test
    public void testAdd(){
        Main a = new Main();
        System.out.println(a.add(2, 3));
    }

    @Test
    public void testDev(){
        Main a = new Main();
        System.out.println(a.dev(2, 3));
    }
}
