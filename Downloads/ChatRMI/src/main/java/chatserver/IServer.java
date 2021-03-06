package main.java.chatserver;



import main.java.сhatсlient.IClient;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.concurrent.ConcurrentMap;

public interface IServer extends Remote {
    void sendMessage(String message, String name) throws RemoteException;

    void reg(IClient server, String name) throws RemoteException;

    void disconnect(String name) throws RemoteException;

    ConcurrentMap<String, IClient> getClients() throws RemoteException;

    void sendPrivateMessage(String message, String nameClient) throws RemoteException;
}




