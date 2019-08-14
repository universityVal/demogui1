package gui.example.demo.controller.web;

import gui.example.demo.StudentForm;
import gui.example.demo.model.Student;
import gui.example.demo.services.impls.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;


@Controller
public class StudentController {

    @Autowired
    StudentServiceImpl studentService;

    Logger log = Logger.getLogger(StudentController.class.getName());

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    String sayHello(Model model){
        log.info("method say Hello was called");
        String name = " Father";
        model.addAttribute("name", name);

        return  "index";
    }
    @RequestMapping(value = { "/sts"}, method = RequestMethod.GET)
    String showStudents(Model model){
        model.addAttribute("students", studentService.getAll());
        return  "sts";
    }

//    @RequestMapping(value = { "/student/delete/{id}"},
//            method = RequestMethod.GET)
//    String del(Model model, @PathVariable("id") int id){
//
//        log.info("Method delete was called with param " + id);
//        List<Student> listOfStudentsAfterDeletion
//        = students.stream().filter(student -> student.getId() != id)
//        .collect(Collectors.toList());
//        students = listOfStudentsAfterDeletion;
//
//        log.info("Deletion was successful");
//
//        model.addAttribute("students", students);
//        return  "sts";
//    }
//
//     @RequestMapping(value = "/student/add", method = RequestMethod.GET)
//    public String addStudent(Model model){
//        StudentForm studentForm = new StudentForm();
//        model.addAttribute("studentForm", studentForm);
//        return "add";
//    }
//
//    @RequestMapping(value = "/student/add", method = RequestMethod.POST)
//    public String addStudent(Model model,
//                             @ModelAttribute("studentForm") StudentForm studentForm){
//
//        Student newStudent = new Student(studentForm.getId(),
//                studentForm.getName(), studentForm.getMark());
//        students.add(newStudent);
//        model.addAttribute("students", students);
//        return "sts";
//    }



}
