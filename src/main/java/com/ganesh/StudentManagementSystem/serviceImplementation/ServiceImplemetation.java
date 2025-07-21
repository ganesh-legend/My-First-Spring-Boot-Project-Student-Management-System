package com.ganesh.StudentManagementSystem.serviceImplementation;

import com.ganesh.StudentManagementSystem.entity.Student;
import com.ganesh.StudentManagementSystem.repository.StudentRepository;
import com.ganesh.StudentManagementSystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceImplemetation implements StudentService
{
    @Autowired
    StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudents()
    {
        List<Student> list = studentRepository.findAll();
        return list;
    }

    @Override
    public Student saveStudent(Student student)
    {
        return studentRepository.save(student);
    }

    @Override
    public Student getById(int id)
    {
        return studentRepository.findById(id).get();
    }

    @Override
    public void deleteById(int id)
    {
        studentRepository.deleteById(id);
    }

}
