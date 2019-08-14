package gui.example.demo.services.interfaces;

import gui.example.demo.model.Student;

import java.util.List;

public interface IStudentService {

    List<Student> getAll();
    void delete(int id);
    Student create(Student student);



}
