package bpos.networking.utils;

// lasam comentat pana avem networking si services ///
/*

import java.net.Socket;

public class RpcConcurrentServer extends AbsConcurrentServer {
    private IServices server;

    public RpcConcurrentServer(int port, IServices s) {
        super(port);
        this.server = s;
        System.out.println("RpcConcurrentServer");
    }

    protected Thread createWorker(Socket client) {
        ClientRpcWorker worker = new ClientRpcWorker(this.server, client);
        Thread t = new Thread(worker);
        return t;
    }

    public void stop() {
        System.out.println("Stopping services ...");
    }
}
*/