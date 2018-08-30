package cok_servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class GetCookiesServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();

        PrintWriter writer = response.getWriter();

        writer.println("<html>");
        writer.println("<h1> I know everything about you </h1>");
        for (Cookie c : cookies) {
            writer.println("<h2> Your cookie name are " + c.getName() + " , and your cookie value are " + c.getValue() + "</h2>");
        }

        writer.println("<html>");
    }
}
