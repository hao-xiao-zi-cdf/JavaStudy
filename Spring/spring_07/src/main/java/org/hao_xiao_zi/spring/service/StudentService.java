package org.hao_xiao_zi.spring.service;

import org.hao_xiao_zi.spring.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-03-07
 * Time: 9:46
 */
@Service("studentService")
public class StudentService {

//    @Autowired
//    @Qualifier("studentDaoForOracle")
    private StudentDao dao;

//    @Autowired
//    public void setDao(StudentDao dao) {
//        this.dao = dao;
//    }


    public StudentService(StudentDao dao) {
        this.dao = dao;
    }

    public void deleteStu(){
        dao.deleteInfo();
    }
}
