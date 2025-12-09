package services;

public class Card implements Payment{
    public void pay(Reservation res){
        System.out.println("Paid by card: " + res.totalPrice()); 
    }
}
