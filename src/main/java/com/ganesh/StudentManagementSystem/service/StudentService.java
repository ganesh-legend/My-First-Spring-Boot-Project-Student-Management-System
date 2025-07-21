package com.ganesh.StudentManagementSystem.service;

import com.ganesh.StudentManagementSystem.entity.Student;

import java.util.List;

public interface StudentService
{
    public List<Student> getAllStudents();

    public Student saveStudent(Student student);

    public Student getById(int id);

    public void deleteById(int id);

}
