import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Student;

public class StudentDBUtil {
    
    // private DataSource dataSource;

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

    public void addStudent(Student theStudent) throws Exception {
       
        Connection myConnection = null;
        PreparedStatement myStatement = null;

        try {
            // get a connection 
            Class.forName("com.mysql.cj.jdbc.Driver");
            myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/web_student_tracker","webstudent","webstudent");

            // create sql statement
            String sql = "insert into student" +
                            "(first_name,last_name,email)" + 
                            "values(?,?,?)";

            myStatement =  myConnection.prepareStatement(sql);
            //set the param values for the student
            myStatement.setString(1, theStudent.getFirstName());
            myStatement.setString(2, theStudent.getLastName());
            myStatement.setString(3, theStudent.getEmail());

            // execute the sql statement
            myStatement.execute();
        } finally {
            close(myConnection, myStatement, null);
        }
        
    }

    public Student getStudentById(String theStudentId) throws Exception {

        Student theStudent = null;
        Connection myConnection = null;
        PreparedStatement myStatement = null;
        ResultSet myResultSet = null;
        int studentId;

        try {
            // convert student id into int
            studentId = Integer.parseInt(theStudentId);
            // get a connection 
            Class.forName("com.mysql.cj.jdbc.Driver");
            myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/web_student_tracker","webstudent","webstudent");
            // create sql to get selected student
            String sql = "select * from student where id=?";
            // create prepared statement
            myStatement =  myConnection.prepareStatement(sql);
            //set the param values for the student
            myStatement.setInt(1, studentId);
            // execute the sql statement
            myResultSet = myStatement.executeQuery();
            // retrieve data from result set row
            if(myResultSet.next())
            {
                String first_name = myResultSet.getString("first_name");
                String last_name = myResultSet.getString("last_name");
                String email = myResultSet.getString("email"); 
                theStudent = new Student(studentId, first_name, last_name, email);
            }else{
                throw new Exception("Could not find student id: " + studentId);
            }

            return theStudent;

        } finally {
            close(myConnection, myStatement, null);
        }

    }

    public void updateStudent(Student theStudent) throws Exception {

        Connection myConnection = null;
        PreparedStatement myStatement = null;

        try {
            // get the connection
            Class.forName("com.mysql.cj.jdbc.Driver");
            myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/web_student_tracker","webstudent","webstudent");
            // write sql to update
            String sql = "update student " +
                         "set  first_name=?,last_name=?,email=? " +
                         "where id=? ";
            // prepare statement 
            myStatement = myConnection.prepareStatement(sql);
            // set param in prepared statement
            myStatement.setString(1, theStudent.getFirstName());
            myStatement.setString(2, theStudent.getLastName());
            myStatement.setString(3, theStudent.getEmail());
            myStatement.setInt(4, theStudent.getId());
            // execute sql statement to update
            myStatement.execute();
        } finally {
            // close the connection
            close(myConnection, myStatement, null);
        }
    }
}
