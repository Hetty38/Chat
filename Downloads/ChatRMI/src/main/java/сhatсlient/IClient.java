package main.java.сhatсlient;

import main.java.entities.Message;
import main.java.entities.PrivateMessage;

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

    void conAnotherLogin(IClient client) throws RemoteException;

}




