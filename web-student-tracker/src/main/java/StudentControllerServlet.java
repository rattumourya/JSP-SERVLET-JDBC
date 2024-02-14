import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import model.Student;

@WebServlet("/StudentControllerServlet")
public class StudentControllerServlet extends HttpServlet {

    private StudentDBUtil studentDBUtil;

    @Resource(name="jdbc/web_student_tracker")
    private DataSource dataSource;

    @Override
    public void init() throws ServletException {
        super.init();
        try {
            studentDBUtil = new StudentDBUtil();
        } catch (Exception e) {
            throw new  ServletException(e);
        }
    }



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            //read the "command" parameter
            String theCommand = req.getParameter("command");

            // if the command is missing, then default to listing students
            if(theCommand == null)
            {
                theCommand = "LIST";
            }
            // route to the appropriate method
            switch (theCommand) {
                case "LIST":
                    listStudents(req, resp);
                    break;
                case "ADD":
                    addStudent(req,resp);
                    break;
                case "LOAD":
                    loadStudent(req,resp);
                    break;
                case "UPDATE":
                    updateStudent(req,resp);
                    break;
                default:
                    listStudents(req, resp);
                    break;
            }


            listStudents(req,resp);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }



    private void updateStudent(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        // read the student info from form data
        int id = Integer.parseInt(req.getParameter("studentId"));
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");
        // create new student object
        Student theStudent = new Student(id, firstName, lastName, email);
        // perform update on database
        studentDBUtil.updateStudent(theStudent);
        // send them back to the list student
        listStudents(req, resp);
    }



    private void loadStudent(HttpServletRequest req, HttpServletResponse resp) throws Exception {
          
        // read student id from form data
        String studentId = req.getParameter("studentId");
        // getting student from student database
        Student theStudent = studentDBUtil.getStudentById(studentId);
        // place student in the request attribute
        req.setAttribute("THE_STUDENT", theStudent);
        // send to jsp page: update-student-form.jsp
        RequestDispatcher dispatcher = req.getRequestDispatcher("/update-student-form.jsp");
        dispatcher.forward(req, resp);
    }



    private void addStudent(HttpServletRequest req, HttpServletResponse resp) throws Exception {

        // read students info from form data
         String firstName = req.getParameter("firstName");
         String lastName = req.getParameter("lastName");
         String email = req.getParameter("email"); 

        // create a new student
        Student theStudent = new Student(firstName,lastName,email);
        // add the student to the database
        studentDBUtil.addStudent(theStudent);
        // send back to main page ( the student list)
        listStudents(req, resp);
    }



    private void listStudents(HttpServletRequest req, HttpServletResponse resp) throws Exception {

        // get the students from db util
        List<Student> students = studentDBUtil.getStudents();
        // add student to the request
        req.setAttribute("STUDENT_LIST", students);
        // send to JSP (view)
        RequestDispatcher dispatcher = req.getRequestDispatcher("/list-students.jsp");
        dispatcher.forward(req, resp);
    }
    
}
