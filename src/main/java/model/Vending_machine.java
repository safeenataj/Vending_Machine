package model;

public class Vending_machine {
    public static void main(String[] args) {
        Product[] products = {
                new Candy(1, 5.00, "Chocolate Bar", "Dark Chocolate"),
                new Drink(2, 11.50, "Soda", "Cola"),


                new Candy(4, 2.00, "Gummy Bears", "Fruity"),
                new Drink(5, 12.00, "Juice", "Orange"),

        };

        VendingMachine vendingMachine = new VendingMachineImpl(products);

        System.out.println("Welcome to the Vending Machine!");
        System.out.println("Available Products:");
        for (String productInfo : vendingMachine.getProducts()) {
            System.out.println(productInfo);
        }

        // Add currency to the vending machine
        vendingMachine.addCurrency(100);
        System.out.println("Current balance: SEK " + vendingMachine.getBalance());

        // Request a product
        Product selectedProduct = vendingMachine.request(4);
        if (selectedProduct != null) {
            System.out.println("You selected: " + selectedProduct.examine());
            System.out.println("Remaining balance: SEK " + vendingMachine.getBalance());
            System.out.println(selectedProduct.use());
        }

        // End session and get the remaining balance
        int remainingBalance = vendingMachine.endSession();
        System.out.println("Session ended. Your remaining balance is: SEK " + remainingBalance);
    }
}



