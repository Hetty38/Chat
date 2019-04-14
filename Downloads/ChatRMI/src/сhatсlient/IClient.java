package сhatсlient;

import chatserver.IServer;
import entities.Message;
import entities.PrivateMessage;
import entities.User;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;


public interface IClient extends Remote {
    void sendMessageAll(Message msg) throws RemoteException;

    void printMessage(String message) throws RemoteException;

    void disconnect() throws RemoteException;

    void connect(IClient client) throws RemoteException;

    void sendPrivateMessage(PrivateMessage msg) throws RemoteException;

    List<String> getAllUsers() throws RemoteException;

}




