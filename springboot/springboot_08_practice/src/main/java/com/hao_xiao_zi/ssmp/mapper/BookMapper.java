package com.hao_xiao_zi.ssmp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hao_xiao_zi.ssmp.pojo.Book;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-04-01
 * Time: 20:36
 */
@Repository
public interface BookMapper extends BaseMapper<Book> {
}
