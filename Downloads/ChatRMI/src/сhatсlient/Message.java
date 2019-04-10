package сhatсlient;

import chatserver.IServer;

import java.rmi.RemoteException;
import java.util.Scanner;
import java.util.concurrent.ConcurrentMap;

public class Message {
    public String text;
    public IServer server;

    public Message(IServer server) {
        this.server = server;
    }

    Scanner s = new Scanner(System.in);


    public void send(String name) throws RemoteException {
        System.out.println("Введите сообщение:) Если хотите перейти в главное меню, введите- menu ");
        while (true) {

            text = s.nextLine().trim();
            if (!text.equals("menu")) {
                for (ConcurrentMap.Entry<String, IClient> entry : server.getClients().entrySet()) {

                    entry.getValue().printMessage(text + " " + name);
                }
            } else {
                break;
            }
        }
        System.out.println("Вы перешли в главное меню");
    }

}
