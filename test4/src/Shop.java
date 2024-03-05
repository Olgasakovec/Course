import java.util.ArrayList;
import java.util.List;

public class Shop {
    private List<Product> productList;

    public Shop() {
        this.productList = new ArrayList<>();
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void addProduct(Product product) {
        boolean exist = false;
        for (Product product1 : productList) {
            if (product1.getId() == product.getId())
                productList.add(product1);
            break;
        }
    }

    public List<Product> getAllProduct() {
        return productList;
    }

    public void deleteProduct(int id) {
        for (Product product1 : productList) {
            if (product1.getId() == id) {
                productList.remove(product1);
                System.out.println("Товар с ID" + id + "удалено успешно");
                return;
            }
        }
    }

    public void editProduct(int id, Product newProduct) {
        for (int i = 0; i < productList.size(); i++)
            if (productList.get(i).getId() == id) {
                productList.set(i, newProduct);
                System.out.println("Товар с ID" + id + "изменен успешно");
            }
    }
 }
