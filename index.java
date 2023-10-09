//------>  MyServer.java (Server)

import java.io.*;
import java.net.*;

public class MyServer {
    public static void main(String[] args) {
        int port = 1234;

        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server is listening on port " + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket);

                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                String clientMessage = in.readLine();
                if (clientMessage != null) {
                    String[] parts = clientMessage.split(" ");
                    String name = parts[parts.length - 1];

                    out.println("Walikum Salam " + name);
                }

                in.close();
                out.close();
                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

//----->   MyClient.java (Client)

import java.io.*;
import java.net.*;

public class MyClient {
    public static void main(String[] args) {
        String serverAddress = "localhost";
        int serverPort = 1234;

        try {
            Socket socket = new Socket(serverAddress, serverPort);

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String clientMessage = "Hello My name is John"; // Replace "John" with your name
            out.println(clientMessage);

            String serverResponse = in.readLine();
            System.out.println("Server Response: " + serverResponse);

            out.close();
            in.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

