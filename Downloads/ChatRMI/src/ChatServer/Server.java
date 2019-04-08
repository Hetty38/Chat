package chatserver;

import сhatсlient.Client;
import сhatсlient.IClient;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import java.util.List;

public class Server extends UnicastRemoteObject implements IServer{
   public List<IClient> clients;
    public Server(List<IClient> clients) throws RemoteException
    {
        this.clients = clients;//Временно пока не разберусь с коллекциями
    }

    @Override

    public void sendMessage(String message, String name) throws RemoteException {
        for (IClient c:clients
             ) {
            c.printMessage(message+ "  "+ name);

        }

    }

    @Override
    public void getAddress(String name) throws RemoteException { //тестовый вариант. потом он будет возрвращать id и коллекция будет concurrenrMap
        for (IClient c:clients) {

            if (c.getName()==name)
            {
                System.out.println(c.getId());
            }
            else System.out.println("Не работает");

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
