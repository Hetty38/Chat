package ChatClient;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IClient extends Remote{
    public void sendMessage(String message) throws RemoteException;
    public void printMessage(String message) throws RemoteException;
    //  public List<Message> getAllMessages() throws RemoteException;

//    public void setClient(IClient c) throws RemoteException;

//    public IClient getClient() throws RemoteException;

  //  public String getName() throws RemoteException;

}




