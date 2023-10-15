package ServerPackage;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		
		try {
			ServerSocket ss=new ServerSocket(1234);
			System.out.println("Je suis un serveur en attente la connexion d'un client ");
		    Socket s=ss.accept();
		    System.out.println("Un client connecté ");
		    InputStream is= s.getInputStream();
		     OutputStream os=s.getOutputStream();
			System.out.println("J'attend un nombre x = ");
		    int x=is.read();
		  
		    int nb=x*5;
			System.out.println("La réponse: ");	
			
			os.write(nb);
			//La derniére étape: Fermer socket
			s.close();
		  
	
		  }catch (IOException e){
			e.printStackTrace();
		}
		
	}

}
    

	
