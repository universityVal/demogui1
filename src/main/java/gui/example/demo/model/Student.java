package gui.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Student {

    @Id
    private int  id;
    private String name;
    private String grupa;
    private byte mark;

    public Student() {
    }

    public Student(String name, String grupa, byte mark) {
        this.name = name;
        this.grupa = grupa;
        this.mark = mark;
    }

    public Student(int id, String name, String grupa, byte mark) {
        this.id = id;
        this.name = name;
        this.grupa = grupa;
        this.mark = mark;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrupa() {
        return grupa;
    }

    public void setGrupa(String grupa) {
        this.grupa = grupa;
    }

    public byte getMark() {
        return mark;
    }

    public void setMark(byte mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grupa='" + grupa + '\'' +
                ", mark=" + mark +
                '}';
    }
}
