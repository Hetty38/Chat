package main.java.сhatсlient;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import entities.User;
import main.java.chatserver.IServer;
import main.java.entities.Message;
import main.java.entities.PrivateMessage;


import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ConcurrentMap;


public class Client extends UnicastRemoteObject implements IClient {

    public IServer server;
    User user;
    public boolean FlagConnect;


    private static final long serialVersionUID = 1L;

    public Client(IServer server) throws RemoteException {
        this.server = server;

    }

    @Override
    public void sendMessageAll(Message msg) throws RemoteException {
        if (FlagConnect == true) {
            Scanner s = new Scanner(System.in);
            System.out.println("Введите сообщение:) Если хотите перейти в главное меню, введите- menu ");
            while (true) {

                msg.setText(s.nextLine().trim());
                if (!msg.getText().equals("menu")) {
                    for (ConcurrentMap.Entry<String, IClient> entry : server.getClients().entrySet()) {

                        entry.getValue().printMessage(msg.getText() + " " + user.getName());
                    }
                } else {
                    break;
                }
            }
            System.out.println("Вы перешли в главное меню");
        } else {
            System.out.println("Чтобы отправить сообщение, сначала войдите в чат!");
        }
    }

    @Override
    public void printMessage(String message) throws RemoteException {
        System.out.println(message);
    }


    @Override
    public void disconnect() throws RemoteException {
        server.disconnect(user.getName());
        FlagConnect = false;
        System.out.println("Вы покинули чат");

    }


    @Override
    public void connect(IClient client) throws RemoteException {
        File f = new File("f.json");
        Gson gson = new GsonBuilder().create();
        if (!f.exists()) {
            try {
                user = new User();
                Scanner s = new Scanner(System.in);
                System.out.println("Введите имя");
                user.setName(s.nextLine().trim());
                while (server.getClients().containsKey(user.getName())) {
                    System.out.println("К сожалению, такой логин уже занят! Придумайте и введите другой");
                    System.out.println("Введите имя");
                    user.setName(s.nextLine().trim());

                }
                System.out.println("Расскажите о себе");
                user.setDescription(s.nextLine().trim());


                String a = gson.toJson(user);
                FileWriter writer = new FileWriter(f);
                writer.write(a);
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            server.reg(client, user.getName());
            FlagConnect = true;

            System.out.println("Вы присоединились к чату)");

        } else {
            try {
                FileReader fr = new FileReader("f.json");
                user = gson.fromJson(fr, User.class);
                server.reg(client, user.getName());
                FlagConnect = true;

                System.out.println("Вы присоединились к чату)");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void sendPrivateMessage(PrivateMessage msg) throws RemoteException {
        if (FlagConnect == true) {
            Scanner s = new Scanner(System.in);

            System.out.println("Введите имя пользователя, которому Вы хотите отправить сообщение:");
            System.out.println(getAllUsers());
            msg.setTo(s.nextLine().trim());

            System.out.println("Введите сообщение:)Если хотите выйти в главное меню, введите- menu");
            while (true) {
                msg.setText(s.nextLine().trim());
                if (!msg.getText().equals("menu")) {
                    IClient client = server.getClients().get(msg.getTo());
                    if (client != null)
                        client.printMessage(msg.getText() + " " + user.getName());
                    else {
                        System.out.println("Такого пользователя нет в чате");
                    }

                } else {
                    System.out.println("Вы перешли в главное меню");
                    break;
                }
            }
        } else {
            System.out.println("Чтобы отправить сообщение, сначала войдите в чат!");
        }
    }

    @Override
    public List<String> getAllUsers() throws RemoteException {
        List<String> list = new ArrayList<>();
        for (ConcurrentMap.Entry<String, IClient> entry : server.getClients().entrySet()) {
            list.add(entry.getKey());

        }
        return list;
    }

    @Override
    public void conAnotherLogin(IClient client) throws RemoteException {
        File f = new File("f.json");
        Gson gson = new GsonBuilder().create();
        if (f.exists()) {
            f.delete();
        }
        try {
            user = new User();
            Scanner s = new Scanner(System.in);
            System.out.println("Введите имя");
            user.setName(s.nextLine().trim());
            while (server.getClients().containsKey(user.getName())) {
                System.out.println("К сожалению, такой логин уже занят! Придумайте и введите другой");
                System.out.println("Введите имя");
                user.setName(s.nextLine().trim());

            }
            System.out.println("Расскажите о себе");
            user.setDescription(s.nextLine().trim());


            String a = gson.toJson(user);
            FileWriter writer = new FileWriter(f);
            writer.write(a);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        server.reg(client, user.getName());
        FlagConnect = true;

        System.out.println("Вы присоединились к чату)");
    }
}



