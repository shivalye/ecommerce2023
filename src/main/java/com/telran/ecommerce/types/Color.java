package com.telran.ecommerce.types;

public enum Color {
    RED("red"), GREEN("green"), BLACK("black"), WHITE("white"), BROWN("brown"), YELLOW("yellow"), BLUE("blue"), ORANGE("orange");

    final String color;

    Color(String color) {
        this.color = color;
    }
}
