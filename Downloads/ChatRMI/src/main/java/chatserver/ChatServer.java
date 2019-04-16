package main.java.chatserver;



import main.java.сhatсlient.IClient;

import java.rmi.AlreadyBoundException;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.concurrent.ConcurrentHashMap;


public class ChatServer {
    public static void main(String[] argv) throws RemoteException {

        IServer server = new Server(new ConcurrentHashMap<String, IClient>());
        try {
           // System.setProperty("java.rmi.server.hostname","192.168.1.73");
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.bind("Server", server);
        } catch (AlreadyBoundException e) {
            System.err.println("couldn't bind Server' cause " + e.getMessage());
        }
    }
}






