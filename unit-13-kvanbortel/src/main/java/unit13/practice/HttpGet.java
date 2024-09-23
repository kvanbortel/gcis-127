package unit13.practice;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class HttpGet {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 8080); // Or www.google.com on 80

        OutputStream os = socket.getOutputStream();
        String message = "GET / HTTP/1.1\r\n" + "Host: localhost\r\n" + "Connection: close\r\n\r\n"; // or www.google.com
        os.write(message.getBytes());

        InputStream is = socket.getInputStream();
        byte[] buffer = new byte[1024];
        is.read(buffer);
        System.out.println(new String(buffer, 0, buffer.length));

        socket.close();
    }
}
