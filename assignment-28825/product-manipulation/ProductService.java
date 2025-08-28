import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService implements ProductInterface{

    private Map<Integer, Product> productMap = new HashMap<>();

    @Override
    public void addProduct(Product product) {
        productMap.put(product.getId(), product);
        System.out.println("Product added successfully!");    
    }

    @Override
    public Product searchProduct(int productId) {
        return productMap.get(productId);
    }

    @Override
    public List<Product> getAllProducts() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public void updateProduct(int productId, String name, double price, int stock) {
        Product product = productMap.get(productId);
        if (product != null) {
            product.setName(name);
            product.setPrice(price);
            product.setStock(stock);
            System.out.println("Product updated successfully!");
        } else {
            System.out.println("Product not found!");
        }
    }

    @Override
    public void deleteProduct(int productId) {
        if (productMap.remove(productId) != null) {
            System.out.println("Product deleted successfully!");
        } else {
            System.out.println("Product not found!");
        }
    }

    @Override
    public void addToCart(int productId, int quantity) {
        Product product = productMap.get(productId);
        if (product != null) {
            if (product.getStock() >= quantity) {
                product.setStock(product.getStock() - quantity);
                System.out.println(quantity + " unit(s) of " + product.getName() + " added to cart.");
            } else {
                System.out.println("Not enough stock available!");
            }
        } else {
            System.out.println("Product not found!");
        }
    }
    
}