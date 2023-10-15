package ServerPackage;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws IOException{
		int serverPort=1234;
		ServerSocket ss=new ServerSocket(serverPort);
		// TODO Auto-generated method stub
      System.out.println("je suis un serveur en attente la connexion d'un client");
      try {
      Socket socket=ss.accept();
      System.out.println("un client est connecte");
      socket.close();
	 } 
	catch (Exception e) {e.printStackTrace();}

	}
    

	
}