import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        int port = 8080;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true){
                try (Socket clientSocket = serverSocket.accept();
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));) {
                    System.out.println("New connection accepted");
                    out.println("Write your name:");
                    final String name = in.readLine();
                    out.println(String.format("Hi %s, your port is %d", name, clientSocket.getPort()));
                    out.println("Enter your age:");
                    String answer = in.readLine();
                    try{
                        int age = Integer.parseInt(answer);
                        if (age < 18){
                            out.println("Welcome to child side! Lets play!");
                        } else {
                            out.println("Welcome to adult side! Lets work!");
                        }
                    } catch (NumberFormatException ex){
                        ex.getMessage();
                    }
                }
            }
        } catch (IOException ex) {
            ex.getMessage();
        }

    }
}