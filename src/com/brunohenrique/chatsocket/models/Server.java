package com.brunohenrique.chatsocket.models;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server extends Thread {

    private static ArrayList<BufferedWriter> clients;
    private static ServerSocket serverSocket;
    private String username;
    private Socket socket;
    private InputStream inputStream;
    private InputStreamReader inputStreamReader;
    private BufferedReader bufferedReader;

    /**
     * Method: constructor
     * @param socket
     */
    public Server (Socket socket){
        this.socket = socket;
        try {
            inputStream = socket.getInputStream();
            inputStreamReader = new InputStreamReader(inputStream);
            bufferedReader = new BufferedReader(inputStreamReader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method: run
     * Description:
     */
    public void run(){
        try {
            String message;
            OutputStream outputStream = this.socket.getOutputStream();
            Writer writer = new OutputStreamWriter(outputStream);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            clients.add(bufferedWriter);
            username = message = bufferedReader.readLine();

            while (!"!close".equalsIgnoreCase(message) && message != null) {
                message = bufferedReader.readLine();
                sendToAll(bufferedWriter, message);
                System.out.println(message);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * Method: sendToAll
     * Description:
     * @param bufferedWriterSaida
     * @param message
     * @throws IOException
     */
    public void sendToAll(BufferedWriter bufferedWriterSaida, String message) throws IOException{
        BufferedWriter buffer;
        for (BufferedWriter client : clients){
            buffer = (BufferedWriter)client;
            if(!(bufferedWriterSaida == buffer)){
                client.write(username + " -> " + message + "\r\n");
                client.flush();
            }
        }
    }

    public static void app(){
        try{
            //Cria os objetos necessário para instânciar o servidor
            JLabel lblMessage = new JLabel("Porta do Servidor:");
            JTextField txtPort = new JTextField("8000");
            Object[] texts = {lblMessage, txtPort };
            JOptionPane.showMessageDialog(null, texts);
            serverSocket = new ServerSocket(Integer.parseInt(txtPort.getText()));
            clients = new ArrayList<BufferedWriter>();
            JOptionPane.showMessageDialog(null,"Servidor ativo na porta: "+ txtPort.getText());

            while(true){
                System.out.println("Aguardando conexão...");
                Socket socket = serverSocket.accept();
                System.out.println("Cliente conectado...");
                Thread thread = new Server(socket);
                thread.start();
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
