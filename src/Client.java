import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        String input = "";
        String inFromServer = "";
        try {
            Socket socket = new Socket("localhost",1444);
            BufferedReader fromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedReader fromUser = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter out = new PrintWriter(socket.getOutputStream(),true);

            while(true){
                if(fromServer.ready()){
                    inFromServer = fromServer.readLine();
                    if(!inFromServer.equals(-1)){
                        System.out.println("From Server " + inFromServer);
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