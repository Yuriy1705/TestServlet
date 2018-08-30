package library;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class LibraryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter printWriter = response.getWriter();

        try {
            Class.forName("mysql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3309/java_ee_test",
                    "root",
                    "Yfenbkec");

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT title from books");

            while (resultSet.next()) {
                printWriter.println(resultSet.getString("title"));
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
