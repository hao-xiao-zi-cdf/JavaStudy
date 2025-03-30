package com.hao_xiao_zi.mybatisplus.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hao_xiao_zi.mybatisplus.mapper.ProductMapper;
import com.hao_xiao_zi.mybatisplus.pojo.Product;
import com.hao_xiao_zi.mybatisplus.service.ProductService;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-03-30
 * Time: 13:25
 */
@Service
@DS("slave_1")
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {
}
