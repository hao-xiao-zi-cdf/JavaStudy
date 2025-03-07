package org.hao_xiao_zi.spring.dao.impl;

import org.hao_xiao_zi.spring.dao.StudentDao;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-03-07
 * Time: 9:45
 */
@Repository("studentDaoImpl")
public class StudentDaoForMysql implements StudentDao {
    @Override
    public void deleteInfo() {
        System.out.println("Mysql数据库正在删除学生信息");
    }
}
