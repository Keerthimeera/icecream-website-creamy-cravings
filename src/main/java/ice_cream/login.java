package ice_cream;


import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.*;

@WebServlet("/login")
public class login extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("lemail");
        String password = request.getParameter("Lpassword");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/icecream", "root", "Keeru@143");
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM login WHERE email=? AND password=?");
            pstmt.setString(1, email);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                // Get the session object
                HttpSession session = request.getSession();
                // Store user information in the session
                session.setAttribute("email", email);

                response.sendRedirect("home.html");
            } else {
                System.out.println("Error in username or password");
                PrintWriter out = response.getWriter();
                out.println("<html><body>");
                out.println("<h3>Error in username or password</h3>");
                out.println("<a href='login.html'>Try Again</a>");
                out.println("</body></html>");
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
