
public class MainServer {

        public static void main(String[] args) {
            ChatServer chatServer = new ChatServer();
            Thread threadChatServer = new Thread((Runnable) chatServer);
            threadChatServer.start();
        }
}