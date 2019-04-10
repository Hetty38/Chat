package chatserver;

import сhatсlient.Client;
import сhatсlient.IClient;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;

public class Server extends UnicastRemoteObject implements IServer {
    public ConcurrentMap<String, IClient> clients;


    public ConcurrentMap<String, IClient> getClients() throws RemoteException {
        return clients;
    }

    @Override
    public void sendPrivateMessage(String message, String nameClient) throws RemoteException {
        IClient client = clients.get(nameClient);
        if (client != null) {
            client.printMessage(message);
        }
    }

    public Server(ConcurrentMap<String, IClient> clients) throws RemoteException {
        this.clients = clients;

    }


    @Override

    public void sendMessage(String message, String name) throws RemoteException {
        for (ConcurrentMap.Entry<String, IClient> entry : clients.entrySet()) {

            entry.getValue().printMessage(message + " " + name);
        }

    }

    @Override
    public void reg(IClient server, String name) throws RemoteException {
        clients.put(name, server);

    }

    @Override
    public void disconnect(String name) throws RemoteException {
        clients.remove(name);
    }


}

