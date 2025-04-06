package com.hao_xiao_zi.ssmp;

import com.hao_xiao_zi.ssmp.testcase.pojo.TestBook;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class SSMPApplicationTests {

    @Autowired
    private TestBook book;

    @Test
    public void testRandom(){
        System.out.println(book);
    }

}
