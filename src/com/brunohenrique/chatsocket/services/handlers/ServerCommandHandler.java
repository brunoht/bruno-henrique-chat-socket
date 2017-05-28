package com.brunohenrique.chatsocket.services.handlers;

public class ServerCommandHandler {

    /**
     * Interprets Server commands before showing messages
     */
    public void handler(String message, String[] args){
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

    }
    private void kick(){

    }
    private void kickAll(){

    }
}
