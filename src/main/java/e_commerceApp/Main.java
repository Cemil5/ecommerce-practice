package e_commerceApp;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

import static e_commerceApp.StaticConstants.CUSTOMER_LIST;

public class Main {

    public static void main(String[] args) {

        DataGenerator.createCustomer();
        DataGenerator.createCategory();
        DataGenerator.createProduct();
        DataGenerator.createBalance();
        DataGenerator.createDiscount();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Select Customer:");
//        for (int i = 0; i < CUSTOMER_LIST.size(); i++) {
//            System.out.println("Type " + i + " for customer:" + CUSTOMER_LIST.get(i).getUserName());
//        }
        AtomicInteger i = new AtomicInteger();
        CUSTOMER_LIST.forEach( customer -> System.out.println("Type " + i.getAndIncrement() + " for customer:" + customer.getUserName()));

        Customer customer = CUSTOMER_LIST.get(scanner.nextInt());

        MainMenu.mainMenu(customer);

    }

}
