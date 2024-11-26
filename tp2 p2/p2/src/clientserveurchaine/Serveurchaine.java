package clientserveurchaine;
import java.net.*;
import java.io.*;
public class Serveurchaine  {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//creation de la socket serveur
		ServerSocket s_server= new ServerSocket(9999);
		Socket s= s_server.accept();
		// preparation des variables pour recevoir l'information
		InputStream in= s.getInputStream();
		InputStreamReader inr= new InputStreamReader(in); 
		BufferedReader br= new BufferedReader(inr);
		// preparation des variables pour envoyer l'information
		OutputStream out=s.getOutputStream();
		PrintWriter pw= new PrintWriter(out,true);
		// lancement de la communication
		System.out.println(" Bonjour, jattends votre nom et prenom");
		//reception du message du client
		String ch=br.readLine();
		System.out.println("message recu est :"+ch);
		// envoyer la reponse au client
		String rep=" bien recu votre message est: "+ch;
		pw.println(rep);
		System.out.println("fermeteure de la socket serveur");
		s.close();
		s_server.close();	
				
	}

}
