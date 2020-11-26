package server;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class server {
    static ArrayList<Client> clientList = new ArrayList<>();
    static String senderNickName;

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

                                for (Client client:clientList) {   // определяем имя отправителя
                                    if (client.getHashCode() == in.hashCode()) senderNickName = client.getNickName();
                                }

                                String msg = senderNickName + ": " + request;
                                System.out.println(msg);

// New
                                for (Client client:clientList) {
                                    //int hashCode = client.getHashCode();
                                    DataOutputStream out = new DataOutputStream(client.getSocket().getOutputStream());

                                    if (client.getHashCode() == in.hashCode())  {         // это - отправитель
                                        if (senderNickName.equals("New client")){          // имя не задано
                                            client.setNickName(request);
                                            out.writeUTF("Привет, " + client.getNickName());
                                        } //else { out.writeUTF( "Ваше сообщение: " + request );}   // не дублируем сообщение в терминале отправителя
                                    } else {                                                    // этот клиент - не отправитель
                                        out.writeUTF(msg);
                                    }



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
        private String nickName = "New client";

        public Client(Socket socket, int hashCode) {
            this.socket = socket;
            this.hashCode = hashCode;
        }


        public Socket getSocket() {
            return socket;
        }

        public void setSocket(Socket socket) {this.socket = socket;}

        public int getHashCode() {return hashCode;}

        public void setHashCode(int hashCode) {this.hashCode = hashCode;}
        public String getNickName () {return this.nickName;}
        public void  setNickName (String nickName) {this.nickName = nickName;}

    }
}