

public class Store {
    private String storeName;
    private Product[] products;
    private int[] soldCount;
    private int productCount;

    public Store(String storeName, int capacity) {
        if (storeName != null && !storeName.isBlank()) {
            this.storeName = storeName.strip();
        } else {
            this.storeName = "Unnamed store";
        }
        this.products = new Product[capacity];
        this.soldCount = new int[capacity];
        this.productCount = 0;
        for (int i = 0; i < soldCount.length; i++) {
            soldCount[i] = 0;
        }
    }

    public boolean addProduct(Product product) {
        if (productCount >= products.length || product == null) {
            return false;
        }
        for (int i = 0; i < productCount; i++) {
            if (product.getId() == products[i].getId()) {
                return false;
            }
        }
        products[productCount] = product;
        soldCount[productCount] = 0;
        productCount++;
        return true;
    }

    public int findProductIndex(int id) {
        int i = 0;
        int found = -1;

        while (i < productCount && products[i] != null) {
            if (products[i].getId() == id) {
                found = i;
                break;
            } else {
                i++;
            }
        }
        return found;
    }

    public boolean sellProduct(int id, int quantity){
        int productIndex = findProductIndex(id);
        if(productIndex < 0  ||  productIndex >= productCount){
            return false;
        }
        if(products[productIndex].sell(quantity)){
            soldCount[productIndex] += quantity;
            return true;
        }
        return false;
    }

    public void printAvailableProducts(){
        for (int i = 0; i < productCount; i++){
            if(products[i].getStock() == 0){
                continue;
            }
            System.out.println(products[i].getInfo());
        }
    }

    public void printSalesReport(){
        System.out.println("Store name: " + storeName);
        for (int i = 0; i< productCount; i++){
            System.out.println("\nProduct name: " + products[i].getName() + "\nSold quantity: " + soldCount[i]);
        }
    }

    public int getTotalUnitsSold(){
        int totalUnits = 0;
        for (int i = 0; i<productCount; i++){
            totalUnits += soldCount[i];
        }
        return totalUnits;
    }

}
