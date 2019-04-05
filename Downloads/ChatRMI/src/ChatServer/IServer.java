package ChatServer;

import ChatClient.IClient;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IServer extends Remote{
    void sendMessage(String message) throws RemoteException;
    //  public List<Message> getAllMessages() throws RemoteException;



  //  String getName() throws RemoteException;
   void reg (IClient server) throws RemoteException;
   void disconnect(IClient server) throws RemoteException;

}




