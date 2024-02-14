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
            listStudents(req,resp);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
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
