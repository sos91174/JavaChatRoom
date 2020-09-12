
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

//伺服器端
public class SingleServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(6666);
        System.out.println("等待客戶端連線");
        //返回客戶端的例項
        Socket socket = serverSocket.accept();
        //獲取輸出流
        PrintStream printStream = new PrintStream(socket.getOutputStream(),true);
        printStream.print("你好，我是伺服器端!！"+serverSocket.getLocalPort()+"\n");
        //獲取輸入流
        Scanner scanner = new Scanner(socket.getInputStream());
        scanner.useDelimiter("\n");
        if(scanner.hasNext()) {
            System.out.println(scanner.next());
        }

        //serverSocket.close();
    }
}