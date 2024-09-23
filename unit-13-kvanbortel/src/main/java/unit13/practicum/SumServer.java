package unit13.practicum;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;
import java.util.List;

public class SumServer implements Runnable {
    private ServerSocket serverSocket;
    private Socket client;
    private Duplexer duplexer;
    private int sum = 0;
    private List<Duplexer> clientInfo;

    public SumServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        client = serverSocket.accept();
        duplexer = new Duplexer(client);
    }

    @Override
    public void run() {
        try {
            handle();
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
    }

    public void handle() throws IOException {
        clientInfo.add(duplexer);
        while (true) {
            int num = Integer.parseInt(duplexer.read());
            System.out.println("Received: " + num);
            sum += num;
            duplexer.send(String.valueOf(sum));
            sendToPeers();
            System.out.println("Sending: " + sum);
            if (num == 0) {
                break;
            }
        }
        duplexer.close();
    }

    public void sendToPeers() {
        for (Duplexer peer: clientInfo) {
            peer.send(String.valueOf(sum));
        }
    }

    public static void main(String[] args) throws IOException {
        SumServer ss = new SumServer(9999);
        Thread ssThread = new Thread(ss);
        ssThread.start();
    }
}
