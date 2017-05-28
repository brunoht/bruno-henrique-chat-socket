package com.brunohenrique.chatsocket.jobs;

import java.io.BufferedReader;
import java.io.IOException;

public class ClientThread extends Thread{

    private BufferedReader in;

    public ClientThread(BufferedReader in){
        this.in = in;
    }

    public void run(){
        String message;

        try {
            while ((message = in.readLine()) != null) {
                System.out.println(message);
            }
        } catch (IOException e) {
            System.err.println("Connection lost with server");
            System.exit(1);
        }
    }
}
