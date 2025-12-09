package services;
class SmsSender implements MessageSender { 
    public void sendSms(String mobile, String message){
        System.out.println("Sending SMS to " + mobile + ": " + message);
    }
}