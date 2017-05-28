package com.brunohenrique.chatsocket.services.handlers;

public class ClientCommandHandler {

    /**
     * Interprets Client commands before showing messages
     */
    public void handler(String message){
        switch (message){
            case "FIM":
            case "!close":
                close();
                break;
            case "!username":
                username();
                break;
        }
    }

    private void close(){
        System.out.println("Closing application");
        System.out.println("Finished");
        System.exit(0);
    }
    private void username(){
        // not implemented yet
    }
}
