package clienserveurmulticlient;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client2 {

    public static void main(String[] args) throws IOException {
        // Connect to the server at IP "127.0.0.1" and port 1234
        Socket s_client = new Socket("127.0.0.1", 1234);
        
        // Set up the input and output streams to communicate with the server
        InputStream input = s_client.getInputStream();
        OutputStream output = s_client.getOutputStream();
        
        // Create a Scanner to take input from the user
        Scanner sc = new Scanner(System.in);
        
        // Prompt the user for a number to send to the server
        System.out.println("Please enter a number:");
        int nb = sc.nextInt();
        
        // Send the number to the server
        output.write(nb);
        System.out.println("Value sent to server: " + nb);
        
        // Read the result sent back by the server
        int result = input.read();
        
        // Display the result from the server
        System.out.println("The result from the server is: " + result);
        
        // Close the resources
        sc.close();
        s_client.close();
    }
}
