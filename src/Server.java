import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        String input = "";
        String inFromClient = "";
        try (ServerSocket serverSocket = new ServerSocket(1444)) {
            Socket socket = serverSocket.accept();
            System.out.println("Welcome cleint!");
            BufferedReader fromClient = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedReader fromUser = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter out = new PrintWriter(socket.getOutputStream(),true);

            while(true){
                if(fromClient.ready()){
                    inFromClient = fromClient.readLine();
                    if(!inFromClient.equals(-1)){
                        System.out.println("From Client " + inFromClient);
                    }
                }
                if(fromUser.ready()){
                    input = fromUser.readLine();
                    out.println(input);
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}