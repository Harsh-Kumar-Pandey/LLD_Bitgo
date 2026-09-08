package org.example.ParkingLot;

public class FlatPricing implements PricingStrategy {
    @Override
    public double calculatePrice(Ticket ticket) {
        // Implement flat pricing logic
        return 100.0;
    }
}
