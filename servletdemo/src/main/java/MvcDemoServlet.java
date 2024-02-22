import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;


@WebServlet("/MvcDemoServlet")
public class MvcDemoServlet extends HttpServlet { 

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Step 0: Add Data 
        String[] students = {"Susan","Anil","Mohammad","Trupti","Ratan","Somya"};
        request.setAttribute("student_list",students);
        // Step 1: Get the request dispatcher
        RequestDispatcher dispatcher =  request.getRequestDispatcher("/view_students.jsp");
        // step 2: forward the request  to JSP
        dispatcher.forward(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO: Auto-generated method stub
    }
}