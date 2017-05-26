package com.brunohenrique.core;

import com.brunohenrique.chatsocket.controllers.ClientController;
import com.brunohenrique.chatsocket.controllers.ServerController;
import com.brunohenrique.chatsocket.services.ClientServices;
import com.brunohenrique.chatsocket.services.ServerServices;
import com.brunohenrique.core.helpers.Routes;

public class Application {

    /**
     * DEPENDENCY INJECTION
     *
     * Register all Dependency Injections (DI) here
     *
     * - HELPERS
     * - CONTROLLERS
     * - SERVICES
     *
     */

    // SERVICES
    public static ClientServices clientServices = new ClientServices();
    public static ServerServices serverServices = new ServerServices();

    // CONTROLLERS
    public static ClientController clientController = new ClientController();
    public static ServerController serverController = new ServerController();

    // HELPERS
    public static Routes routes = new Routes();

    /**
     * Method: start
     * Description: Start your application
     * @param args
     */
    public static void start(String[] args){
        routes.call(args[0], args);
    }

}
