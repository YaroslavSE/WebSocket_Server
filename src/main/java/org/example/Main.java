package org.example;



public class Main {
    public static void main(String[] args) {
        int port = 25565; // Указать нужный порт
        ChatServer server = new ChatServer(port);
        server.start();
        System.out.println("WebSocket Server started on port " + port);
    }
}