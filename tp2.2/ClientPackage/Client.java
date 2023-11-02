package ClientPackage;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;
import java.net.InetAddress;
import java.net.InetSocketAddress;

public class Client {
    public static void main(String[] args) {
        try {
            int rep, choice = 0;
            System.out.println("I am a client not yet connected ... ");
            Socket socket = new Socket("localhost",1234);
            System.out.println("Establish a connection to the server");
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Give a number:");
            double operand1 = scanner.nextInt();
            System.out.println("I send the number " + operand1 + " to the server");
            

            do {
                System.out.println("Menu:");
                System.out.println("1. Addition");
                System.out.println("2. Subtraction");
                System.out.println("3. Multiplication");
                System.out.println("4. Division");
                System.out.print("Enter your choice: ");
                if (scanner.hasNextInt()) {
                    choice = scanner.nextInt();
                    scanner.nextLine();
                    if (choice < 1 || choice > 4)
                        System.out.println("Invalid input. Please enter a number corresponding to your choice.");
                }
                
            } while (choice < 1 || choice > 4);
            
            System.out.println("Give a second number:");
            double operand2 = scanner.nextInt();
            System.out.println("I send the number " + operand2 + " to the server");
            CalculatorRequest op = new CalculatorRequest(operand1, (char)choice, operand2);
			ObjectOutputStream oos = new ObjectOutputStream(outputStream);
			ObjectInputStream ois = new ObjectInputStream(inputStream);
			op = ( CalculatorRequest) ois.readObject();
            oos.writeObject(op);
			System.out.println("\n" + op. operand1  + " " + op.operator + " " + op. operand2  + " = " + op.req);
            System.out.println("Closing the client socket...");
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}