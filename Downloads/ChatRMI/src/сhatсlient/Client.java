package сhatсlient;

import chatserver.IServer;


import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;
import java.util.UUID;


public class Client extends UnicastRemoteObject implements IClient {
    public String name;
    public String description;
    public IServer server;


    private static final long serialVersionUID = 1L;

    public Client(IServer server, String name) throws RemoteException {
        this.name = name;
        this.server = server;
    }

    @Override
    public void sendMessage(String message) throws RemoteException {
        System.out.println(message);
    }

    @Override
    public void printMessage(String message) throws RemoteException {
        System.out.println(message);
    }

    @Override
    public String getName() throws RemoteException {
        return this.name;
    }

    @Override
    public void disconnect(String name) throws RemoteException {
        server.getClients().remove(name);
        System.out.println("Вы покинули чат");

    }


    @Override
    public void connect(IClient client, String name) throws RemoteException {

        Scanner s = new Scanner(System.in);

        while (server.getClients().containsKey(name)) {
            System.out.println("К сожалению, такой логин уже занят! Придумайте и введите другой");
            System.out.println("Введите имя");
            name = s.nextLine();
            continue;
        }
        server.reg(client, name);
        System.out.println("Вы присоединились к чату)");

    }


}
