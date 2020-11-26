package client;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Controller {
    Socket socket;
    DataOutputStream out;

    @FXML
    TextArea messageWindow;
    @FXML
    TextField textField;
    @FXML
    private void send(){  // метод отправки сообщения
      try {
            String str = textField.getText();   // получаем сообщение от сервера
            messageWindow.appendText(str + "\n" );
            out.writeUTF(str);                  // отправка сообщения серверу
            textField.clear();                  // очистка поля ввода
            textField.requestFocus();           // возврат фокуса на поле написания сообщения

        } catch (IOException exception) {
            exception.printStackTrace();
        }
  }
    @FXML
    private void connect(){   // метод подключения к серверу (вызывается кнопкой)
        String name = "new";
        try {
            Socket socket = new Socket("localhost",8189);            // открывается сокет для подключения
            DataInputStream in = new DataInputStream(socket.getInputStream());  // создается поток данных ввода
             out = new DataOutputStream(socket.getOutputStream());               // создается поток данных  вывода

            Thread thread = new Thread(new Runnable() {    // создается поток процесса
                @Override
                public void run() {
                    try {
                        while (true){
                            String response = in.readUTF(); // ожидается сообщен ео сервера
                            messageWindow.appendText(response + "\n"); // вывод сообщения
                        }
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                }
            });
            thread.start();  //запускаем поток процесса
       }catch (IOException exception){
            exception.printStackTrace();
        }

    }
}
