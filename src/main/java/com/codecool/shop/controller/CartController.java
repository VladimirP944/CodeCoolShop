package com.codecool.shop.controller;

import com.codecool.shop.dao.implementation.OrderDaoMem;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/cart"})
public class CartController extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        OrderDaoMem orderDaoMem = OrderDaoMem.getInstance();
        super.doGet(req, resp);
    }
}
