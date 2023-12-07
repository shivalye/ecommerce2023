package com.telran.ecommerce.types;
public enum Shipping {
    FREE_SHIPPING("free shipping"), EXPRESS_SHIPPING("express shipping"), PICK_UP("pick up");
    final String shipping;

    Shipping(String shipping) {
        this.shipping = shipping;
    }
}