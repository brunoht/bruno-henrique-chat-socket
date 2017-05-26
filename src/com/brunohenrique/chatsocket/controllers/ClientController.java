package com.brunohenrique.chatsocket.controllers;

import com.brunohenrique.core.Application;
import com.brunohenrique.chatsocket.services.ClientServices;

import java.io.IOException;

public class ClientController {

    ClientServices clientServices = Application.clientServices;

    /**
     * Method: run
     * Description: runs application
     */
    public void run() {
        try {
            clientServices.connect();
            clientServices.listener();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
