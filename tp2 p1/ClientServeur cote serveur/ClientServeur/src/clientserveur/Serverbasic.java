package clientserveur;
import java.io.*;
import java.net.*;

public class Serverbasic {
	//socket server port on which it will listen
	private static int port = 9876;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
     try {
    	 System.out.println(" creation de la sockets serveur\n");
		// creation d'une socket serveur
    	 ServerSocket server= new ServerSocket(port);
    	// lancer une socket en ecout des demandes des clients
    	 Socket s_service= server.accept();
    	 // une connexion est active
    	 System.out.println(" le serveur est en ecout des demadents\n");
    	// On crée un flot d'entrée et un de sortie
    		BufferedReader entree = new BufferedReader (new InputStreamReader ( s_service.getInputStream()));
    		PrintWriter sortie = new PrintWriter ( new OutputStreamWriter ( s_service.getOutputStream()));
    		// On boucle sur l'echo
    		while (true){
    			// On lit une ligne en entrée
    			String buff = entree.readLine();
    			// On quitte si c'est égal à "FIN"
    			System.out.println(buff);
    			// On renvoie l'echo au client
    			sortie.println(buff);
    			sortie.flush();
    			if (buff.equals("FIN")) 
				{System.out.println(" client cloture"); break;}
    		}
    	// Le client s'est déconnecté
    	System.out.println("Fermeture de la connexion...");	
    	s_service.close(); 
		server.close();
     }
     
     catch (Exception e) {
    	 return;
    	}
	}
}
