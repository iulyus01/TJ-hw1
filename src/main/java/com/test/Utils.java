package com.test;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;

public class Utils {

    public static String generateHtmlBoilerplate(String content) {
        return "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Liquor Store</title>\n" +
                "</head>\n" +
                "<body>\n" +
                content +
                "</body>\n" +
                "</html>";
    }

    public static String envelopIntoTag(String content, String tag) {
        return "<" + tag + ">" + content + "</" + tag + ">";
    }

    public static int[][] generateTree(int verticesNr) {
        int[][] matrix = new int[verticesNr][verticesNr];
        for(int i = 0; i < verticesNr; i++) {
            for(int j = 0; j < verticesNr; j++) {
                matrix[j][i] = 0;
            }
        }

        for(int i = 1; i < verticesNr; i++) {
            int adjacentIndex = (int) Math.floor(Math.random() * i);
            matrix[adjacentIndex][i] = 1;
            matrix[i][adjacentIndex] = 1;
        }

        return matrix;
    }

    public static String getRequestBody(HttpServletRequest request) throws IOException {
        BufferedReader reader = request.getReader();
        StringBuilder requestBody = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            requestBody.append(line);
        }
        reader.close();
        return requestBody.toString();
    }

}
