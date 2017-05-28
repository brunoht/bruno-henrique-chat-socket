package com.brunohenrique.chatsocket.controllers;

import com.brunohenrique.chatsocket.jobs.ServerThread;
import com.brunohenrique.chatsocket.models.Server;
import com.brunohenrique.chatsocket.services.ServerServices;
import com.brunohenrique.core.Application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerController {

    ServerServices serverServices = Application.serverServices;

    public void app(String[] args){

        Server server = new Server(Integer.parseInt(args[1]));

        try {
            ServerSocket serverSocket = new ServerSocket(server.getPortNumber());

            while (true) {
                System.out.println("Waiting for connection...");
                Socket clientSocket = serverSocket.accept();
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                Thread thread = new ServerThread(server, in, out);
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
