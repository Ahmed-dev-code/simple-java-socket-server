package clientserveurchaine;
import java.net.*;
import java.util.Scanner;
import java.io.*;
public class Clientchaine {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		// creation de la socket client
		Socket s_client= new Socket("127.0.0.1",9999);
		// preparation des variables pour envoyer l'information
		OutputStream out=s_client.getOutputStream();
		PrintWriter pw= new PrintWriter(out,true);
		Scanner sc= new Scanner(System.in);
	    System.out.println("donner votre nom et prenom");
		String msg= sc.next();
		pw.println(msg);
		// preparation des variables pour recevoir linformation
		InputStream in= s_client.getInputStream();
		InputStreamReader inr= new InputStreamReader(in); 
		BufferedReader br= new BufferedReader(inr);
		String rep= br.readLine();
		System.out.println("message du serveur est:\n"+rep);
		s_client.close();
		sc.close();

	}

}
