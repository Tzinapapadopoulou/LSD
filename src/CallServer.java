package net.codejava.sql;

public class CallServer extends Thread {
    @Override
    public void run() {
        Chat_Server.main(null);
    }
}