package gui.example.demo.controller.web;

import gui.example.demo.StudentForm;
import gui.example.demo.model.Student;
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

    Logger log = Logger.getLogger(StudentController.class.getName());

    List<Student> students = new ArrayList<>(
            Arrays.asList(
                  new Student(1, "Paul Maccartney",(byte) 1),
                  new Student(2, "John Lenon",(byte) 1),
                  new Student(3, "Ricki Martin",(byte) 4),
                  new Student(4, "Till Linderman",(byte) 1) ,
                  new Student(5, "Vera Brejneva",(byte) 1)
            )
    );



    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    String sayHello(Model model){
        log.info("method say Hello was called");
        String name = " Father";
        model.addAttribute("name", name);

        return  "index";
    }
    @RequestMapping(value = { "/sts"}, method = RequestMethod.GET)
    String showStudents(Model model){
        model.addAttribute("students", students);
        return  "sts";
    }

    @RequestMapping(value = { "/student/delete/{id}"},
            method = RequestMethod.GET)
    String del(Model model, @PathVariable("id") int id){

        log.info("Method delete was called with param " + id);
        List<Student> listOfStudentsAfterDeletion
        = students.stream().filter(student -> student.getId() != id)
        .collect(Collectors.toList());
        students = listOfStudentsAfterDeletion;

        log.info("Deletion was successful");

        model.addAttribute("students", students);
        return  "sts";
    }

     @RequestMapping(value = "/student/add", method = RequestMethod.GET)
    public String addStudent(Model model){
        StudentForm studentForm = new StudentForm();
        model.addAttribute("studentForm", studentForm);
        return "add";
    }

    @RequestMapping(value = "/student/add", method = RequestMethod.POST)
    public String addStudent(Model model,
                             @ModelAttribute("studentForm") StudentForm studentForm){

        Student newStudent = new Student(studentForm.getId(),
                studentForm.getName(), studentForm.getMark());
        students.add(newStudent);
        model.addAttribute("students", students);
        return "sts";
    }



}
