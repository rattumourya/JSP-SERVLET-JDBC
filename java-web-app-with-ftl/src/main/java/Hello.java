import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

@WebServlet("/hello")
public class Hello extends HttpServlet {

	private Configuration cfg;
	@Override
	public void init() throws ServletException {
		super.init();
		cfg = new Configuration(Configuration.VERSION_2_3_31);
		cfg.setServletContextForTemplateLoading(getServletContext(), "/WEB-INF/templates");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		try {
			Template template = cfg.getTemplate("hello.ftl");
			Map<String,Object> dataModel = new HashMap<>();
			ArrayList<String> arrayList = new ArrayList<>();
			arrayList.add("Address Line 1");
			arrayList.add("Address Line 2");
			arrayList.add("Address Line 3");
			arrayList.add("Address Line 4");
			arrayList.add("City");
			arrayList.add("State");
			arrayList.add("Country");
			arrayList.add("ZipCode");
			dataModel.put("addressFields",arrayList);
			dataModel.put("name","World");
			template.process(dataModel, response.getWriter());
		} catch (TemplateException e) {
			e.printStackTrace();
			response.getWriter().write("Error processing template: " + e.getMessage());
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
