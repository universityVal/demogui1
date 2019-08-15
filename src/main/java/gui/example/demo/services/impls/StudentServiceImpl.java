package gui.example.demo.services.impls;

import gui.example.demo.model.Student;
import gui.example.demo.repository.StudentRepository;
import gui.example.demo.services.interfaces.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;




@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    StudentRepository studentRepository;

//    List<Student> students = new ArrayList<>(
//            Arrays.asList(
//                    new Student(1, "Paul Maccartney",(byte) 1),
//                    new Student(2, "John Lenon",(byte) 1),
//                    new Student(3, "Ricki Martin",(byte) 4),
//                    new Student(4, "Till Linderman",(byte) 1) ,
//                    new Student(5, "Vera Brejneva",(byte) 1)
//            ));

    @PostConstruct
    void init(){
      //  studentRepository.saveAll(students);
    }



    @Override
    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    @Override
    public void delete(int id) {

        studentRepository.deleteById(id);
    }

    @Override
    public Student create(Student student)
    {
        int lastId = studentRepository
                .findAll()
                .stream()
                .mapToInt(Student::getId).max()
                .getAsInt();

        student.setId(lastId+1);

        return studentRepository.save(student);
    }
}
