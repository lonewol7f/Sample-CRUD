package com.sample.service;

import com.sample.entity.Teacher;

import java.util.List;

/**
 * Created by Kalana on 28/07/2021
 */

public interface TeacherService {

    List<Teacher> getTeachers();
    Teacher getTeacherById(int id);
    void deleteTeacher(int id);
    void saveOrUpdate(Teacher teacher);

}
