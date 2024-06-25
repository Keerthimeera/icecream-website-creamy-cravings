package ice_cream;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.*;

@WebServlet("/order")
public class history extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pname = request.getParameter("productName");
        String quantity = request.getParameter("quantity");
        String productAmount = request.getParameter("productAmount");
        String totalAmount = request.getParameter("totalAmount");
        String pay = request.getParameter("pay");


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/icecream", "root", "Keeru@143");
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO orders (product_name, quantity, price, total_price, order_type) VALUES (?, ?, ?, ?, ?)");
            pstmt.setString(1, pname);
            pstmt.setString(2, quantity);
            pstmt.setString(3, productAmount);
            pstmt.setString(4, totalAmount);
            pstmt.setString(5, pay);
            pstmt.executeUpdate();
            conn.close();
            response.sendRedirect("home.html");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
