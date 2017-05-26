package com.brunohenrique.core.helpers;

import com.brunohenrique.core.Application;
import com.brunohenrique.chatsocket.controllers.ClientController;
import com.brunohenrique.chatsocket.controllers.ServerController;
import com.brunohenrique.chatsocket.models.Server;

public class Routes {

    ClientController clientController = Application.clientController;
    ServerController serverController = Application.serverController;

    public void call(String routeName, String[] args) {
        switch (routeName){
            case "server":
                Server.app();
                break;
            case "client":
                clientController.run();
                break;
        }
    }
}
