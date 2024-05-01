package bpos.networking.utils;

import bpos.networking.rpc.ClientRpcWorker;
import bpos.services.IServiceImpl;

import java.net.Socket;

public class RpcConcurrentServer extends AbsConcurrentServer {
    private IServiceImpl chatServer;
    public RpcConcurrentServer(int port, IServiceImpl chatServer) {
        super(port);
        this.chatServer = chatServer;
        System.out.println("RpcConcurrentServer");
    }

    @Override
    protected Thread createWorker(Socket client) {
        ClientRpcWorker worker=new ClientRpcWorker(chatServer, client);
        Thread tw=new Thread(worker);
        return tw;
    }
    @Override
    public void stop(){
        System.out.println("Stopping services ...");
    }
}