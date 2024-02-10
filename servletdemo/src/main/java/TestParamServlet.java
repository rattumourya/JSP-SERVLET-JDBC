import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletContext;


public class TestParamServlet extends HttpServlet {
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Step 1: set content type
        response.setContentType("text/html");
        
        // Step 2: get printwriter
        PrintWriter out = response.getWriter();
        
        // Step 3: read configuration params
        ServletContext context = getServletContext(); // inherit from HttpServlet
        String maxCartSize = context.getInitParameter("max-shopping-cart");
        String teamName = context.getInitParameter("project-team-name");
        
        // READ PER-SERVLET parameter
        String theGreetingMessage = getInitParameter("greeting");
        String theServiceLevel = getInitParameter("serviceLevel");
        
        // Step 4: generate HTML content
        out.println("<html><body>");
        out.println("Max cart: " + maxCartSize);
        out.println("<br/><br/>");
        out.println("Team name: " + teamName);
        out.println("<hr>");
        out.println("Per Servlet Params<br/><br/>");
        out.println("greeting: " + theGreetingMessage);
        out.println("<br/><br/>");
        out.println("serviceLevel: " + theServiceLevel);
        
        out.println("</body></html>");    
    }   
 
}