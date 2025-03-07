package cn.hao_xiao_zi.spring.service;

import cn.hao_xiao_zi.spring.dao.TeacherDao;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 34255
 * Date: 2025-03-07
 * Time: 11:35
 */
@Service
public class TeacherService {

    @Resource
    private TeacherDao dao;

    public void deleteTeacher(){
        dao.deleteTeacherById();
    }
}
