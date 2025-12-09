package services;

public class Cash implements Payment{
    public void pay(Reservation res){
        System.out.println("Paid by cash: " + res.totalPrice());
    }
}
