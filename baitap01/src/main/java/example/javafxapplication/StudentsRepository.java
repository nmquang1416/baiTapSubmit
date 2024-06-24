package example.javafxapplication;

import java.sql.*;
import java.util.ArrayList;

public class StudentsRepository {

    private final String MYSQL_CONNECTION = "jdbc:mysql://localhost:3306/java_application";
    private final String MYSQL_USER = "root";
    private final String MYSQL_PASSWORD = "";

    public ArrayList<Student> findAll(){
        ArrayList<Student> students = new ArrayList<Student>();
        try {
            Connection connection = DriverManager.getConnection(MYSQL_CONNECTION, MYSQL_USER, MYSQL_PASSWORD);
            String STRING_MYSQL = "SELECT * FROM students";
            PreparedStatement preparedStatement = connection.prepareStatement(STRING_MYSQL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Student student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setAge(resultSet.getInt("age"));
                student.setAddress(resultSet.getString("address"));
                students.add(student);
            }
            System.out.println("Successfully loaded students");
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return students;
    }

    public Student save(Student student){
        try{
            Connection connection = DriverManager.getConnection(MYSQL_CONNECTION, MYSQL_USER, MYSQL_PASSWORD);
            String STRING_MYSQL = "INSERT INTO students (name, age, address) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(STRING_MYSQL);
            preparedStatement.setString(1, student.getName());
            preparedStatement.setInt(2, student.getAge());
            preparedStatement.setString(3, student.getAddress());
            preparedStatement.execute();

            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return student;
    }

}
