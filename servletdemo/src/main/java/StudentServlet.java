import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet { 

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // step 1: set the content type 
        response.setContentType("text/html");
        // step 2: get the printwriter
        PrintWriter out = response.getWriter();
        // step 3: generate the html content on the fly
        out.println("<html><body>");
        out.println("The Student is confirmed: " 
                       + request.getParameter("firstName") + "  "
                       + request.getParameter("lastName"));

        out.println("</body></html>");

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO: Auto-generated method stub
    }
}