package com.brunohenrique.chatsocket.services;

import java.io.PrintWriter;
import java.util.ArrayList;

public class ServerServices {

    public ArrayList<PrintWriter> clients = new ArrayList<>();

    public void sendToAll(String message){
        PrintWriter printWriter;
        for(PrintWriter out : clients){
            printWriter = out;
            printWriter.println(message);
        }
    }
}
