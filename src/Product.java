public class Product {
    private int id;
    private String name;
    private double price;
    private int stock;
    private static int nextId = 1000;

    public Product(String name, double price, int stock) {
        this.id = nextId++;

        if (name != null && !name.isBlank()) {
            this.name = name;
        } else {
            this.name = "unknown";
        }
        if (price <= 0) {
            this.price = 1.0;
        } else {
            this.price = price;
        }
        if (stock < 0) {
            this.stock = 0;
        } else {
            this.stock = stock;
        }
    }

    public int getId(){
        return id;
    }
    public double getPrice(){
        return price;
    }
    public String getName(){
        return name;
    }
    public int getStock(){
        return stock;
    }

    public boolean setName(String name){
        if (name != null && !name.isBlank()){
            this.name = name.strip();
            return true;
        }
        else{
            return false;
        }
    }
    public boolean setPrice(double price){
        if(price > 0){
            this.price = price;
            return true;
        }
        else{
            return false;
        }

    }
    public boolean setStock(int stock){
        if(stock >= 0){
            this.stock = stock;
            return true;
        }
        else{
            return false;
        }
    }

    public boolean sell(int quantity){
        if(stock - quantity >= 0){
            stock -= quantity;
            return true;
        }
        else{
            return false;
        }
    }
    public String getInfo(){
        return "Product ID: " + id + " Product name: " + name + " Product price: " + price + " Product stock: " + stock;
    }
    public static int getNextId(){
        return nextId;
    }



}
