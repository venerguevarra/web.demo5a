package com.bootcamp.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/action")
public class ActionController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // /action?type=save
        // /action?type=update
        String type = request.getParameter("type");
        PrintWriter out = response.getWriter();
        out.print(type);
        out.flush();
        out.close();
    }
}
