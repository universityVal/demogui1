package gui.example.demo.services.impls;

import gui.example.demo.model.Student;
import gui.example.demo.repository.StudentRepository;
import gui.example.demo.services.interfaces.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.*;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


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
        this.gruping();
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

    @Override
    public List<Student> getByGrupa(String grupName) {
        Query query = new Query();
        Criteria criteria = Criteria.where("grupa").is("142");
        query.addCriteria(Criteria.where("grupa").is("142"));
        List<Student> fetchedByGrupa = studentRepository.findAll();
        return null;
    }
    public void gruping(){

        Map<String, List<Student>> collect = this.getAll().stream()
                .collect(Collectors.groupingBy(Student::getGrupa));

        Map<String, Long> counting = this.getAll().stream()
                .collect(Collectors.groupingBy(Student::getGrupa,
                        Collectors.counting()));
        System.out.println(counting);

        Map<String, Double> averaging = this.getAll().stream()
                .collect(Collectors.groupingBy(Student::getGrupa,
                        Collectors.averagingDouble(Student::getMark)));
        System.out.println(averaging);

        final List<Map.Entry<String, Double>> sorted = averaging.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).collect(Collectors.toList());

        System.out.println(sorted);

        Map<String, Optional<Student>> max = this.getAll().stream()
                .collect(Collectors.groupingBy(Student::getGrupa,
                        Collectors.maxBy(Comparator.comparing(Student::getMark))));

        System.out.println(max);


    }


}
