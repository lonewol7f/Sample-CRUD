package com.sample.dao;

import com.sample.entity.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Kalana on 28/07/2021
 */

@Repository
public class TeacherDAOImpl implements TeacherDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Teacher> getTeachers() {
        Session session = sessionFactory.getCurrentSession();

        Query<Teacher> teacherQuery = session.createQuery("from Teacher", Teacher.class);
        List<Teacher> teachers = teacherQuery.getResultList();
        return teachers;
    }

    @Override
    public Teacher getTeacherById(int id) {
        Session session = sessionFactory.getCurrentSession();

        Teacher teacher = session.get(Teacher.class, id);
        return teacher;
    }

    @Override
    public void deleteTeacher(int id) {
        Session session = sessionFactory.getCurrentSession();

        Query deleteQuery = session.createQuery("delete from Teacher where id=:teacher_id");
        deleteQuery.setParameter("teacher_id", id);

        deleteQuery.executeUpdate();
    }

    @Override
    public void saveOrUpdate(Teacher teacher) {
        Session session = sessionFactory.getCurrentSession();

        session.saveOrUpdate(teacher);
    }
}
