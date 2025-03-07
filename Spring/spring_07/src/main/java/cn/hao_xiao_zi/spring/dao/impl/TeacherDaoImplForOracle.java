package cn.hao_xiao_zi.spring.dao.impl;

import cn.hao_xiao_zi.spring.dao.TeacherDao;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-03-07
 * Time: 11:31
 */
//@Repository("dao1")
public class TeacherDaoImplForOracle implements TeacherDao {
    @Override
    public void deleteTeacherById() {
        System.out.println("Oracle数据库正在删除教师信息");
    }
}
