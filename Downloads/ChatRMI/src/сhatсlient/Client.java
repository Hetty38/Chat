package сhatсlient;

import chatserver.IServer;


import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.UUID;


public class Client extends UnicastRemoteObject implements IClient{
    public String name;
    public String description;
    //public int id;
   public UUID id = UUID.randomUUID();

    private static final long serialVersionUID = 1L;

    public Client() throws RemoteException
    {}
//    public Client (String name) throws RemoteException {
//        this.name = name;
//    }
//    public Client (IServer server) throws RemoteException {
//        this.server = server;
//    }

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
    public UUID getId() throws RemoteException {
        return this.id;
    }

 /*   @Override
    public List<Message> getAllMessages() throws RemoteException {
        return null;
    }*/

//    @Override
//    public IClient getClient() throws RemoteException {
//        return client;
//    }
//    @Override
//    public String getName() throws RemoteException {
//        return this.name;
//    }
//
//    @Override
//    public void setClient(IClient c) throws RemoteException {
//        client=c;
//    }
}
