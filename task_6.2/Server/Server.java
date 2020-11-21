package Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    static ArrayList<Client> clientList = new ArrayList<>();

    public static void main(String[] args) {
        Socket socket = null;
        try {
            ServerSocket serverSocket = new ServerSocket(8189);
            System.out.println("INFO: Сервер запущен");
            while (true){
                socket = serverSocket.accept(); // Ожидаем клиента
                DataInputStream in = new DataInputStream(socket.getInputStream()); // Поток ввода
                DataOutputStream out = new DataOutputStream(socket.getOutputStream()); // Поток вывода
                System.out.println("Клиент подключился");

                clientList.add(new Client(socket,in.hashCode()));  //Добавляем клиента в список


                Thread thread = new Thread(new Runnable() { // Открываем поток для клиента
                    @Override
                    public void run() {
                        try {
                            out.writeUTF("Привет, напиши свое имя!");
                            while (true){
                                String request = in.readUTF();
                                System.out.println(request);

// New
                                for (Client client:clientList) {
                                    //int hashCode = client.getHashCode();
                                    DataOutputStream out = new DataOutputStream(client.getSocket().getOutputStream());
                                    if (client.getHashCode()!=in.hashCode()) out.writeUTF(request);
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

// новый класс - клиенты
public static class Client {
        private  Socket socket;
        private  int hashCode;

    public Client(Socket socket, int hashCode) {
        this.socket = socket;
        this.hashCode = hashCode;
    }


    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public int getHashCode() {
        return hashCode;
    }

    public void setHashCode(int hashCode) {
        this.hashCode = hashCode;
    }
}


}

