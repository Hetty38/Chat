package сhatсlient;


import chatserver.IServer;
import chatserver.Server;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import java.util.Scanner;

public class ChatClient {
    public static void main(String[] argv) throws RemoteException, NotBoundException {

        Registry registry = LocateRegistry.getRegistry("127.0.0.1");
        IServer stub = (IServer) registry.lookup("Server");
        User user = new User();
        System.out.println("Введите имя");
        Scanner s = new Scanner(System.in);
        user.name = s.nextLine().trim();
        System.out.println("Расскажите о себе");
        user.description = s.nextLine().trim();
        Client c = new Client(stub, user.name);
        Message msg = new Message(stub);
        PrivateMessage pmsg = new PrivateMessage(stub);
        System.out.println("Введите: exit-если хотите выйти из приложения, connect- если хотите присоединиться к чату");
        while (true) {
            String command = s.nextLine();
            switch (command) {
                case "exit":
                    c.disconnect(user.name);
                    System.exit(0);
                    break;
                case "connect":
                    c.connect(c, user.name);
                    System.out.println("Введите: exit-если хотите выйти из приложения,disconnect - если хотите покинуть чат, " +
                            "sendAll- если хотите отправить сообщение в общий чат, sendPrivate- если хотите отправить сообщение конкреному пользователю");
                    String com = s.nextLine();
                    switch (com) {
                        case "disconnect":
                            c.disconnect(user.name);
                            break;
                        case "sendAll":
                            msg.send(user.name);
                            break;
                        case "sendPrivate":
                            pmsg.send(user.name);
                            break;
                        case "exit":
                            c.disconnect(user.name);
                            System.exit(0);
                            break;
                        default:
                            System.out.println("Вы ввели некорректную команду. Попробуйте заново");
                    }
                    break;

                default:
                    System.out.println("Вы ввели некорректную команду. Попробуйте заново");

            }


        }
    }

//        System.out.println("Расскажите о себе");
//        c.description = s.nextLine().trim();
//        System.out.println("Выберите команду: 1.Отсоединиться от чата 2. Отправить сообщение");
//        int answer = s.nextInt();
//        s.nextLine();
//        if (answer == 1) {
//            stub.disconnect(c.name);
//        } else if (answer == 2) {
//            System.out.println("Введите цифру: 1. Отправить сообщение всем 2. Отправить личное сообщение конкретному пользователю, 3.Отсоединиться от чата");
//            int answ = s.nextInt();
//            s.nextLine();
//            if (answ == 1) {
//                while (true) {
//                    System.out.println("Введите сообщение:)");//придумать что сделать чтобы можно было покинуть чат
//                    msg = s.nextLine();
//                    stub.sendMessage(msg, c.name);
//                }
//
//            } else {
//                System.out.println("Введите имя пользователя, которому Вы хотите отправить сообщение");
//                String n = s.nextLine().trim();
//                System.out.println("Введите сообщение:)");
//                msg = s.nextLine().trim();
//                stub.sendPrivateMessage(msg, n);
//
//            }
//
//
//        }

}






