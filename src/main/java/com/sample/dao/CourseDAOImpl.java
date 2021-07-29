package com.sample.dao;

import com.sample.entity.Course;
import com.sample.entity.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Kalana on 29/07/2021
 */

@Repository
public class CourseDAOImpl implements CourseDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Course> getCoursesByTeacherId(int id) {
        Session session = sessionFactory.getCurrentSession();

        Teacher teacher = session.get(Teacher.class, id);
        List<Course> courses = teacher.getCourses();

        return courses;
    }

    @Override
    public void saveOrUpdate(Course course) {
        Session session = sessionFactory.getCurrentSession();
        Teacher teacher = course.getTeacher();
        course.setTeacher(teacher);
        session.saveOrUpdate(course);
    }

    @Override
    public Course getCourseById(int id) {
        Session session = sessionFactory.getCurrentSession();

        Course course = session.get(Course.class, id);

        return course;
    }

    @Override
    public void deleteCourse(int id) {
        Session session = sessionFactory.getCurrentSession();

        Query courseDeleteQuery = session.createQuery("delete from Course where id=:course_id");
        courseDeleteQuery.setParameter("course_id", id);

        courseDeleteQuery.executeUpdate();
    }
}
