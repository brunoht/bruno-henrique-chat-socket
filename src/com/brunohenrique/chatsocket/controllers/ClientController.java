package com.brunohenrique.chatsocket.controllers;

import com.brunohenrique.chatsocket.jobs.ClientThread;
import com.brunohenrique.chatsocket.models.Client;
import com.brunohenrique.chatsocket.models.Server;
import com.brunohenrique.chatsocket.services.handlers.ClientCommandHandler;
import com.brunohenrique.core.Application;
import com.brunohenrique.chatsocket.services.ClientServices;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.Socket;

public class ClientController {

    ClientServices clientServices = Application.clientServices;
    ClientCommandHandler clientCommandHandler = Application.clientCommandHandler;

    /**
     * Method: run
     * Description: runs application
     */
    public void app(String[] args) {

        Client client = new Client(args[3]);
        Server server = new Server(args[1], Integer.parseInt(args[2]));

        try (
                Socket echoSocket = new Socket(server.getAddress(), server.getPortNumber());
                PrintWriter out = new PrintWriter(echoSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
                BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))
        ) {
            // First message: send username
            out.println(client.getUsername());
            String userInput = in.readLine();
            System.out.println(userInput);

            Thread thread = new ClientThread(in);
            thread.start();

            // Send message
            while ((userInput = stdIn.readLine()) != null) {
                clientCommandHandler.handler(userInput);
                out.println(userInput);
            }

        } catch (ConnectException e){
            System.err.println("Could not find server");
            System.exit(1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
