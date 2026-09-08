package org.example.VendingMachine;

public class Aisle {
    int code;
    Product product;
    int quantity;

    Aisle(int code, Product product,int quantity){
        this.code=code;
        this.product=product;
        this.quantity=quantity;
    }
}
