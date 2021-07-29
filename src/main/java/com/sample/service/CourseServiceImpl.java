package com.sample.service;

import com.sample.dao.CourseDAO;
import com.sample.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Kalana on 29/07/2021
 */

@Service
public class CourseServiceImpl implements CourseService{

    @Autowired
    private CourseDAO courseDAO;

    @Override
    @Transactional
    public List<Course> getCoursesByTeacherId(int id) {
        return courseDAO.getCoursesByTeacherId(id);
    }

    @Override
    @Transactional
    public void saveOrUpdate(Course course) {
        courseDAO.saveOrUpdate(course);
    }

    @Override
    @Transactional
    public Course getCourseById(int id) {
        return courseDAO.getCourseById(id);
    }

    @Override
    @Transactional
    public void deleteCourse(int id) {
        courseDAO.deleteCourse(id);
    }
}
