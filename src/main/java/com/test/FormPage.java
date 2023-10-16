package com.test;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class FormPage extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("got here");
        resp.setContentType("text/html");

        String message = "hello there";
        req.setAttribute("message", message); // This will be available as ${message}
        try {
            req.getRequestDispatcher("/index.html").forward(req, resp);
        } catch(ServletException e) {
            e.printStackTrace();
        }

    }
}
