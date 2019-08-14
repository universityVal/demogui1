package gui.example.demo.services.impls;

import gui.example.demo.model.Student;
import gui.example.demo.services.interfaces.IStudentService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;




@Service
public class StudentServiceImpl implements IStudentService {

    List<Student> students = new ArrayList<>(
            Arrays.asList(
                    new Student(1, "Paul Maccartney",(byte) 1),
                    new Student(2, "John Lenon",(byte) 1),
                    new Student(3, "Ricki Martin",(byte) 4),
                    new Student(4, "Till Linderman",(byte) 1) ,
                    new Student(5, "Vera Brejneva",(byte) 1)
            ));

    @Override
    public List<Student> getAll() {
        return students;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Student create(Student student) {
        return null;
    }
}
