import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        String host = "netology.homework";
        int port = 8080;

        try (Socket clientSocket = new Socket(host, port);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        ){
            Scanner scanner = new Scanner(System.in);
            String res = in.readLine();
            System.out.println(res);
            String myName = scanner.nextLine();
            out.println(myName);
            res = in.readLine();
            System.out.println(res);
            res = in.readLine();
            System.out.println(res);
            String age = scanner.nextLine();
            out.println(age);
            res = in.readLine();
            System.out.println(res);

        } catch (IOException ex){
            ex.getMessage();
        }
    }
}