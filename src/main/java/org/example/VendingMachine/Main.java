package org.example.VendingMachine;

public class Main {
    public static void main(String[] args) {
        // Populate Inventory
        VendingMachine machine = new VendingMachine();
        Product cola = new Product(1, "Coca-Cola", 40.0);
        Product chips = new Product(2, "Lays Chips", 20.0);


        machine.getInventory().addAisle(new Aisle(1, cola, 2));
        machine.getInventory().addAisle(new Aisle(2, chips, 1));

        System.out.println("=== SCENARIO 1: insufficient money, should return amount ===");
        machine.selectProduct(1);
        machine.insertMoney(40.0);
        machine.dispense();

        //machine.insertMoney(30.0); // Total inserted ₹50 for a ₹40 product

//        System.out.println("\n=== SCENARIO 2: Transaction Cancel & Refund ===");
//        machine.selectProduct(1);
//        machine.insertMoney(10.0);
//        machine.cancel();
//
//        System.out.println("\n=== SCENARIO 3: Out of Stock Purchase ===");
//        machine.selectProduct(2);
//        machine.insertMoney(20.0); // Uses remaining stock
//
//        System.out.println("\nAttempting to buy A2 again when empty:");
//        machine.selectProduct(2);
    }
}
