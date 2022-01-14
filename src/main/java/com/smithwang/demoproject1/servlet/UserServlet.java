package com.smithwang.demoproject1.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "userServlet",urlPatterns = "/api/v1/test/custom")
public class UserServlet  extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        PrintWriter printWriter = resp.getWriter();
        printWriter.println("this is printWriter doGet");
        printWriter.flush();
        printWriter.close();
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter printWriter = resp.getWriter();
        printWriter.println("this is printWriter doPost");
        printWriter.flush();
        printWriter.close();
        super.doPost(req, resp);
    }
}
