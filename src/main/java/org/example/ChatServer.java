package org.example;

import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

import java.net.InetSocketAddress;
import java.util.HashSet;
import java.util.Set;

class ChatServer extends WebSocketServer {


    Set<WebSocket> clients;
    public ChatServer(int port){
        super(new InetSocketAddress(port));
        clients = new HashSet<>();
    }

    @Override
    public void onOpen(WebSocket connectUser, ClientHandshake clientHandshake) {
        clients.add(connectUser);
        System.out.println("User connection:"+ connectUser.getRemoteSocketAddress());
    }

    @Override
    public void onClose(WebSocket disconnectUser, int i, String s, boolean b) {
        clients.remove(disconnectUser);
        System.out.println("User connection:"+ disconnectUser.getRemoteSocketAddress());
    }

    @Override
    public void onMessage(WebSocket webSocket, String s) {
        broadcast(s,clients);
    }

    @Override
    public void onError(WebSocket webSocket, Exception e) {

    }

    @Override
    public void onStart() {
        System.out.println("WebSocket Server started successfully.");
    }
}
