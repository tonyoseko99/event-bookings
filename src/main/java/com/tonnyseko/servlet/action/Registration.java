package com.tonnyseko.servlet.action;

import com.tonnyseko.servlet.app.model.entity.User;
import com.tonnyseko.servlet.database.Database;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;

@WebServlet("/registration")
public class Registration extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Database db = Database.getDbInstance();

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String password2 = request.getParameter("confirmPassword");

        if (password.equals(password2)) {
            db.getUsers().add(new User(100L, username, password));
            response.sendRedirect("./");
        } else {
            response.sendRedirect("./registration");
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html lang=\"en\">");
        out.println("<head>");
        out.println("<title>Registration</title>");
        out.println("<meta charset=\"utf-8\">");
        out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
        out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\">");
        out.println("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>");
        out.println("<script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js\"></script>");
        out.println("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js\"></script>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class=\"container\">");
        out.println("<h2>Signup</h2>");
        out.println();
        out.println("<form action=\"registration\" method=\"post\">");
        out.println("<div class=\"form-group\">");
        out.println("<label for=\"username\">Username:</label>");
        out.println("<input type=\"text\" class=\"form-control\" id=\"username\" placeholder=\"Enter username\" name=\"username\">");
        out.println("</div>");
        out.println("<div class=\"form-group\">");
        out.println("<label for=\"password\">Password:</label>");
        out.println("<input type=\"password\" class=\"form-control\" id=\"password\" placeholder=\"Enter password\" name=\"password\">");
        out.println("</div>");
        out.println("<div class=\"form-group\">");
        out.println("<label for=\"confirmPassword\">Confirm Password:</label>");
        out.println("<input type=\"password\" class=\"form-control\" id=\"confirmPassword\" placeholder=\"Confirm password\" name=\"confirmPassword\">");
        out.println("</div>");
        out.println("<button type=\"submit\" class=\"btn btn-primary\">Submit</button>");
        out.println("</form>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    }
}
