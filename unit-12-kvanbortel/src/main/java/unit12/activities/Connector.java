package unit12.activities;

import java.io.IOException;
import java.net.Socket;

public class Connector {
    public static void main(String[] args) throws IOException {
        Socket socket1 = new Socket("www.google.com", 80);
        System.out.println("Google worked");
        socket1.close();
        Socket socket2 = new Socket("www.npr.org", 443);
        System.out.println("NPR worked");
        socket2.close();
        Socket socket3 = new Socket("swec-123.rit.edu", 33075);
        System.out.println("SWEC worked");
        socket3.close();
    }
}
