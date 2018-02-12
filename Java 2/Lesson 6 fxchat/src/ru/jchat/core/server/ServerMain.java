package ru.jchat.core.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerMain {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8189))
        {
            System.out.println("Server started... Waiting clients...");

            while (true){
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");
                new ClientHandler(socket);
            }



        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
