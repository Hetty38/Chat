package ChatClient;

import ChatServer.IServer;


import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;



public class Client extends UnicastRemoteObject implements IClient{
    public String name;
    public IClient client = null;
    private static final long serialVersionUID = 1L;
    private IServer server;
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
