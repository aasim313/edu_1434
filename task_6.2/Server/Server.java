package Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    public static void main(String[] args) {
        ArrayList<Socket> clients = new ArrayList<>();
        Socket socket = null;
        try {
            ServerSocket serverSocket = new ServerSocket(8189);
            System.out.println("INFO: Сервер запущен");
            while (true){
                socket = serverSocket.accept(); // Ожидаем клиента
                DataInputStream in = new DataInputStream(socket.getInputStream()); // Поток ввода
                DataOutputStream out = new DataOutputStream(socket.getOutputStream()); // Поток вывода
                System.out.println("Клиент подключился");
                clients.add(socket); //Добавляем клиента в список
                Thread thread = new Thread(new Runnable() { // Открываем поток для клиента
                    @Override
                    public void run() {
                        try {
                            out.writeUTF("Привет, напиши свое имя!");
                            while (true){
                                // System.out.println("Ожидаем сообщение...");
                                String request = in.readUTF();
                                // System.out.println("Клиент прислал сообщение: "+request);
                                   System.out.println(request);

                                for (Socket socket: clients) { // Перебираем список клиентов
                                    DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                                 // out.writeUTF("Какой-то клиент отправил сообщение: "+request);
                                    out.writeUTF(request);

                                }
                            }
                        }catch (IOException exception) {
                            exception.printStackTrace();
                        }
                    }
                });
                thread.start();
            }
        }catch (IOException exception){
            exception.printStackTrace();
        }
    }
}
