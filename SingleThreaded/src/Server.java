import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
public class Server {

    public void run() throws IOException{
        int port = 8080;
        ServerSocket socket = new ServerSocket(port);
        socket.setSoTimeout(10000);
        while(true){
            System.out.println("Listening on port no : "+port);
            Socket acceptconection = socket.accept();
            System.out.println("Connection accepted from client "+acceptconection.getRemoteSocketAddress());
            PrintWriter toClient = new PrintWriter(acceptconection.getOutputStream(), true);
            toClient.println("Hello from the server");
            BufferedReader fromClient = new BufferedReader(new InputStreamReader(acceptconection.getInputStream()));
        }
    }
    public static void main(String[] args) {
        try {
            Server server = new Server();
            server.run();
        } catch (IOException e) {
            System.out.println("Error handling client: " + e.getMessage());
        }
    }
}