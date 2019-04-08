package сhatсlient;


import chatserver.IServer;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import java.util.Scanner;

public class ChatClient {
    public static void main (String[] argv) throws RemoteException, NotBoundException {

            Registry registry = LocateRegistry.getRegistry("127.0.0.1");
            IServer stub= (IServer) registry.lookup("Server");
            Client c = new Client();
        String msg;
        Scanner s=new Scanner(System.in);
        System.out.println("Введите имя");
       c.name = s.nextLine().trim();
        System.out.println("Расскажите о себе");
       c.description=s.nextLine().trim();
        stub.reg(c);
        System.out.println("Вы присоединились к чату)");
        stub.getAddress(c.name);//так же тестовый вызов. Предполагалось что этот метод будет работать при отправке личных сообщений
        System.out.println("Выберите команду: 1.Отсоединиться от чата 2. Отправить сообщение");
        int answer = s.nextInt();
        s.nextLine();
        if (answer==1)
        {
            stub.disconnect(c);
        }

       else if (answer==2) {
          System.out.println("Введите цифру: 1. Отправить сообщение всем 2. Отправить личное сообщение конкретному пользователю");
          if (s.nextInt() == 1) {
              s.nextLine();
              System.out.println("Введите сообщение:)");
              msg = s.nextLine();
              stub.sendMessage(msg, c.name);
          }
         //   }
        }
//        }
    //    String msg= s.nextLine();
   //  stub.sendMessage(msg, c.name);
     //System.out.println("Введите имя");
//        c.name = s.nextLine().trim();
//        System.out.println("Расскажите о себе");
//        c.description=s.nextLine().trim();
//        System.out.println("Выберите команду: 1. Присоединиться к чату 2.Отсоединиться от чата 3. Отправить сообщение");
//        int answer = s.nextInt();
//        if (answer==1)
//        {
//            stub.reg(c);
//            System.out.println("Вы успешно присоединились к чату!:) Приятного общения!");
//        }
////        if (s.nextInt()==2) {
////        }
//
//        else if (answer==3)
//        {
//            System.out.println("Введите цифру: 1. Отправить сообщение всем 2. Отправить личное сообщение конкретному пользователю");
//           if (s.nextInt()==1)
//     {
//         System.out.println("Введите сообщение:)");
//         String msg= s.nextLine();
//         stub.sendMessage(msg, c.name);
//           }
//        }
        }

        }




