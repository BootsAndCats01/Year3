package FirstTerm.Week3.MultipleFiles;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public final static int SOCKET_PORT = 13267;
    public final static String DIR = "C:/Temp/";

    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = null;
        BufferedInputStream bufferedInputStream = null;
        OutputStream outputStream = null;
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            serverSocket = new ServerSocket(SOCKET_PORT);
            while (true) {
                System.out.println("Waiting..");
                try {

                    socket = serverSocket.accept();
                    System.out.println("Accepted connection: " + socket);

//                    File myFile = new File(FILE_TO_SEND);
                    File[] files = new File(DIR).listFiles();

                    for (File file : files) {
                        byte[] myFileBytes = new byte[(int) file.length()];

                        String name = file.getName();
                        fileInputStream = new FileInputStream(file);
                        bufferedInputStream = new BufferedInputStream(fileInputStream);
                        bufferedInputStream.read(myFileBytes, 0, myFileBytes.length);
                        outputStream = socket.getOutputStream();

                        System.out.println("Sending " + name + " (" + myFileBytes.length + " bytes)");

                        outputStream.write(myFileBytes, 0, myFileBytes.length);
                        outputStream.flush();

                    }
                } finally {
                    if (bufferedInputStream != null) bufferedInputStream.close();
                    if (outputStream != null) outputStream.close();
                    if (socket != null) socket.close();
                }
            }
        } finally {
            if (serverSocket != null) serverSocket.close();
        }

    }
}
