package model;

class Drink extends Product {
    private String type;

    public Drink(int id, double price, String productName, String type) {
        super(id, price, productName);
        this.type = type;
    }

    @Override
    public String examine() {
        return "A refreshing " + productName + " of " + type + " type.";
    }

    @Override
    public String use() {
        return "You quenched your thirst with the " + productName + ".";
    }
}