package com.sample.controller;

import com.sample.entity.Teacher;
import com.sample.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by Kalana on 28/07/2021
 */

@Controller
public class DemoController {

    @Autowired
    private TeacherService teacherService;


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
}
