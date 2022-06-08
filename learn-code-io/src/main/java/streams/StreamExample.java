package main.java.streams;

import main.java.data.Student;
import main.java.data.StudentDataBase;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamExample {
    public static void main(String[] args) {
        long startTime=System.currentTimeMillis();
        System.out.println( StudentDataBase.getAllStudents().stream().count());

       Map<String, List<String>> data= StudentDataBase.getAllStudents().parallelStream().collect(Collectors.toMap(Student::getName,Student::getActivities));
        System.out.println(data);
        System.out.println(System.currentTimeMillis()-startTime);
    }
}
