package ice_cream;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

@WebServlet("/user")
public class user extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the session object
        HttpSession session = request.getSession();
        String email = (String) session.getAttribute("email");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/icecream", "root", "Keeru@143");
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM login WHERE email=?");
            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                // Retrieve user details from the result set
                String name = rs.getString("name");
                String password = rs.getString("password");
                String phnumber = rs.getString("phnumber");
                String address = rs.getString("address");
                // You can retrieve other details similarly
                
                // Construct the HTML response using the provided HTML template
                String htmlResponse = "<!DOCTYPE html>\n" +
                    "<html lang=\"en\">\n" +
                    "<head>\n" +
                    "<meta charset=\"UTF-8\">\n" +
                    "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                    "<title>User Profile</title>\n" +
                    "<style>\n" +
                    "    body {\n" +
                    "        font-family: Arial, sans-serif;\n" +
                    "        text-align: center;\n" +
                    "        background-image: url(https://e0.pxfuel.com/wallpapers/389/893/desktop-wallpaper-cream-background-ice-cream-candy-ice-cream.jpg);\n" +
                    "    }\n" +
                    "    .user-icon {\n" +
                    "        width: 148px; /* Set size as needed */\n" +
                    "        height: 150px; /* Set size as needed */\n" +
                    "        border-radius: 50%;\n" +
                    "        background-color: #ccc; /* Placeholder color */\n" +
                    "        margin: 0 auto; /* Center alignment */\n" +
                    "        background-image: url(https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQvBlJbkC53zSy51nZn1Nu_cXmPIj_dtY8NSM0_-e5dtA&s);\n" +
                    "    }\n" +
                    "    .user-details {\n" +
                    "        margin-top: 20px;\n" +
                    "        border: 2px dotted rgb(127, 45, 45);\n" +
                    "        width: 320px;\n" +
                    "        height: 210px;\n" +
                    "        margin: auto;\n" +
                    "        text-align: left;\n" +
                    "        padding: 30px;\n" +
                    "        padding-right: 0%;\n" +
                    "        position: relative;\n" +
                    "        box-shadow: 10px #242323;\n" +
                    "        border-radius: 80px;\n" +
                    "        color: #171616;\n" +
                    "        font-weight: bold; /* Make all fonts bold */\n" +
                    "    }\n" +
                    "    .myorder-button {\n" +
                    "        margin-top: 20px;\n" +
                    "        padding: 10px 20px;\n" +
                    "        background-color: #bc100dc7;\n" +
                    "        color: #fff;\n" +
                    "        border: none;\n" +
                    "        border-radius: 5px;\n" +
                    "        cursor: pointer;\n" +
                    "        text-decoration: none;\n" +
                    "        position: absolute;\n" +
                    "        justify-content: center;\n" +
                    "        margin: auto;\n" +
                    "        padding-top: 10px;\n" +
                    "        left: 50%; /* Center alignment */\n" +
                    "        transform: translateX(-50%); /* Center alignment */\n" +
                    "        border-radius: 60px;\n" +
                    "        font-weight: bold; /* Make font bold */\n" +
                    "    }\n" +
                    "    .idbox{\n" +
                    "        border: 2px double brown;\n" +
                    "        background-color: #d2b67c5b;\n" +
                    "        width: 500px;\n" +
                    "        height: 550px;\n" +
                    "        margin: auto;\n" +
                    "        box-shadow: 0px 0px 50px rgb(23, 22, 22);\n" +
                    "        backdrop-filter: blur(10px); \n" +
                    "        border-radius: 60px;\n" +
                    "        color: #181616;\n" +
                    "        font-weight: bold; /* Make all fonts bold */\n" +
                    "    }\n" +
                    "</style>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "<div class=\"idbox\">\n" +
                    "    <h1>User Profile</h1>\n" +
                    "    <div class=\"user-icon\"></div>\n" +
                    "    <div class=\"user-details\">\n" +
                    "        <p id=\"user-name\">Name: " + name + "</p>\n" +
                    "        <p id=\"user-email\">Email: " + email + "</p>\n" + // Use the email retrieved from session
                    "        <p id=\"user-phone\">Phone: " + phnumber + "</p>\n" +
                    "        <p id=\"user-address\">Address: " + address + "</p>\n" +
                    "    </div>\n" +
                    "    <div>\n" +
                    "        <a href=\"myorders\" class=\"myorder-button\">My Orders</a>\n" +
                    "    </div>\n" +
                    "</div>\n" +
                    "</body>\n" +
                    "</html>";

                // Send the HTML response
                response.setContentType("text/html");
                PrintWriter out = response.getWriter();
                out.println(htmlResponse);
            } else {
                // Handle case where user details are not found
                response.getWriter().println("User details not found.");
            }
            conn.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            response.getWriter().println("Error: " + e.getMessage());
        }
    }
}
