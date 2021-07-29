package com.sample.controller;

import com.sample.entity.Course;
import com.sample.entity.Teacher;
import com.sample.service.CourseService;
import com.sample.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * Created by Kalana on 28/07/2021
 */

@Controller
public class DemoController {

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private CourseService courseService;


    @GetMapping("/")
    public String showHome() {
        return "home";
    }

    @GetMapping("/teachers/list")
    public String showTeacherList(Model model) {
        List<Teacher> teachers = teacherService.getTeachers();
        model.addAttribute("teachers", teachers);
        return "teacher-list";
    }

    @GetMapping("/teachers/addForm")
    public String showAddForm(Model model) {

        Teacher teacher = new Teacher();
        model.addAttribute("teacher", teacher);
        return "teacher-form";
    }

    @GetMapping("/teachers/update")
    public String showFormForUpdate(@RequestParam("teacherId") int id, Model model) {
        Teacher teacher = teacherService.getTeacherById(id);
        model.addAttribute("teacher", teacher);

        return "teacher-form";
    }

    @GetMapping("/teachers/delete")
    public String deleteTeacher(@RequestParam("teacherId") int id) {
        teacherService.deleteTeacher(id);

        return "redirect:/teachers/list";
    }

    @PostMapping("/teachers/save")
    public String saveTeacher(@ModelAttribute("teacher") Teacher teacher) {
        teacherService.saveOrUpdate(teacher);

        return "redirect:/teachers/list";
    }

    @GetMapping("/teachers/courses")
    public String showTeacherCourses(@RequestParam("teacherId") int id, Model model) {
        List<Course> courses = courseService.getCoursesByTeacherId(id);
        model.addAttribute("courses", courses);
        model.addAttribute("teacherId", id);

        return "courses-list";
    }

    @GetMapping("/teachers/courses/addCourse")
    public String showAddCourseForm(@RequestParam("teacherId") int teacherId, Model model) {
        Course course = new Course();
        Teacher teacher = teacherService.getTeacherById(teacherId);
        course.setTeacher(teacher);
        model.addAttribute("course", course);

        return "course-form";
    }

    @PostMapping("/teachers/courses/save")
    public String saveCourse(@ModelAttribute("course") Course course, @RequestParam("teacherId") int teacherId, RedirectAttributes redirectAttributes) {
        Teacher teacher = teacherService.getTeacherById(teacherId);
        course.setTeacher(teacher);
        courseService.saveOrUpdate(course);

        redirectAttributes.addAttribute("teacherId", teacherId);
        return "redirect:/teachers/courses";
    }

    @GetMapping("teachers/courses/update")
    public String showCourseUpdateForm(@RequestParam("courseId") int id, Model model) {

        Course course = courseService.getCourseById(id);
        model.addAttribute("course", course);

        return "course-form";
    }

    @GetMapping("/teachers/courses/delete")
    public String deleteCourse(@RequestParam("courseId") int id, Model model, RedirectAttributes redirectAttribute) {
        Course course = courseService.getCourseById(id);
        Teacher teacher = course.getTeacher();
        redirectAttribute.addAttribute("teacherId", teacher.getId());

        courseService.deleteCourse(id);

        return "redirect:/teachers/courses";
    }
}
