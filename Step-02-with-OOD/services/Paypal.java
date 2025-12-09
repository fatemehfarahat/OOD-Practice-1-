package services;

public class Paypal implements Payment{
    public void pay(Reservation res){
        System.out.println("Paid by PayPal: " + res.totalPrice());
    }
}
