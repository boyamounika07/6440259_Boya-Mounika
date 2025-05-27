import java.io.*;
import java.net.*;

public class ChatClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 5000);

        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        String clientMsg, serverMsg;

        while (true) {
            System.out.print("Client: ");
            clientMsg = keyboard.readLine();
            output.println(clientMsg);
            if ("bye".equalsIgnoreCase(clientMsg)) break;

            serverMsg = input.readLine();
            System.out.println("Server: " + serverMsg);
        }
        socket.close();
    }
}
