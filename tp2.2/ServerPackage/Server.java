package ServerPackage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import ClientPackage.CalculatorRequest;

public class Server {
 public static void main (String[] args) {
 try {
 ServerSocket serverSocket = new ServerSocket(1234);
 System.out.println("I am a server waiting for a client connexion...");
 Socket socket = serverSocket.accept();
 
 InputStream inputStream = socket.getInputStream();
	ObjectInputStream ois = new ObjectInputStream(inputStream);
	CalculatorRequest op = (CalculatorRequest) ois.readObject();


 double req= op.operand1;
 switch (op.operator) {
 case 1:

 System.out.println("The client selected Addition operation");
 req += op.operand2 ;
 break;
 case 2:
 System.out.println("The client selected Soustraction operation");
 req -= op.operand2 ;
 break;
 case 3:
 System.out.println("The client selected Multiplication operation");
 req *= op.operand2 ;
 break;
 case 4:
 System.out.println("The client selected Division operation");
 req /= op.operand2 ;
 break;
 default:
 System.out.println("Return to Client.");
 }
	op.setResultat(req);
	OutputStream os = socket.getOutputStream();
	ObjectOutputStream oos = new ObjectOutputStream(os);
	oos.writeObject(op);
	

 System.out.println("Closing the socket...");
 socket.close();
 serverSocket.close();
 } catch (Exception e) {
 e.printStackTrace();
 }
 }
}