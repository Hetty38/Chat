package entities;

import chatserver.IServer;


public class Message {
    private String text;
    private IServer server;
    public Message(IServer server) {
        this.server = server;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public IServer getServer() {
        return server;
    }

    public void setServer(IServer server) {
        this.server = server;
    }






}


