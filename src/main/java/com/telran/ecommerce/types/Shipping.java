package com.telran.ecommerce.types;
public enum Shipping {
    FREE_SHIPPING("Free shipping"), EXPRESS_SHIPPING("Express shipping"), PICK_UP("Pick up"), PRIORITY("Priority");
    final String shipping;

    Shipping(String shipping) {
        this.shipping = shipping;
    }
}