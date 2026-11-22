import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Store store = new Store("Spar" , 3);
        Product notebook = new Product("Notebook" , 12.5 , 3);
        Product pen = new Product("Pen" , 4.0 , 2);
        Product bottle = new Product("Bottle" , 30.0 , 0);

        store.addProduct(pen);
        store.addProduct(notebook);
        store.addProduct(bottle);

        Product pencil = new Product("Pencil" , 3.0 , 5);
        System.out.println(store.addProduct(pencil));

        store.sellProduct(notebook.getId(), 2);
        System.out.println(store.sellProduct(pen.getId(), 3));
        System.out.println(store.sellProduct(pen.getId(), 2));

        pen.setPrice(-5);
        System.out.println(pen.getPrice());

        store.printAvailableProducts();
        System.out.println("Total units: " + store.getTotalUnitsSold());

        System.out.println("Sales report: "); store.printSalesReport();

        System.out.println("Notebook id: " + notebook.getId());
        System.out.println("Pen id: " + pen.getId());
        System.out.println("Bottle id: " + bottle.getId());
        System.out.println("Pencil id: " + pencil.getId());
        System.out.println("Next id: " + Product.getNextId());

        System.out.println(notebook.getStock());
        System.out.println(pen.getStock());
        System.out.println(store.getTotalUnitsSold());

        }
    }
