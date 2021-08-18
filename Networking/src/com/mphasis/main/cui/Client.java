package com.mphasis.main.cui;

import java.io.*;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {
	// write your code here

        try{
            Socket socket= new Socket("DESKTOP-45GJQ8N",5678);
            System.out.println("Connected to server...");
            InputStream is = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            System.out.println(br.readLine());


        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
