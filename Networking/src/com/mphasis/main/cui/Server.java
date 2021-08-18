package com.mphasis.main.cui;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args){

        try(ServerSocket serverSocket = new ServerSocket(5678);
            ){
            System.out.println("Server started");
            while(true) {
                Socket socket = serverSocket.accept();

                //System.out.println("Client connected");
                //System.out.println(socket.getInetAddress());

                OutputStream outputStream = socket.getOutputStream();
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(outputStream));

                bw.write("Hello World\n");
                bw.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }



}
