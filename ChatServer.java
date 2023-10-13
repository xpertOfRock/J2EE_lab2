import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.TreeMap;

public class ChatServer implements Runnable {
    private Map<Integer, Socket> mapClient = new TreeMap<Integer, Socket>();
    private InputStream inputStreamClient;

    @Override
    public void run() {
        try {
            ServerSocket server = new ServerSocket(8887);
            System.out.println("Server started. Waiting for clients.");
            int numberClient = 1;
            Socket client = null;

            while (true) {
                client = server.accept();
                Thread clientThread = new Thread(new ClientThread(client, this, numberClient));
                clientThread.setDaemon(true);
                clientThread.start();
                mapClient.put(numberClient, client);
                numberClient++;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void sendMessageForAllClient(int numberClient) {

        BufferedReader inputUser = new BufferedReader(new InputStreamReader(System.in));;

            while (true) {
                System.out.println("Enter message for clients: ");
                try {
                    String clientMessage = inputUser.readLine();
                    PrintWriter out = new PrintWriter(new OutputStreamWriter(mapClient.get(numberClient).getOutputStream()));
                    for(int i = 1; i <= mapClient.size(); i++) {
                        new PrintWriter(new OutputStreamWriter(mapClient.get(i).getOutputStream()), true).println(clientMessage);
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
}