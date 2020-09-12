

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

//客戶端
public class SingleClient {
    public static void main(String[] args) throws UnknownHostException, IOException {
        Socket socket = new Socket("127.0.0.1", 6666);
        //獲取輸入流
        Scanner scanner = new Scanner(socket.getInputStream());
        scanner.useDelimiter("\n");
        if(scanner.hasNext()) {
            System.out.println(scanner.next());
        }
        //獲取輸出流
        PrintStream printStream = new PrintStream(socket.getOutputStream(),true);
        printStream.print("你好，我是客戶端！"+socket.getLocalPort()+"\n");
        socket.close();
    }
}