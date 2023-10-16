package com.test;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class NumberToListServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();

        if(request.getHeader("User-Agent") == null) {
            desktopResponse(request, out);
        } else {
            normalResponse(request, response, out);
        }
        out.close();
    }

    private void normalResponse(HttpServletRequest request, HttpServletResponse response, PrintWriter out) {
        response.setContentType("text/html");

        String numberParam = request.getParameter("numVertices");
        try {
            int number = Integer.parseInt(numberParam);
            int[][] m = Utils.generateTree(number);

            StringBuilder content = new StringBuilder();
            for(int i = 0; i < number; i++) {
                StringBuilder row = new StringBuilder();
                for(int j = 0; j < number; j++) {
                    row.append(Utils.envelopIntoTag(Integer.toString(m[j][i]), "td"));
                }
                content.append(Utils.envelopIntoTag(row.toString(), "tr"));
            }
            String table = Utils.envelopIntoTag(content.toString(), "table");

            out.println(Utils.generateHtmlBoilerplate(table));

        } catch(NumberFormatException e) {
            out.println("<html><head><title>Error</title></head><body>");
            out.println("<h2>Invalid Input</h2>");
            out.println("<p>Please provide a valid number.</p>");
            out.println("</body></html>");
        }
    }

    private void desktopResponse(HttpServletRequest request, PrintWriter out) {
        String numberParam = request.getParameter("numVertices");
        try {
            int number = Integer.parseInt(numberParam);
            int[][] m = Utils.generateTree(number);

            StringBuilder output = new StringBuilder();

            for(int i = 0; i < m.length; i++) {
                for(int j = 0; j < m[0].length; j++) {
                    output.append(m[j][i]).append("  ");
                }
                output.append("\n");
            }

            out.println(output);
        } catch(NumberFormatException e) {
            out.println("Invalid input");
        }
    }
}