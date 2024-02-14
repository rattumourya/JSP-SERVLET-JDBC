import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Student;

public class StudentDBUtil {
    
    // private DataSource dataSource;

    // public StudentDBUtil(DataSource dataSource) {
    //     this.dataSource = dataSource;
    // }

    public List<Student> getStudents() throws Exception {

        List<Student> students = new ArrayList<>();

        Connection myConnection = null;
        Statement myStatement = null;
        ResultSet myResult = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            // get a connection
            myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/web_student_tracker","webstudent","webstudent");
            // create sql statement
            String sql = "select * from student order by last_name";
            myStatement =  myConnection.createStatement();
            // execute statement
            myResult = myStatement.executeQuery(sql);
            // process result set
            while (myResult.next()) {
                // retrieve data from result set row
                int id = myResult.getInt("id");
                String first_name = myResult.getString("first_name");
                String last_name = myResult.getString("last_name");
                String email = myResult.getString("email");
                // create new student object
                Student  student = new Student(id, first_name, last_name, email);
                // add it to the list students
                students.add(student);
                }

            return students; 
        }
        finally {
            // close JDBC objects
            close(myConnection,myStatement,myResult);
        }
    }

    private void close(Connection myConnection, Statement myStatement, ResultSet myResult) {
        try {
            if(myResult != null)
            {
                myResult.close();
            }
            if(myStatement != null)
            {
                myStatement.close();
            }
            if(myConnection != null)
            {
                myConnection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
}
