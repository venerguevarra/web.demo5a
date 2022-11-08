package com.bootcamp.demo.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bootcamp.demo.bean.Student;

@WebServlet(urlPatterns = "/index")
public class IndexController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<String> names = new ArrayList<>();
        names.add("John");
        names.add("Peter");
        names.add("Luke");
        request.setAttribute("names", names);

        Map<Integer, Student> students = new HashMap<>();
        students.put(1, new Student(1, "Peter", "Parker", 90));
        students.put(2, new Student(2, "John", "Doe", 65));
        students.put(3, new Student(3, "Mary", "Poppins", 80));
        students.put(4, new Student(4, "Kenny", "Cruz", 74));
        students.put(5, new Student(5, "Ted", "Locsin", 89));
        request.setAttribute("students", students);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);
    }
}
