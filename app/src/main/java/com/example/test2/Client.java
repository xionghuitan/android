package com.example.test2;

import java.io.IOException;
import java.net.Socket;

public class Client {
//    Socket clientSocket;
//    Send send;
//    Receive receive;
//    public Client() throws IOException {
//        clientSocket = new Socket("192.168.10.102", 9999);
//        send = new Send(clientSocket);
//        receive = new Receive(clientSocket);
//    }
//
//    public void runClient() {
//        new Thread(this.send).start();
//        new Thread(this.receive).start();
//
//    }

    public static void main(String[] args) throws IOException {
        // Socket clientSocket = new Socket("192.168.10.102", 9999);
        Socket client = new Socket("192.168.10.102", 9999);
        Send send = new Send(client);
        Receive receive = new Receive(client);
        new Thread(send).start();
        new Thread(receive).start();
    }
}
