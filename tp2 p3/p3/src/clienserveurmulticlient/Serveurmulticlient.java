package clienserveurmulticlient;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Serveurmulticlient {

public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		ServerSocket s_server= new ServerSocket(1234);
		System.out.println(" le serveur attends la connection des clients");
		Socket s= s_server.accept();
		System.out.println("un client est connecte");
		InputStream input=s.getInputStream();
		OutputStream output=s.getOutputStream();
		//lire um nombre du client
		int nb= input.read();
		int res= nb*3;
		System.out.println("resulta nb est:" + nb);
		output.write(res);
		System.out.println("envoyer le resultat");
		s_server.close();
	}

}
