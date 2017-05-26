package com.brunohenrique.chatsocket.services;

import com.brunohenrique.chatsocket.models.Client;
import java.io.*;
import java.net.Socket;

public class ClientServices {

    private Socket socket;
    private OutputStream outputStream;
    private Writer writer;
    private BufferedWriter bufferedWriter;
    private Client client = new Client("client", "localhost", 8000);

    /**
     * Method: setDefaultClient
     * Description: set actual client as default
     */
    public void setDefaultClient() {
        setClient(new Client("client", "localhost", 8000));
    }

    /**
     * Method: setClient
     * Description: change default client
     * @param client
     */
    public void setClient(Client client) {
        this.client = client;
    }

    /**
     * Method: getClient
     * Description: get actual client
     * @return
     */
    public Client getClient() {
        if(this.client == null) setDefaultClient();
        return this.client;
    }

    /**
     * Method: connect
     * Description: connect to the server using socket connection
     * @throws IOException
     */
    public void connect() throws IOException{
        client = getClient();
        socket = new Socket(client.getAddress(), client.getPort());
        outputStream = socket.getOutputStream();
        writer = new OutputStreamWriter(outputStream);
        bufferedWriter = new BufferedWriter(writer);
        bufferedWriter.write(client.getUsername() + "\r\n");
        bufferedWriter.flush();
    }

    /**
     * Method: sendMessage
     * Description: sends message to the server
     * @param message
     * @throws IOException
     */
    public void sendMessage(String message) throws IOException{
        if(message.equals("!close")){
            bufferedWriter.write("Disconnected \r\n");
            this.close();
        }else{
            bufferedWriter.write(message + "\r\n");
        }
        bufferedWriter.flush();
    }

    /**
     * Method: listener
     * Description:
     * @throws IOException
     */
    public void listener() throws IOException {
        InputStream inputStream = socket.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String message = "";

        while(!"!close".equalsIgnoreCase(message)) {
            if (bufferedReader.ready()) {
                message = bufferedReader.readLine();
                if (message.equals("!close")) {
                    System.out.println("domain.Server is disconnected");
                } else {
                    System.out.println(message);
                }
            }
        }
    }

    /**
     * Method: close
     * Description: close connection with server and exit client application
     * @throws IOException
     */
    public void close() throws IOException{
        sendMessage("Connection has been closed. Thanks for using ChatSocket");
        bufferedWriter.close();
        writer.close();
        outputStream.close();
        socket.close();
    }

}
