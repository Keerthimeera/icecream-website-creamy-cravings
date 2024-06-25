package ice_cream;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.*;

@WebServlet("/signup")
public class signup extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String phoneNumber = request.getParameter("phone");
        String address = request.getParameter("address");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/icecream", "root", "Keeru@143");
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO login (name, email, password, phnumber, address) VALUES (?, ?, ?, ?, ?)");
            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setString(3, password);
            pstmt.setString(4, phoneNumber);
            pstmt.setString(5, address);
            pstmt.executeUpdate();
            conn.close();
            response.sendRedirect("login.html");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            
        }
    }
}
