package main.java.сhatсlient;

import main.java.chatserver.IServer;
import main.java.entities.Message;
import main.java.entities.PrivateMessage;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import java.util.Scanner;

public class ChatClient {
    public static void main(String[] argv) throws RemoteException, NotBoundException {

        Registry registry = LocateRegistry.getRegistry("127.0.0.1");
        IServer stub = (IServer) registry.lookup("Server");
        Client c = new Client(stub);
        Scanner s = new Scanner(System.in);
        Message msg = new Message(stub);
        PrivateMessage pmsg = new PrivateMessage(stub);

        System.out.println("Добро пожаловать! \n Введите:\n exit-если хотите выйти из приложения,\n connect- если хотите присоединиться к чату, \n disconnect - если хотите покинуть чат, \n " +
                "sendAll- если хотите отправить сообщение в общий чат, \n sendPrivate- если хотите отправить сообщение конкреному пользователю, \n connectAnotherLogin - если хотите войти под другим пользователем");

        while (true) {
            String command = s.nextLine();
            switch (command) {
                case "connect":
                    c.connect(c);
                    break;
                case "disconnect":
                    c.disconnect();
                    break;
                case "sendAll":
                    c.sendMessageAll(msg);
                    break;
                case "sendPrivate":
                    c.sendPrivateMessage(pmsg);
                    break;
                case "connectAnotherLogin":
                    c.conAnotherLogin(c);

                    break;
                case "exit":
                    c.disconnect();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Вы ввели некорректную команду. Попробуйте заново");
                    break;

            }


        }
    }


}






