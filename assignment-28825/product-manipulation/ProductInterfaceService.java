import java.util.List;

public interface ProductInterfaceService {

    void addProduct(Product product);
    Product searchProduct(int productId);
    List<Product> getAllProducts();
    void updateProduct(int productId, String name, double price, int stock);
    void deleteProduct(int productId);
    void addToCart(int productId, int quantity);    

}
