public class Product {
    private String name;
    private int productId;

    public Product(String name, int productId) {
        this.name = name;
        this.productId = productId;
    }
    public String getName() {
        return name;
    }

    public int getProductId() {
        return productId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "Name: " + name + "ProductId" + productId;
    }
}










