import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ProductService service = new ProductService();

        while (true) {
            System.out.println("\n--- Product Management Menu ---");
            System.out.println("1. Add Product");
            System.out.println("2. Search Product");
            System.out.println("3. Get All Products");
            System.out.println("4. Update Product");
            System.out.println("5. Delete Product");
            System.out.println("6. Add Product to Cart");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter Product ID: ");
                    int id = sc.nextInt();
                    sc.nextLine(); // consume newline
                    System.out.print("Enter Product Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Product Price: ");
                    double price = sc.nextDouble();
                    System.out.print("Enter Product Stock: ");
                    int stock = sc.nextInt();
                    service.addProduct(new Product(id, name, price, stock));
                    break;

                case 2:
                    System.out.print("Enter Product ID to search: ");
                    int searchId = sc.nextInt();
                    Product found = service.searchProduct(searchId);
                    if (found != null) {
                        System.out.println(found);
                    } else {
                        System.out.println("Product not found!");
                    }
                    break;

                case 3:
                    List<Product> products = service.getAllProducts();
                    if (products.isEmpty()) {
                        System.out.println("No products available.");
                    } else {
                        for (Product p : products) {
                            System.out.println(p);
                        }
                    }
                    break;

                case 4:
                    System.out.print("Enter Product ID to update: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter new Name: ");
                    String newName = sc.nextLine();
                    System.out.print("Enter new Price: ");
                    double newPrice = sc.nextDouble();
                    System.out.print("Enter new Stock: ");
                    int newStock = sc.nextInt();
                    service.updateProduct(updateId, newName, newPrice, newStock);
                    break;

                case 5:
                    System.out.print("Enter Product ID to delete: ");
                    int deleteId = sc.nextInt();
                    service.deleteProduct(deleteId);
                    break;

                case 6:
                    System.out.print("Enter Product ID to add to cart: ");
                    int cartId = sc.nextInt();
                    System.out.print("Enter Quantity: ");
                    int qty = sc.nextInt();
                    service.addToCart(cartId, qty);
                    break;

                case 7:
                    System.out.println("Exiting... Thank you!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}