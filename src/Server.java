

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Server {

    public static void main(String[] args) throws Exception{

        ServerSocket server = new ServerSocket(8080); //http://localhost:8080/
        System.out.println("Listening for a connection on port 8080");


        while (true) {//while loop allows program to run forever, continuously listening for connection on port 8080




            try(Socket socket = server.accept()) {


                //Print info on server side of GET request
                InputStreamReader isr = new InputStreamReader(socket.getInputStream());
                BufferedReader reader = new BufferedReader(isr);
                String line = reader.readLine();
                while (!line.isEmpty()) {

                    System.out.println(line);
                    line = reader.readLine();

                }


                Date today = new Date(); //new Date automatically gives today's date and time
                String httpResponse = "HTTP/1.1 200 OK\r\n\r\n" + today + " :Welcome to this random page!";
                socket.getOutputStream().write(httpResponse.getBytes("UTF-8"));



            }





        }










    }
}
