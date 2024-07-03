package model;

class Candy extends Product {
    private String flavor;

    public Candy(int id, double price, String productName, String flavor) {
        super(id, price, productName);
        this.flavor = flavor;
    }

    @Override
    public String examine() {
        return "A delicious " + productName + " with " + flavor + " flavor.";
    }

    @Override
    public String use() {
        return "You enjoyed the sweet taste of the " + productName + ".";
    }
}