package com.ajtech.student.service;


import com.ajtech.student.entity.Student;

import com.ajtech.student.repo.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class StudentService {

    @Autowired
    private  StudentRepository studentRepository;


    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentById(Integer id) {
        return studentRepository.findById(id);
    }

    public Student saveStudent(Student student) {
        log.info("saveStudent(-) Started");
        return studentRepository.save(student);
    }

    public Student updateStudent(Integer id, Student studentDetails) {
        log.info("updateStudent(-) Started");
        Student student = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
        student.setFirstName(studentDetails.getFirstName());
        student.setLastName(studentDetails.getLastName());
        student.setAge(studentDetails.getAge());
        return studentRepository.save(student);
    }

    public void deleteStudent(Integer id) {
        log.info("deleteStudent(-) Started");
        Student student = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
        studentRepository.delete(student);
    }
    public void deleteAllStudent() {
        log.info("deleteStudent(-) Started");
        studentRepository.deleteAll();
    }
}
