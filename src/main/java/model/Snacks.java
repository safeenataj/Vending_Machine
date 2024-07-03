package model;

public class Snacks extends Product {
    private String taste;

    public Drink(int id, double price, String productName, String taste) {
        super(id, price, productName);
        this.taste = taste;
    }

    @Override
    public String examine() {
        return " Salty Chips" + productName + " of " + taste + " taste.";
    }

    @Override
    public String use() {
        return " The crunch adds an element of excitement to the eating experience. " + productName + ".";
    }
}

