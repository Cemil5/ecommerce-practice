package e_commerceApp;

import java.util.Map;
import java.util.Scanner;
import java.util.UUID;

public class Cart {

    private Customer customer;
    private UUID discountId;
    private Map<Product,Integer> productMap;

    public Cart(Customer customer) {
        this.customer = customer;
    }

    public Cart(Customer customer, UUID discountId, Map<Product, Integer> productMap) {
        this.customer = customer;
        this.discountId = discountId;
        this.productMap = productMap;
    }

    public Double calculateCartTotalAmount(){
//        double totalAmount=0;
//        for(Product product : productMap.keySet()){
//            totalAmount += product.getPrice() * productMap.get(product);
//        }
//        return totalAmount;
       return productMap.keySet().stream()
                .map(product -> product.getPrice() * productMap.get(product))
           //     .reduce( (a, b) -> a+b).orElseThrow(() -> new RuntimeException("total amount cannot be calculated"));
                .reduce(Double::sum).orElseThrow(() -> new RuntimeException("total amount cannot be calculated"));
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public UUID getDiscountId() {
        return discountId;
    }

    public void setDiscountId(UUID discountId) {
        this.discountId = discountId;
    }

    public Map<Product, Integer> getProductMap() {
        return productMap;
    }

    public void setProductMap(Map<Product, Integer> productMap) {
        this.productMap = productMap;
    }

    public static boolean putItemToCartIfStockAvailable(Cart cart, Product product) {
        System.out.println("Please provide product count:");
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();

        Integer cartCount = cart.getProductMap().get(product);

        if (cartCount != null && product.getRemainingStock() > cartCount + count) {
            cart.getProductMap().put(product, cartCount + count);
            return true;

        } else if (product.getRemainingStock() >= count) {
            cart.getProductMap().put(product, count);
            return true;
        }
        return false;
    }

}
