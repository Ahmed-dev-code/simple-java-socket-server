package clienserveurmulticlient;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server2 {

    public static void main(String[] args) throws IOException {
        try (// Create server socket to listen on port 1234
        ServerSocket serverSocket = new ServerSocket(1234)) {
            System.out.println("Server is waiting for client connections...");
            
            // Continuously accept clients
            while (true) {
                // Accept a new client connection
                Socket clientSocket = serverSocket.accept();
                System.out.println("A new client is connected");
                
                // Start a new thread to handle the client
                ClientHandler clientHandler = new ClientHandler(clientSocket);
                new Thread(clientHandler).start();
            }
        }
    }

    // Inner class that handles the client communication
    static class ClientHandler implements Runnable {
        private Socket clientSocket;

        // Constructor to initialize the client socket
        public ClientHandler(Socket socket) {
            this.clientSocket = socket;
        }

        @Override
        public void run() {
            try {
                // Get input and output streams for communication with the client
                InputStream input = clientSocket.getInputStream();
                OutputStream output = clientSocket.getOutputStream();

                // Read a number sent by the client
                int nb = input.read();
                // Simulate some processing time (e.g., waiting for 2 seconds)
                try {
                    System.out.println("Simulation du traitement...");
                    Thread.sleep(4000); // 2000 milliseconds = 2 seconds
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


                int res = nb * 3;

                System.out.println("Received number: " + nb);
                System.out.println("Result (number * 3): " + res);

                // Send the result back to the client
                output.write(res);
                System.out.println("Result sent to client");

                // Close the client connection
                clientSocket.close();
                System.out.println("Client disconnected");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
