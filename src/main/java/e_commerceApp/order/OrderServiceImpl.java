package e_commerceApp.order;

import e_commerceApp.Cart;
import e_commerceApp.checkout.CheckoutService;
import e_commerceApp.checkout.CustomerBalanceCheckoutServiceImpl;
import e_commerceApp.checkout.MixPaymentCheckoutServiceImpl;
import e_commerceApp.discount.Discount;

import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.UUID;

import static e_commerceApp.StaticConstants.ORDER_LIST;

public class OrderServiceImpl implements OrderService {
    @Override
    public String placeOrder(Cart cart) {
        double amountAfterDiscount = cart.calculateCartTotalAmount();

        if (cart.getDiscountId() != null) {
            try {
                Discount discount = Discount.findDiscountById(cart.getDiscountId().toString());
                amountAfterDiscount = discount.calculateCartAmountAfterDiscountApplied(amountAfterDiscount);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("which payment option you would like to choose, Type 1 : customer balance, Type 2 : Mix (gift card + customer balance)");
        int paymentType = scanner.nextInt();
        boolean checkoutResult = false;
        switch (paymentType) {
            case 1:
                CheckoutService customerBalanceCheckoutService = new CustomerBalanceCheckoutServiceImpl();
                checkoutResult = customerBalanceCheckoutService.checkout(cart.getCustomer(), amountAfterDiscount);
                break;
            case 2:
                CheckoutService mixPaymentCheckoutService = new MixPaymentCheckoutServiceImpl();
                checkoutResult = mixPaymentCheckoutService.checkout(cart.getCustomer(), amountAfterDiscount);
                break;
        }

        if (checkoutResult) {
            Order order = new Order(UUID.randomUUID(), LocalDateTime.now(),
                    cart.calculateCartTotalAmount(), amountAfterDiscount,
                    cart.calculateCartTotalAmount() - amountAfterDiscount, cart.getCustomer().getId()
                    , "Placed", cart.getProductMap().keySet());
            ORDER_LIST.add(order);
            return "Order has been placed successfully";
        } else {
            return "Balance is insufficient. Please add money to your one of balances and try again.";
        }
    }

    public static void printOrdersByCustomerId(UUID customerId) {
        if (!ORDER_LIST.isEmpty()) {        // added
//            for (Order order : ORDER_LIST) {
//                if (order.getCustomerId().equals(customerId)) {
//                    System.out.println("Order status: " + order.getOrderStatus() + " order amount " + order.getPaidAmount() + " order date " + order.getOrderDate());
//                }
//            }
            ORDER_LIST.stream()
                    .filter(order -> order.getCustomerId().equals(customerId))
                    .forEach(order -> System.out.println("Order status: " + order.getOrderStatus()
                            + " order amount " + order.getPaidAmount() + " order date " + order.getOrderDate()));

        } else {
            System.out.println("You don't have any previous order.");
        }
    }
}
