package ClientPackage;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.*;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    
		try {
			Socket socket=new Socket("localhost",1234);
			System.out.println("un client est connecté ");	
		    Scanner scanner =  new Scanner(System.in);
		    
			System.out.println("Donner un nb " );
		    int x=scanner.nextInt();
		  
		    OutputStream os=socket.getOutputStream();
		    os.write(x); 
		
		    InputStream is= socket.getInputStream();
		    int nb = is.read();
			System.out.println("La réponse est " +nb);
		    socket.close();
	
		  }catch (IOException e){
			e.printStackTrace();
		}
	}
}
