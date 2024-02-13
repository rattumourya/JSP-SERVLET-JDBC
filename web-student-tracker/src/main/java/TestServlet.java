import javax.servlet.annotation.WebServlet;
import javax.sql.DataSource;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.annotation.*;


@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {

    // define datasource/connection pool for resource injection
    @Resource(name="jdbc/web_student_tracker")
    private DataSource dataSource;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // step 1: set up the print writer
        PrintWriter out = response.getWriter();
        response.setContentType("text/plain");
        out.println("emails");
        // step 2: get the connection to the database
        Connection myConnection = null;
        Statement myStatement = null;
        ResultSet myResultSet = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("connection not stablished");
            // System.out.println(dataSource.toString());
            // myConnection = dataSource.getConnection();
            myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/web_student_tracker","webstudent","webstudent");
            // System.out.println("connection stablished");
            // // step 3: Create a SQL statement
            String sql = "select * from student";
            myStatement = myConnection.createStatement();
            // // step 4: Execute the SQL statement
            myResultSet = myStatement.executeQuery(sql);
            // // step 5: Process the result set
            while(myResultSet.next())
            {
                String email = myResultSet.getString("email");
                out.println(email);
            }
        }catch (Exception e) {
            e.printStackTrace();
            out.println(e.getMessage());
        }

    }

}