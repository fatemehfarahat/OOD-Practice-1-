package services;

import models.Reservation; 

public class ParisDiscount implements Discount{
    @Override
    public double getDiscountFactor(Reservation res) {
        if (res.getCustomerCity().equals("Paris")) {
            System.out.println("Apply city discount for Paris!");
            return 0.9; 
        }
        return 1.0; 
    }
}