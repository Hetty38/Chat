package ChatClient;


import ChatServer.IServer;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import java.util.Scanner;

public class ChatClient {
    public static void main (String[] argv) throws RemoteException, NotBoundException {

            Registry registry = LocateRegistry.getRegistry("127.0.0.1");
            IServer stub= (IServer) registry.lookup("Server");
            Scanner s=new Scanner(System.in);
           String msg=s.nextLine().trim();
           stub.reg(new Client());
           stub.sendMessage(msg);

//
//                new Client(stub).sendMessage(msg);


//            Scanner s=new Scanner(System.in);
//            System.out.println("Enter Your name and press Enter:");
//            String name=s.nextLine().trim();


          /*
            new Client(stub).run

            ClientRegister server = (ClientRegister)registry.lookup("ClientRegister");

            String msg="["+client.getName()+"] got connected";
            server.sendMessage(msg);


            while(true){
                msg=s.nextLine().trim();
                msg="["+client.getName()+"] "+msg;
                server.sendMessage(msg);
            }*/


    }
}