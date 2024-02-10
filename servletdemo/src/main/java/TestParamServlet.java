import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletContext;

@WebServlet("/TestParamServlet")
public class TestParamServlet extends HttpServlet { 

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // step 1: set the content type 
        response.setContentType("text/html");
        // step 2: get the printwriter
        PrintWriter out = response.getWriter();
        // step 3: read configuration parameters from web xml
        ServletContext content = getServletContext();
        // step 4: generate the html content on the fly
        String maxCartSize = content.getInitParameter("max-shopping-cart");
        String teamName = content.getInitParameter("project-team-name");

        out.println("<html><body>");
        out.println("Max cart : " + maxCartSize);
        out.println("<br/><br/>");
        out.println("Team name : " + teamName);
        out.println("</body></html>");

    }

}