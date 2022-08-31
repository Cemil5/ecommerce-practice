package e_commerceApp;

import e_commerceApp.balance.CustomerBalance;
import e_commerceApp.balance.GiftCardBalance;
import e_commerceApp.category.Category;
import e_commerceApp.discount.Discount;
import e_commerceApp.order.OrderService;
import e_commerceApp.order.OrderServiceImpl;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static e_commerceApp.StaticConstants.*;

public class MainMenu {

    public static void mainMenu(Customer customer) {

        Scanner scanner = new Scanner(System.in);
        Cart cart = new Cart(customer);

        while (true) {

            System.out.println("What would you like to do? Just type id for selection");

            for (int i = 0; i < prepareMenuOptions().length; i++) {
                System.out.println(i + "-" + prepareMenuOptions()[i]);
            }

            int menuSelection = scanner.nextInt();

            switch (menuSelection) {
                case 0: //list categories
                    // todo convert for loop to forEach()
                    for (Category category : CATEGORY_LIST) {
                        System.out.println("Category Code:" + category.generateCategoryCode() + " category name:" + category.getName());
                    }

                    break;

                case 1: //list products  //product name, product category name
                    try {
                        // todo convert for loop to forEach()
                        for (Product product : PRODUCT_LIST) {
                            System.out.println("Product Name:" + product.getName() + "Product Category Name: " + product.getCategoryName());
                        }
                    } catch (Exception e) {
                        System.out.println("Product could not printed because category not found for product name: " + e.getMessage().split(",")[1]);
                    }
                    break;

                case 2: //list discounts
                    // todo convert for loop to forEach()
                    for (Discount discount : DISCOUNT_LIST) {
                        System.out.println("Discount Name: " + discount.getName() + "  discount threshold amount: " + discount.getThresholdAmount());
                    }
                    break;

                case 3:  // See Balance
                    CustomerBalance cBalance = CustomerBalance.findCustomerBalance(customer.getId());
                    GiftCardBalance gBalance = GiftCardBalance.findGiftCardBalance(customer.getId());
                    double totalBalance = cBalance.getBalance() + gBalance.getBalance();
                    System.out.println("Total Balance: " + totalBalance);
                    System.out.println("Customer Balance: " + cBalance.getBalance());
                    System.out.println("Gift Card Balance: " + gBalance.getBalance());
                    break;

                case 4: // Add Balance
                    CustomerBalance customerBalance = CustomerBalance.findCustomerBalance(customer.getId());
                    GiftCardBalance giftCardBalance = GiftCardBalance.findGiftCardBalance(customer.getId());
                    System.out.println("Which Account would you like to add?");
                    System.out.println("Type 1 for Customer Balance: " + customerBalance.getBalance());
                    System.out.println("Type 2 for Gift Card Balance: " + giftCardBalance.getBalance());
                    int balanceAccountSelection = scanner.nextInt();
                    if (!(balanceAccountSelection == 1 || balanceAccountSelection == 2)) {      // added
                        System.err.println("You should type 1 or 2. Please try again.");
                        continue;
                    }
                    System.out.println("How much you would like to add?");
                    double additionalAmount = scanner.nextInt();

                    switch (balanceAccountSelection) {
                        case 1:
                            customerBalance.addBalance(additionalAmount);
                            System.out.println("New Customer Balance: " + customerBalance.getBalance() + " ($10 added as a bonus)");
                            break;
                        case 2:
                            giftCardBalance.addBalance(additionalAmount);
                            System.out.println("New Gift Card Balance: " + giftCardBalance.getBalance() + " (10 % added as a bonus)");
                            break;
                    }
                    break;

                case 5: // Add product(s) to cart
                    if (cart.getProductMap() == null) {
                        Map<Product, Integer> map = new HashMap<>();
                        cart.setProductMap(map);
                    }
                    while (true) {
                        System.out.println("Which product you want to add to your cart? Type 'exit' to continue without adding new item");
                        // TODO convert for loop to forEach()
                        for (Product product : PRODUCT_LIST) {
                            System.out.println(product);
                        }
                        String productId = scanner.next();
                        if (productId.equalsIgnoreCase("exit")) {      // added after live session
                            break;
                        }

                        try {
                            Product product = Product.findProductById(productId);
                            if (!Cart.putItemToCartIfStockAvailable(cart, product)) {
                                System.out.println("Stock is insufficient. Please try again");
                                continue;
                            }
                        } catch (Exception e) {
                            System.out.println("Product does not exist. please try again");
                            continue;
                        }

                        System.out.println("Do you want to add more product. Type Y for adding more, N for exit");
                        String decision = scanner.next();
                        if (!decision.equals("Y")) {
                            break;
                        }
                    }
                    break;

                case 6:    // Place an order
                    if (cart.getProductMap().isEmpty()) {  // added after live session
                        System.out.println("Your cart is empty. Please, add product(s) to cart");
                        continue;
                    }

                    Discount.checkDiscount(scanner, cart);

                    OrderService orderService = new OrderServiceImpl();

                    String result = orderService.placeOrder(cart);
                    if (result.equals("Order has been placed successfully")) {
                        System.out.println("Order is successful");
                        Product.updateProductStock(cart.getProductMap());
                        cart.setProductMap(new HashMap<>());
                        cart.setDiscountId(null);
                    } else {
                        System.out.println(result);
                    }
                    break;

                case 7:     // See Cart
                    if (cart.getProductMap() != null) {  // modified from !cart.getProductMap().keySet().isEmpty()
                        System.out.println("Your Cart: ");
                        // todo convert for loop to forEach()
                        for (Product product : cart.getProductMap().keySet()) {
                            System.out.println("product name: " + product.getName() + " count: " + cart.getProductMap().get(product)
                                    + " total price: " + product.getPrice() * cart.getProductMap().get(product));   // added after live session
                        }
                    } else {
                        System.out.println("Your cart is empty");
                    }
                    break;

                case 8: // See order details
                    OrderServiceImpl.printOrdersByCustomerId(customer.getId());
                    break;
                case 9: // See your address
                    Address.printAddressByCustomerId(customer);
                    break;
                case 10:
                    System.exit(1);
                    break;
            }
        }
    }

    private static String[] prepareMenuOptions() {
        return new String[]{"List Categories", "List Products", "List Discount", "See Balance", "Add Balance",
                "Add product(s) to cart", "Place an order", "See Cart", "See order details", "See your address",
                "Close App"};
    }
}
