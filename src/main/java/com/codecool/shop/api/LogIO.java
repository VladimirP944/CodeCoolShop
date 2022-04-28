package com.codecool.shop.api;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;

public class LogIO {

    public LogIO() {};

    public void exportLog(String logOutput)
            throws IOException, ClassNotFoundException {

        String[] splitLog= logOutput.split(",");
        StringBuilder formattedLog = new StringBuilder();
        LocalDateTime date = LocalDateTime.now();

        formattedLog.append("CHECKOUT LOG START AT " + date.toString() + "\n");
        for (int i = 0; i < splitLog.length; i++) {
            formattedLog.append(splitLog[i]);
            formattedLog.append("\n");
        }
        formattedLog.append("CHECKOUT LOG END");


        FileOutputStream fileOutputStream
                = new FileOutputStream(date.toString() +".json");
        ObjectOutputStream objectOutputStream
                = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(formattedLog.toString());
        objectOutputStream.flush();
        objectOutputStream.close();
    }

    public void exportOrder(String orderOutput)
            throws IOException, ClassNotFoundException {

        String[] splitOrder= orderOutput.split(",");
        StringBuilder formattedOrder = new StringBuilder();
        LocalDateTime date = LocalDateTime.now();

        for (int i = 0; i < splitOrder.length; i++) {
            formattedOrder.append(splitOrder[i]);
            formattedOrder.append("\n");
        }
        formattedOrder.append("Checkout time: " + date.toString());

        FileOutputStream fileOutputStream = new FileOutputStream("order_" + splitOrder[0].split(" ")[2] + ".json");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(formattedOrder.toString());
        objectOutputStream.flush();
        objectOutputStream.close();
    }
}