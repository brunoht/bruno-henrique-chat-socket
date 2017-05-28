package com.brunohenrique.chatsocket.models;

import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Server {

    private String address;
    private int portNumber;

    public Server(int portNumber){
        this.portNumber = portNumber;
    }

    public Server(String address, int portNumber){
        this.address = address;
        this.portNumber = portNumber;
    }

    public String getAddress(){
        return address;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public int getPortNumber() {
        return portNumber;
    }

    public void setPortNumber(int portNumber) {
        this.portNumber = portNumber;
    }
}
