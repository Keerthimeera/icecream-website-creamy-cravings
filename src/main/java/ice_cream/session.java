package ice_cream;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

@WebServlet("/session")
public class session extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the session object
        HttpSession session = request.getSession();
        
        // Retrieve user information from session
        String email = (String) session.getAttribute("email");
        
        // Now you can use the retrieved information as needed
        
        // For demonstration purposes, let's just print the user email
        PrintWriter out = response.getWriter();
        out.println("User email: " + email);
    }
}
