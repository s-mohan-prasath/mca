package packages.kaboomFireworks.productionPkg;
import ;

public class Production implements GeneratedRevenue {
    private int productID;
    private int quantityProduced;
    private double costPerUnit;
    private static int currentStock = 0;
    private static final int STOCK_LIMIT = 1000; // Example limit
    private static final int BUFFER_STOCK = 100; // Example buffer

    public Production(int productID, int quantityProduced, double costPerUnit) {
        if (currentStock + quantityProduced > STOCK_LIMIT || quantityProduced < 0) {
            throw new IllegalArgumentException("Invalid production quantity. Would exceed stock limit or is negative.");
        }
        this.productID = productID;
        this.quantityProduced = quantityProduced;
        this.costPerUnit = costPerUnit;
        currentStock += quantityProduced;
    }

    public int getProductID() {
        return productID;
    }

    public int getQuantityProduced() {
        return quantityProduced;
    }

    public double getCostPerUnit() {
        return costPerUnit;
    }

    public double calculateProductionCost() {
        return quantityProduced * costPerUnit;
    }

    @Override
    public void report() {
        System.out.println("--- Production Report (Product ID: " + productID + ") ---");
        System.out.println("Quantity Produced: " + quantityProduced);
        System.out.println("Cost Per Unit: $" + String.format("%.2f", costPerUnit));
        System.out.println("Total Production Cost: $" + String.format("%.2f", calculateProductionCost()));
    }

    @Override
    public int stockLevel() {
        return currentStock;
    }

    public void increaseStock(int quantity) {
        if (currentStock + quantity > STOCK_LIMIT || quantity < 0) {
            throw new IllegalArgumentException("Cannot increase stock. Would exceed limit or quantity is negative.");
        }
        currentStock += quantity;
        this.quantityProduced += quantity; // Update produced quantity as well
    }

    public void decreaseStock(int quantity) {
        if (currentStock - quantity < BUFFER_STOCK || quantity < 0) {
            throw new IllegalArgumentException("Cannot decrease stock below buffer or quantity is negative.");
        }
        currentStock -= quantity;
    }

    public static int getCurrentStock() {
        return currentStock;
    }

    public static int getStockLimit() {
        return STOCK_LIMIT;
    }

    public static int getBufferStock() {
        return BUFFER_STOCK;
    }
}