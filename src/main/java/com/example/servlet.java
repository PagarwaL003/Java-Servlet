package com.example;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class servlet extends HttpServlet {
    private static int visitorCount = 0;

    // Method to process both GET and POST requests
    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        visitorCount += 1;
        // Set the content type of the response
        response.setContentType("text/html;charset=UTF-8");

        // PrintWriter to write response
        PrintWriter out = response.getWriter();

        // HTML output
        out.println("<html>");
        out.println("<head>");
        out.println("<style>");
        out.println("@keyframes blink { 50% { opacity: 0; } }");
        out.println(".blink { animation: blink 1s step-start infinite; color: green; font-family: monospace; }");
        out.println(".user { color: red; font-weight: 400; font-size: 40px; font-family: Arial; }");
        out.println(".roll { color: cyan; font-weight: 350; font-size: 27px; font-family: sans-serif; }");
        out.println(".header { color: gold; font-weight: 300; font-size: 50px; font-family: Arial; }");
        out.println(".address { color: blue; font-weight: 500; font-size: 20px; font-family: Helvetica; }");
        out.println(".languages { color: purple; font-weight: 800; font-size: 28px; font-family: sans-serif; }");
        out.println(".citizenship { color: brown; font-weight: bold; font-size: 23px; font-family: Verdana; }");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1 class='header'>Hello , This is servlet</h1>");
        out.println("<h2 class='blink'>You are visitor number: " + visitorCount + "</h2>");

        String user = request.getParameter("user");
        String roll = request.getParameter("roll");
        String address = request.getParameter("address");
        String languages = request.getParameter("languages");
        String citizenship = request.getParameter("citizenship");
        out.println("<h2 class='user'>Name : " + user + "</h2>");
        out.println("<h2 class='roll'>Roll Number : " + roll + "</h2>");
        out.println("<h2 class='address'>Address :  " + address + "</h2>");
        out.println("<h2 class='languages'>Languages known : " + languages + "</h2>");
        out.println("<h2 class='citizenship'>Citizenship : " + citizenship + "</h2>");
        out.println("</body>");
        out.println("</html>");
    

    // Override the doGet method
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        processRequest(request, response);
    }

    // Override the doPost method
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        processRequest(request, response);
    }
}