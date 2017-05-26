package com.brunohenrique.chatsocket.models;

public class Client {

    private String username;
    private String address;
    private int port;

    public Client() {}

    public Client(String username, String address, int port) {
        this.username = username;
        this.address = address;
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
