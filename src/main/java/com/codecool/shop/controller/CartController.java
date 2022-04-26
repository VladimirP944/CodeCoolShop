package com.codecool.shop.controller;

import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.implementation.OrderDaoMem;
import com.codecool.shop.dao.implementation.ProductDaoMem;
import com.codecool.shop.model.CartItem;
import com.codecool.shop.model.Product;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.util.List;

@WebServlet(urlPatterns = {"/cart"})
public class CartController extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        OrderDaoMem orderDaoMem = OrderDaoMem.getInstance();

        if (req.getParameter("cart") != null) {
            String items = req.getParameter("cart");

            PrintWriter out = resp.getWriter();

            ProductDao productDataStore = ProductDaoMem.getInstance();

            Gson gson = new Gson();
            Type merchantListType = new TypeToken<List<CartItem>>() {}.getType();

            List<CartItem> cartItems = gson.fromJson(items, merchantListType);

            int total = 0;
            for (CartItem cartItem : cartItems) {
                Product product = productDataStore.find(cartItem.getId());

                int finalPrice = cartItem.getPiece() * Integer.parseInt(String.valueOf(product.getDefaultPrice()));
                total += finalPrice;

                cartItem.setSumItemPrice(finalPrice);
                cartItem.setItemPrice(Integer.parseInt(String.valueOf(product.getDefaultPrice())));
                cartItem.setName(product.getName());
            }

            orderDaoMem.setTotalPrice(total);
            orderDaoMem.setCartItems(cartItems);

            String json = gson.toJson(orderDaoMem);
            out.println(json);

        }
    }
}
