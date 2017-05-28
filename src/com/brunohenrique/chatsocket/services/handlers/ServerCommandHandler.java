package com.brunohenrique.chatsocket.services.handlers;

public class ServerCommandHandler {

    /**
     * Interprets Server commands before showing messages
     */
    public void handler(String message){
        message = message.toLowerCase();
        switch (message){
            case "!close-server":
                closeServer();
                break;
            case "!kick":
                kick();
                break;
            case "!kick-all":
                kickAll();
                break;
        }
    }

    private void closeServer(){
        System.out.println("Closing connections");
        System.out.println("Closing server application");
        System.out.println("Finished");
        System.exit(0);
    }
    private void kick(){
        // not implemented yet
    }
    private void kickAll(){
        // not implemented yet
    }
}
