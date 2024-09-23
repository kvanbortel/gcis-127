package unit12.activities;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Name {

    public static void main(String[] args) throws IOException {
        Socket client = new Socket("somehost.net", 54321);
        OutputStream out = client.getOutputStream();
        PrintWriter printer = new PrintWriter(out);
        printer.println("Kayla");
        printer.flush();
        client.close();
    }
}
