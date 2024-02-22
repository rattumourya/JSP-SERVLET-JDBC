import java.util.*;

public class StudentDataUtil {

    public static List<Student> getStudents() {

         // Create an empty list
         List<Student> students = new ArrayList<Student>();
         // add sample data
         students.add(new Student("Mary","Public","mary@luv2code.com"));
         students.add(new Student("Ratan","Mourya","ratan.mourya@gmail.com"));
         students.add(new Student("Ajay","Rao","mary@luv2code.com"));
         students.add(new Student("Somya","Omer","somya.omer@gmail.com"));
         //return the list
         return students;

    }
}