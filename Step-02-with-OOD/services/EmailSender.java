package services;

public class EmailSender implements MessageSender {
    @Override
    public void send(String destination, String message){
        System.out.println("Sending email to " + destination + ": " + message);
    }
}