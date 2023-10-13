// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        ConnectInputMessage connectWithServer = new ConnectInputMessage();
        Thread tConnectInputMessage = new Thread(connectWithServer);
        tConnectInputMessage.start();

        ReceiveMessageFromServer receiveMessage =
                new ReceiveMessageFromServer(connectWithServer.getInputStreamServer());
        Thread tReceiveMessage = new Thread(receiveMessage);
        tReceiveMessage.start();
    }
}