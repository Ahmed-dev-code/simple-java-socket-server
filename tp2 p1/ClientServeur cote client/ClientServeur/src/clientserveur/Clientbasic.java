package clientserveur;
import java.io.*;
import java.net.*;
public class Clientbasic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    try {
    	// On crée un objet InetAdress sur  l'interface de loopback
    	InetAddress adr = InetAddress.getByName("127.0.0.1");
    	// On crée une socket
    	Socket s = new Socket (adr, 9876);
    	System.out.println("Socket client crée");
    	// On crée 2 flots d'entrée et un de sortie
    			DataInputStream saisie = new DataInputStream(new BufferedInputStream (System.in));
    			DataInputStream entree = new DataInputStream (new BufferedInputStream (s.getInputStream()));
    			PrintStream sortie = new PrintStream ( new BufferedOutputStream(s.getOutputStream()));
    			// On envoie du texte au serveur et on
    			// affiche l'echo reçu
    			while (true) {
    				// Saisie du texte à envoyer au serveur
    				System.out.println("Texte ? ");
    				@SuppressWarnings("deprecation")
					String buff = saisie.readLine();
    				// Si on entre "FIN", on quitte
    				//envoie le texte saisi au serveur
    				sortie.println(buff);
    				sortie.flush();
    				// On Ahffiche l'écho du server
    				@SuppressWarnings("deprecation")
					String buff2 = entree.readLine();
    				System.out.println(buff2);
    				if (buff.equals("FIN")) break;
    			}
    			// On ferme la socket
    		System.out.println("fin de discussion");
    			s.close();
    
    }
    catch (Exception e) { 
		return;
	}
    
    
    
	}
}
