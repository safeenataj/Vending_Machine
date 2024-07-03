package model;

import java.util.Arrays;

class VendingMachineImpl implements VendingMachine {
    private Product[] products;
    private int depositPool;

    public VendingMachineImpl(Product[] products) {
        this.products = products;
        this.depositPool = 0;
    }

    @Override
    public void addCurrency(int amount) {
        if (Arrays.asList(1, 2, 5, 10, 20, 50, 100, 200, 500, 1000).contains(amount)) {
            depositPool += amount;
        } else {
            System.out.println("Invalid amount. Please enter a valid amount.");
        }
    }

    @Override
    public int getBalance() {
        return depositPool;
    }

    @Override
    public Product request(int id) {
        Product requestedProduct = null;
        for (Product product : products) {
            if (product.getId() == id) {
                requestedProduct = product;
                break;
            }
        }

        if (requestedProduct != null && requestedProduct.getPrice() <= depositPool) {
            depositPool -= requestedProduct.getPrice();
            return requestedProduct;
        } else {
            System.out.println("Insufficient funds or product not found.");
            return null;
        }
    }

    @Override
    public int endSession() {
        int remainingBalance = depositPool;
        depositPool = 0;
        return remainingBalance;
    }

    @Override
    public String getDescription(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product.examine();
            }
        }
        return "Product not found.";
    }

    @Override
    public String[] getProducts() {
        String[] productInfo = new String[products.length];
        for (int i = 0; i < products.length; i++) {
            productInfo[i] = products[i].getId() + " - " + products[i].getProductName() + " - SEK " + products[i].getPrice();
        }
        return productInfo;
    }
}