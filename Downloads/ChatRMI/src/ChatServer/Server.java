package ChatServer;

import ChatClient.Client;
import ChatClient.IClient;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import java.util.LinkedList;
import java.util.List;

public class Server extends UnicastRemoteObject implements IServer{
   public List<IClient> clients;
    public Server(List<IClient> clients) throws RemoteException
    {
        this.clients = clients;//Временно пока не разберусь с коллекциями
    }

    @Override

    public void sendMessage(String message) throws RemoteException {
        for (IClient c:clients
             ) {
            c.printMessage(message);

        }

    }



    @Override
    public void reg(IClient server) throws RemoteException {
       clients.add(server);
    }

    @Override
    public void disconnect(IClient server) throws RemoteException {
        clients.remove(server);
    }


}
