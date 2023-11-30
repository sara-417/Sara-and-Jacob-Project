package itc475.project;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public RegistrationServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String username = request.getParameter("username");
        String password = request.getParameter("password"); 

       
        StringBuilder builder = new StringBuilder();
        builder.append("<html>");
        builder.append("<head><title>Registration Successful</title></head>");
        builder.append("<body>");
        builder.append("<h1>Registration Details</h1>");
        builder.append("<p>Username: ").append(username).append("</p>");
        builder.append("<p>Password: ").append(password).append("</p>"); 
        builder.append("</body>");
        builder.append("</html>");

        response.setContentType("text/html");
        response.getWriter().append(builder.toString());
    }
}

