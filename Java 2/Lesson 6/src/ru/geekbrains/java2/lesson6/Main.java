package ru.geekbrains.java2.lesson6;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8189))
        {
            System.out.println("Server started... Waiting clients...");
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");
            Scanner in = new Scanner(socket.getInputStream());
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            while(true)
            {
                String msg = in.nextLine();
                System.out.println("from client: " + msg);
                out.println("echo " + msg);
                if (msg.equals("/end")) break;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
