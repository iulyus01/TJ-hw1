package com.test;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sum extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();

        String requestBody = Utils.getRequestBody(request);

        Pattern pattern = Pattern.compile("[0-9]+");
        Matcher matcher = pattern.matcher(requestBody);

        int s = 0;
        while (matcher.find()) {
            String number = matcher.group();
            s += Integer.parseInt(number);
        }

        out.println("result: " + s);

        out.close();
    }
}