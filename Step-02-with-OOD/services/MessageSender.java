package services;

public interface MessageSender {
   
    void send(String destination, String message);
}