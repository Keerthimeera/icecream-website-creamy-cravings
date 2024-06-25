package ice_cream;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/myorders")
public class myorders extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            
            out.println("<style>");
            out.println("body { background-image: url('https://i.pinimg.com/originals/75/b5/1f/75b51fc3c6ab38dcad671f96b942a7eb.jpg'); background-size: cover; margin: 0; padding: 0; }");
            out.println("table { border-collapse: collapse; width: calc(100% - 200px); margin:  auto; background-color: rgba(255, 255, 255, 0.8);  border: 4px solid #6b320c; }");
            out.println("th, td { padding: 8px; text-align: left; border-bottom: 1px solid #ddd; color: #6b320c; }");
            out.println("th { background-color: #efc0a1; }");
            out.println("tr:hover { background-color: #f5f5f5; }");
            out.println(".heading { text-align: center; color: #6b320c; text-transform: uppercase;  margin-top: 100px; }");
            out.println("</style>");

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/icecream", "root", "Keeru@143");
            PreparedStatement ps = conn.prepareStatement("SELECT order_id, product_name, quantity, price, total_price, order_type, order_date_time FROM orders");
            ResultSet rs = ps.executeQuery();

            out.println("<html><body>");
            out.println("<h2 class=\"heading\">Order List</h2>");
            out.println("<table>");
            out.println("<tr><th>Order ID</th><th>Product Name</th><th>Quantity</th><th>Price</th><th>Total Price</th><th>Order Type</th><th>Order Date Time</th></tr>");
            while (rs.next()) {
                out.println("<tr><td>" + rs.getString("order_id") + "</td><td>" + rs.getString("product_name") + "</td><td>" + rs.getString("quantity") + "</td><td>" + rs.getString("price") + "</td><td>" + rs.getString("total_price") + "</td><td>" + rs.getString("order_type") + "</td><td>" + rs.getString("order_date_time") + "</td></tr>");
            }
            out.println("</table>");
            out.println("</body></html>");
            
            conn.close();
            ps.close();
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
