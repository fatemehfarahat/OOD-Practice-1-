package services;

public class ReservationService {

    private final Payment payment;
    private final MessageSender messageSender;
    private final Discount discount;
    private final Invoice invoice;

    public ReservationService(Payment payment , MessageSender messageSender , Discount discount , Invoice invoice){
        this.payment = payment;
        this.messageSender = messageSender;
        this.discount = discount;
        this.invoice = invoice;
    }

    public void makeReservation(Reservation res, Payment payment,MessageSender messageSender){
        System.out.println("Processing reservation for " + res.customer.name);

        payment.pay(res);
        invoice.printInvoice(res);
    }
}