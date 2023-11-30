package itc475.project;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("registrationForm.html"); 
        }

    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Temporary hardcoded crendentials until database is connected successfully
        boolean isValidUser = "admin".equals(username) && "password".equals(password);

        StringBuilder builder = new StringBuilder();
        builder.append("<html>");
        builder.append("<head><title>Login</title></head>");
        builder.append("<body>");
        
        if (isValidUser) {
            builder.append("<h1>Welcome, ").append(username).append("!</h1>");
        } else {
            builder.append("<h1>Login Failed: Invalid username or password</h1>");
        }
        
        builder.append("</body>");
        builder.append("</html>");

        response.setContentType("text/html");
        response.getWriter().append(builder.toString());
    }
}

