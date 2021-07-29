package com.sample.service;

import com.sample.entity.Course;

import java.util.List;

/**
 * Created by Kalana on 29/07/2021
 */

public interface CourseService {

    List<Course> getCoursesByTeacherId(int id);
    void saveOrUpdate(Course course);
    Course getCourseById(int id);
    void deleteCourse(int id);

}
