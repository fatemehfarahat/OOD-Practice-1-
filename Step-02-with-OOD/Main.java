import constants.PaymentMethods;
import models.Customer;
import models.LuxuryRoom;
import constants.Notifier;
import services.Reservation;
import models.Room;
import services.ReservationService;

public class Main {
    public static void main(String[] args){
        Customer customer = new Customer("Ali", "ali@example.com","09124483765", "Paris");
        Room room = new LuxuryRoom("203", 150);
        Reservation res = new Reservation(room, customer, 2);
        Payment paymentService = new Paypal(); 
        MessageSender messageService = new EmailSender(); 
        Discount discount = new ParisDiscount(); 
        Invoice invoiceService = new Invoice(); 
        ReservationService service = new ReservationService(
            paymentService, 
            messageService, 
            discount, 
            invoiceService
        );
        service.makeReservation(res);
    }
}