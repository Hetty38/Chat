package сhatсlient;

import chatserver.IServer;

import java.rmi.RemoteException;
import java.util.Scanner;

public class PrivateMessage {
    public String text;
    public IServer server;

    public PrivateMessage(IServer server) {
        this.server = server;
    }

    Scanner s = new Scanner(System.in);


    public void send(String n) throws RemoteException {
        String name;
        System.out.println("Введите имя пользователя, которому Вы хотите отправить сообщение. ");

        name = s.nextLine().trim();
        System.out.println("Введите сообщение:)Если хотите выйти в главное меню, введите- menu");
        while (true) {

            text = s.nextLine().trim();
            if (!text.equals("menu")) {
                IClient client = server.getClients().get(name);
                if (client != null) {
                    client.printMessage(text + " " + n);
                }
            } else
                System.out.println("Вы перешли в главное меню");
            break;
        }
    }
}

