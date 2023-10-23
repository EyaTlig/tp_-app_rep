package ClientPackage;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
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
            InetAddress serverInetAddress = InetAddress.getByName("10.26.13.158");
            InetSocketAddress serverSocketAddress = new InetSocketAddress(serverInetAddress, 1234);
            Socket socket = new Socket();
            socket.connect(serverSocketAddress);

            System.out.println("Establish a connection to the server");

            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Give a number:");
            int nb = scanner.nextInt();
            outputStream.write(nb);
            System.out.println("I send the number " + nb + " to the server");
            

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
            int n = scanner.nextInt();
            outputStream.write(n);
            System.out.println("I send the number " + n + " to the server");

            switch (choice) {
                case 1:
                    System.out.println("You selected Addition operation");
                    outputStream.write(1);
                    System.out.println("I'm waiting for the response from the server");
                    rep = inputStream.read();
                    System.out.println("Response = " + nb + "+" +n + "  = " + rep);

                    break;
                case 2:
                    System.out.println("You selected Subtraction operation");
                    outputStream.write(2);
                    System.out.println("I'm waiting for the response from the server");
                    rep = inputStream.read();
                    System.out.println("Response = " + nb + "-" +n + "  = " + rep);

                    break;
                case 3:
                    System.out.println("You selected Multiplication operation");
                    outputStream.write(3);
                    System.out.println("I'm waiting for the response from the server");
                    rep = inputStream.read();
                    System.out.println("Response = " + nb + "*" +n + "  = " + rep);
 

                    break;
                case 4:
                    System.out.println("You selected Division operation");
                    outputStream.write(4);
                    System.out.println("I'm waiting for the response from the server");
                    rep = inputStream.read();
                    System.out.println("Response = " + nb + "/" +n + "  = " + rep);


                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }


            System.out.println("Closing the client socket...");
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}