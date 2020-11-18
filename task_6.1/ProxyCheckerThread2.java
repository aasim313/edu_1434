import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class ProxyChecker {
    public static void main(String[] args) {
        ArrayList<String> ipList = new ArrayList<>();
        try {
            FileReader reader = new FileReader("C://java/ip.txt");
            int c;
            String proxy = "";
            while ((c=reader.read()) != -1){
                if (c == 13){
                    continue;
                }else if (c == 10){
                    ipList.add(proxy);
                    proxy="";
                }else if( c != 9) // 9 - это табуляция
                    proxy = proxy + (char) c;
                else
                    proxy += ":";
            }
            for (String ipString: ipList) {
                String ip = ipString.split(":")[0];
                int port = Integer.parseInt(ipString.split(":")[1]);
             
                Thread t1 = new Thread(new MyRunnable(ip,port));
                t1.start();


            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class MyRunnable implements Runnable{
        String ip;
        int port;
   public MyRunnable (String ip,int port) {
        this.ip=ip;
        this.port=port;
        }
    @Override
    public void run(){
        System.out.println("Проверяю "+ip+":"+port);
        try {
        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(ip,port));
        URLConnection connection = new URL("https://vozhzhaev.ru/test.php").openConnection(proxy);
        InputStream is = connection.getInputStream();
        InputStreamReader reader = new InputStreamReader(is);
        char[] buffer = new char[256];
        int c;


        StringBuilder stringBuilder = new StringBuilder();

        while ((c = reader.read(buffer)) != -1){
        stringBuilder.append(buffer,0,c);
        }
        reader.close();
        System.out.println(stringBuilder+"РАБОТАЕТ!!!!!!!!!!");

        } catch (IOException e) {
          System.out.println("ip: "+ip+" не работает");
        }
   }
}
