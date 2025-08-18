package com.hao_xiao_zi.bean;

import lombok.Data;

import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-08-18
 * Time: 14:46
 */
@Data
public class Product {
    private Long id;
    private BigDecimal price;
    private String productName;
    private int num;
}
