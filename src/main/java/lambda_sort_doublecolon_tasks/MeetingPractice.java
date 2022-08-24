package lambda_sort_doublecolon_tasks;

import java.util.Collections;
import java.util.Comparator;

import static lambda_sort_doublecolon_tasks.DataGenerator.*;
import static lambda_sort_doublecolon_tasks.Service.getAllEmployees;

public class MeetingPractice {
    public static void main(String[] args) {
        createAllAddresses();
        createAllCompanies();
        createAllEmployees();

        //When you start to solve new question, comment out the System.out.println statement


        //EXAMPLE
        //       System.out.println("*** get all employees if their Id number is odd");
//        List<Employee> list0 = filter(getAllEmployees(), employee -> employee.getId() % 2 != 0);
//        list0.forEach(System.out::println);

//       getAllEmployees().forEach(employee -> System.out.println(employee.getId() % 2 == 0));
//
//        getAllEmployees().stream()
//                .filter(employee -> employee.getId() % 2 != 0)
//                .forEach(System.out::println);


        //System.out.println("*** get all employees if their Id number is even");


        //System.out.println("*** get all employees if they are older than 50");


        //System.out.println("*** get all employees whose company name info starts with A or a");


        //System.out.println("*** get all employees their company is located in Utah, Indiana or California as a state ");


        //System.out.println(" show all the employees full name and corresponding age information in one list");


        //System.out.println("*** get just the fullName of all employees if their Id number is even");


        //System.out.println("***just print the employees if their address id is 6");


        //System.out.println("***print all employees***");
        //    printAll(getAllEmployees(), System.out::println);


        //System.out.println("***SORTING QUESTIONS***");

        //System.out.println("sort all employees with age in ascending order");
        getAllEmployees().sort(Comparator.comparing(Employee::getAge));

        //System.out.println("sort all employees with age in descending order");
        getAllEmployees().sort(Comparator.comparing(Employee::getAge).reversed());

        //System.out.println("*** sort all employees with full name in ascending order and print only their full names ***");
//        getAllEmployees().sort(Comparator.comparing(Employee::getFullName));
//        getAllEmployees().forEach(employee -> System.out.println(employee.getFullName()));

        //System.out.println("*** sort all employees with full name in descending order and print only their full names ***");
        //   getAllEmployees().sort(Comparator.comparing(employee -> employee.getFullName(), Comparator.reverseOrder()));  // works
//        getAllEmployees().sort(Comparator.comparing(Employee::getFullName, Comparator.reverseOrder())); // works
//     //   getAllEmployees().sort(Comparator.comparing(employee -> employee.getFullName()).reversed());  compile time error
//        getAllEmployees().sort(Comparator.comparing(Employee::getFullName).reversed()); // works
//        getAllEmployees().forEach(employee -> System.out.println(employee.getFullName()));

        //System.out.println("***sort all employees with company name in ascending order***");
        getAllEmployees().sort(Comparator.comparing(employee -> employee.getCompany().getCompanyName()));
        Collections.sort(getAllEmployees(), Comparator.comparing(employee -> employee.getCompany().getCompanyName()));


        //System.out.println("***sort all employees with company name in descending order***");
        getAllEmployees().sort(Comparator.comparing(employee -> employee.getCompany().getCompanyName(), Comparator.reverseOrder()));


        //System.out.println("sort all employees with company id in ascending order");
    }
}
