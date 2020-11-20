package Server;

import com.sun.tools.javac.Main;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    public static void main(String[] args) {
        ArrayList<Socket> clients = new ArrayList<>();
        Socket socket  = null;
        try {
            ServerSocket serverSocket = new ServerSocket(8189);  // номер порта (незанятый ... > 8100 до 65000)
            System.out.println("INFO: server run");

            while (true){
                socket = serverSocket.accept();   //  как только происходит подключение клиента к серверу, сохраняем его в переменную socket
                DataInputStream in = new DataInputStream(socket.getInputStream());          // объект принимающий данные потока ввода
                DataOutputStream out = new DataOutputStream((socket.getOutputStream()));    // объект выдающий данные потока вывода
                System.out.println("Подключился клиент");
                clients.add(socket); //Добавляем клиента в список
               // System.out.println(socket);

                new clientThread("",socket).start(); // открываем отдельный поток для каждого нового подключения
         }
        }catch (IOException exception){
            exception.printStackTrace();
        }

    }

// поток для соединения с каждым клиентом
private static class clientThread extends Thread{
        private String nikNane;
        private Socket socket;

    public clientThread (String nikNane, Socket socet) {
            this.nikNane = nikNane;
            this.socket = socet;
        }

    public String    getNikNane() { return nikNane;}
    public void      setNikNane(String nikNane) { this.nikNane = nikNane;}
    public Socket    getSocket() {return socket;}
    public void      setSocket(Socket socket) {this.socket = socket;}

    @Override
        public void run() {
         /*
                        Client client = new Client("new",clients.lastIndexOf(clients), clients.get(clients.lastIndexOf(clients)));
                        System.out.println(client.getNikName());
                        System.out.println(client.getId());
                        System.out.println(client.getSocket());
                    */
            try {
                while (true){                                   // цикл, для работы соединения
                    System.out.println("Ожидаем сообщение...");
                    String request = in.readUTF();   // переменная, считывающая днные из потока в кодировке UTF
                    System.out.println("Клиент прислал сообщение: "+request);
                    for (Socket socket:clients) {    // Перебираем список клиентов
                        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                        out.writeUTF("Какой-то клиент отправил сообщение: " + request);
                    }
                }
            }catch (IOException exception) {
                exception.printStackTrace();
            }
       }
      }





// новый класс - клиенты
public static class Client {
        private String nikName = "неизвестный";
        private int id;
        private Socket socket;

        public Client(String nikName, int id, Socket socket) {
            this.nikName = nikName;
            this.id = id;
            this.socket = socket;
        }

        public String getNikName() {
            return nikName;
        }

        public void setNikName(String nikName) {
            this.nikName = nikName;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Socket getSocket() {
            return socket;
        }

        public void setSocket(Socket socket) {
            this.socket = socket;
        }
    }

}
