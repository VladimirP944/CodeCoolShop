package com.codecool.shop.api;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(urlPatterns = "/api/order")
public class OrderServlet extends HttpServlet {

    LogIO logIO = new LogIO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String payload = request.getParameter("order");
        try {
            logIO.exportOrder(payload);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("payload: " + payload);
    }

}