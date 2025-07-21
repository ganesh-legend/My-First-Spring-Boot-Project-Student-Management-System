package com.ganesh.StudentManagementSystem.controller;

import com.ganesh.StudentManagementSystem.entity.Student;
import com.ganesh.StudentManagementSystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@org.springframework.stereotype.Controller
public class Controller
{
    @GetMapping("/home")
    public String home()
    {
        return "home";     //home page html file
    }

    @Autowired
    private StudentService service;

    @GetMapping("/students")
    public String getAllStudents(Model model)
    {
        //student here is key which is referred in thymeleaf to dynamically take data.
        model.addAttribute("students_retrieved_info",service.getAllStudents());

        /*this is view page of student, students.html. There is no relation students
           written on above line */
        return "students";
    }

    @GetMapping("students/new")
    public String createStudentForm(Model model)
    {
        Student student = new Student(); //to hold student objects

        model.addAttribute("StudentsKey",student);
        return "create-student";
    }

    @PostMapping("/students")
    public String addStudent(@ModelAttribute("StudentsKey") Student student)
    {
        service.saveStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/students/edit/{id}")
    public String updateStudentForm(@PathVariable int id, Model model)
    {
        model.addAttribute("StudentsKey",service.getById(id));
        return "update-student";
    }

    @PostMapping("/students/edit/{id}")
    public String updateStudent(@PathVariable int id,@ModelAttribute("StudentsKey") Student student)
    {
        Student existingStudent = service.getById(id);

        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());

        service.saveStudent(existingStudent);

        return "redirect:/students";
    }

    @GetMapping("/students/{id}")
    public String deleteById(@PathVariable int id)
    {
        service.deleteById(id);
        return "redirect:/students";
    }
}
