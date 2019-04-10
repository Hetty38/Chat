package сhatсlient;

import chatserver.IServer;

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface IClient extends Remote {
    void sendMessage(String message) throws RemoteException;

    void printMessage(String message) throws RemoteException;

    String getName() throws RemoteException;

    void disconnect(String name) throws RemoteException;

    void connect(IClient client, String name) throws RemoteException;


    //  public List<Message> getAllMessages() throws RemoteException;

//    public void setClient(IClient c) throws RemoteException;

//    public IClient getClient() throws RemoteException;

    //  public String getName() throws RemoteException;

}




