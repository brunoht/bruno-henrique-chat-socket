package com.brunohenrique.chatsocket.jobs;

import com.brunohenrique.chatsocket.models.Client;
import com.brunohenrique.chatsocket.models.Server;
import com.brunohenrique.chatsocket.services.ServerServices;
import com.brunohenrique.chatsocket.services.handlers.ServerCommandHandler;
import com.brunohenrique.core.Application;

import java.io.*;
import java.net.SocketException;

public class ServerThread extends Thread {

    ServerServices serverServices = Application.serverServices;
    ServerCommandHandler serverCommandHandler = Application.serverCommandHandler;

    String inputLine, message;

    private Server server;
    PrintWriter out;
    BufferedReader in;

    public ServerThread(Server server, BufferedReader in, PrintWriter out){
        this.server = server;
        this.in = in;
        this.out = out;
        serverServices.clients.add(out);
    }

    public void run(){
        try {

            // First message: receive username
            Client client = new Client(in.readLine());
            out.println("Welcome, " + client.getUsername());
            sendMessage("User " + client.getUsername() + " is connected");

            // Send message
            while ((inputLine = in.readLine()) != null) {
                serverCommandHandler.handler(inputLine);
                message = client.getUsername() + ": " + inputLine;
                sendMessage(message);
            }
        } catch (SocketException e){
            System.err.println("unknown user has been disconnected");
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void sendMessage(String message){
        System.out.println(message);
        serverServices.sendToAll(message);
    }
}
