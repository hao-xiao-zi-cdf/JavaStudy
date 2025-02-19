package test;

import com.hao_xiao_zi.Main;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-02-19
 * Time: 19:29
 */
public class MyTest {

    @Test
    public void testAdd(){
        Main a = new Main();
        System.out.println(a.add(2, 3));
    }
}
