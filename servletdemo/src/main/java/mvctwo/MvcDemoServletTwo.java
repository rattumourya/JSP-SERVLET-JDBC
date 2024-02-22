import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;


@WebServlet("/MvcDemoServletTwo")
public class MvcDemoServletTwo extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // step - 1: get the student data from helper class (model)
        List<Student> students = StudentDataUtil.getStudents();
        // step - 2: add students to request object
        request.setAttribute("student_list",students);
        //step - 3: get the request dispatcher
        RequestDispatcher dispatcher = request.getRequestDispatcher("view_students_two.jsp");
        //step - 4: forward the request to the dispatcher
        dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
