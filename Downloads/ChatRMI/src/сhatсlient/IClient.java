package сhatсlient;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.UUID;

public interface IClient extends Remote{
   void sendMessage(String message) throws RemoteException;
   void printMessage(String message) throws RemoteException;
   String getName() throws RemoteException;
    UUID getId() throws RemoteException;

    //  public List<Message> getAllMessages() throws RemoteException;

//    public void setClient(IClient c) throws RemoteException;

//    public IClient getClient() throws RemoteException;

  //  public String getName() throws RemoteException;

}




