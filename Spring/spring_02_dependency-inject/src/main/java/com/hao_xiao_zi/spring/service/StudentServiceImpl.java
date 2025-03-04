package com.hao_xiao_zi.spring.service;

import com.hao_xiao_zi.spring.dao.StudentImpl;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-03-04
 * Time: 15:52
 */
public class StudentServiceImpl {
    private StudentImpl studentDao;

    public void setStudentDao(StudentImpl studentDao) {
        this.studentDao = studentDao;
    }

    public void deleteStuService(){
        studentDao.deleteById();
    }
}
