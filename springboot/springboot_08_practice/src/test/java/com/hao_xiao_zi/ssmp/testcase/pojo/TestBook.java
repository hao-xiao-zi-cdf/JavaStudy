package com.hao_xiao_zi.ssmp.testcase.pojo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-04-06
 * Time: 10:38
 */
@Data
@Component
@ConfigurationProperties(prefix = "testcase.book1")
public class TestBook {

    private Integer id1;
    private Integer id2;
    private Long id3;
    private Long id4;
    private String name1;
    private String name2;

}
