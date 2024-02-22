import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/helloWorldServlet")
public class HelloWorldServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public HelloWorldServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
    {
        // step 1: set the content-type
        response.setContentType("text/html");

        // step 2: get the printWriter
        PrintWriter out = response.getWriter();

        // step 3: generate the HTML content on the fly
        out.println("<html>");
        out.println("<body>");
        out.println("<h2>Hello World of java!</h2>");
        out.println("<hr>");
        out.println("Time on the server is : " + new java.util.Date());
        out.println("</body>");
        out.println("</html>");
        

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doGet(request, response);
    }


}