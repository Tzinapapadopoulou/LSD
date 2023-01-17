package net.codejava.sql;

public class CallClient extends Thread {
    @Override
    public void run() {
        Chat_Client.main(null);
    }
}

