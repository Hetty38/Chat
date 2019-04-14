package entities;

import chatserver.IServer;

public class PrivateMessage extends Message {
    private String to;

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public PrivateMessage(IServer server) {
        super(server);
    }

}


