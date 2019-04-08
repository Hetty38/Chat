package chatserver;



import java.rmi.AlreadyBoundException;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;


public class ChatServer {
    public static void main(String[] argv) throws RemoteException {
        IServer server = new Server(new ArrayList<>());
        try {
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.bind("Server", server);
        } catch (AlreadyBoundException e) {
            System.err.println("couldn't bind Server' cause " + e.getMessage());
        }
    }
}






