package example.javafxapplication;

import javafx.scene.control.CheckBox;

public class Student {
    private long id;
    private String name;
    private int age;
    private String address;
    private CheckBox select;

    public Student() {
    }

    public Student(String address, int age, String name, long id, CheckBox select) {
        this.address = address;
        this.age = age;
        this.name = name;
        this.id = id;
        this.select = select;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }

    public CheckBox getSelect() {
        return select;
    }

    public void setSelect(CheckBox select) {
        this.select = select;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}