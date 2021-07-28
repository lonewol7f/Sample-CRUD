package com.sample.service;

import com.sample.dao.TeacherDAO;
import com.sample.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Kalana on 28/07/2021
 */

@Service
public class TeacherServiceImpl implements TeacherService{

    @Autowired
    private TeacherDAO teacherDAO;

    @Override
    @Transactional
    public List<Teacher> getTeachers() {
        return teacherDAO.getTeachers();
    }

    @Override
    @Transactional
    public Teacher getTeacherById(int id) {
        return teacherDAO.getTeacherById(id);
    }

    @Override
    @Transactional
    public void deleteTeacher(int id) {
        teacherDAO.deleteTeacher(id);
    }

    @Override
    @Transactional
    public void saveOrUpdate(Teacher teacher) {
        teacherDAO.saveOrUpdate(teacher);
    }
}
