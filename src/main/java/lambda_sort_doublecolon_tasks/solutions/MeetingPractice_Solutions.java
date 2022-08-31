package lambda_sort_doublecolon_tasks.solutions;


import lambda_sort_doublecolon_tasks.Company;
import lambda_sort_doublecolon_tasks.Employee;

import java.util.Comparator;

import static lambda_sort_doublecolon_tasks.DataGenerator.*;
import static lambda_sort_doublecolon_tasks.Service.getAllEmployees;

public class MeetingPractice_Solutions {

    public static void main(String[] args) {
        createAllAddresses();
        createAllCompanies();
        createAllEmployees();

        //When you start to solve new question, comment out the System.out.println statement

        // EXAMPLE
        //  System.out.println("*** get all employees if their Id number is odd");

//        System.out.println("*************** solution with behavior parameterization ****************");
//        List<Employee> list = filter(getAllEmployees(), employee -> employee.getId() % 2 !=0);
//        list.forEach(System.out::println);

//        System.out.println("*************** solution with forEach() method **************");
//        getAllEmployees().forEach(employee -> {if (employee.getId() % 2 !=0){
//            System.out.println(employee);}
//        });

//        System.out.println("*************** solution with forEach() method **************");
//        getAllEmployees().stream()
//                .filter(employee -> employee.getId() %2 !=0)
//                .forEach(System.out::println);


        //System.out.println("*** get all employees if their Id number is even");

//        System.out.println("*************** solution with behavior parameterization ****************");
//        List<Employee> list = filter(getAllEmployees(), employee -> employee.getId() % 2 ==0);
//        list.forEach(System.out::println);

//        System.out.println("*************** solution with forEach() method **************");
//        getAllEmployees().forEach(employee -> {if (employee.getId() % 2 ==0){
//            System.out.println(employee);}
//        });

//        System.out.println("**************** solution with stream **************");
//        getAllEmployees().stream()
//                .filter(employee -> employee.getId() %2 ==0)
//                .forEach(System.out::println);

        //System.out.println("*** get all employees if they are older than 50");

//        System.out.println("*************** solution with behavior parameterization ****************");
//        List<Employee> list = filter(getAllEmployees(), employee -> employee.getAge() > 50);
//        list.forEach(System.out::println);

//        System.out.println("*************** solution with behavior parameterization ****************");
//        getAllEmployees().forEach(employee -> {if (employee.getAge() > 50){
//            System.out.println(employee);}
//        });

//        System.out.println("*************** solution with behavior parameterization ****************");
//        getAllEmployees().stream()
//                .filter(employee -> employee.getAge() > 50)
//                .forEach(System.out::println);

        //System.out.println("*** get all employees whose company name info starts with A or a");

//        System.out.println("*************** solution with behavior parameterization ****************");
//        List<Employee> list = filter(getAllEmployees(), employee -> employee.getCompany().getCompanyName().substring(0, 1).equalsIgnoreCase("a"));
//        list.forEach(System.out::println);

//        System.out.println("*************** solution with forEach() method **************");
//        getAllEmployees().forEach(employee -> {if (employee.getCompany().getCompanyName().substring(0, 1).equalsIgnoreCase("a")){
//            System.out.println(employee);}
//        });

//        System.out.println("**************** solution with stream **************");
//        getAllEmployees().stream()
//                .filter(employee -> employee.getCompany().getCompanyName().substring(0, 1).equalsIgnoreCase("a"))
//                .forEach(System.out::println);


        //System.out.println("*** get all employees their company is located in Utah, Indiana or California as a state ");

//        System.out.println("*************** solution with behavior parameterization ****************");
//        List<Employee> list = filter(getAllEmployees(), employee -> employee.getCompany().getAddress().getState().equalsIgnoreCase("Utah")
//                || employee.getCompany().getAddress().getState().equalsIgnoreCase("Indiana")
//                || employee.getCompany().getAddress().getState().equalsIgnoreCase("California"));
//        list.forEach(System.out::println);

//        System.out.println("*************** solution with forEach() method **************");
//        getAllEmployees().forEach(employee -> {if (employee.getCompany().getAddress().getState().equalsIgnoreCase("Utah")
//                || employee.getCompany().getAddress().getState().equalsIgnoreCase("Indiana")
//                || employee.getCompany().getAddress().getState().equalsIgnoreCase("California")){
//            System.out.println(employee);}
//        });

//        System.out.println("**************** solution with stream **************");
//        getAllEmployees().stream()
//                .filter(employee -> employee.getCompany().getAddress().getState().equalsIgnoreCase("Utah")
//                        || employee.getCompany().getAddress().getState().equalsIgnoreCase("Indiana")
//                        || employee.getCompany().getAddress().getState().equalsIgnoreCase("California"))
//                .forEach(System.out::println);


        //System.out.println(" show all the employees full name and corresponding age information in one list");

//        System.out.println("*************** solution with behavior parameterization ****************");
//        List<String> list = getSpecificAttributesOfAllList(getAllEmployees(), employee -> employee.getFullName()+" | " + employee.getAge());
//        list.forEach(System.out::println);
//
//        System.out.println("*************** solution with forEach() method **************");
//        getAllEmployees().forEach(employee -> System.out.println(employee.getFullName()+" | " + employee.getAge()));
//
//        System.out.println("**************** solution with stream **************");
//        getAllEmployees().stream()
//                .map(employee -> employee.getFullName()+" | " + employee.getAge())
//                .forEach(System.out::println);

        //System.out.println("*** get just the fullName of all employees if their Id number is even");

//        System.out.println("*************** solution with behavior parameterization ****************");
//        List<String> list = getFullNameWithCondition(getAllEmployees(), Employee::getFullName, employee -> employee.getId() % 2 == 0);
//        list.forEach(System.out::println);
//
//        System.out.println("*************** solution with forEach() method **************");
//        getAllEmployees().forEach(employee -> {
//            if (employee.getId() % 2 == 0) {
//                System.out.println(employee.getFullName());
//            }
//        });
//
//        System.out.println("**************** solution with stream **************");
//        getAllEmployees().stream()
//                .filter(employee -> employee.getId() % 2 == 0)
//                .map(Employee::getFullName)
//                .forEach(System.out::println);

        //System.out.println("***just print the employees if their company address id is 6");
//        System.out.println("*************** solution with behavior parameterization ****************");
//        List<String> list = getFullNameWithCondition(getAllEmployees(), Employee::getFullName,
//                employee -> employee.getCompany().getAddress().getId() == 6);
//        list.forEach(System.out::println);
//
//        System.out.println("*************** solution with forEach() method **************");
//        getAllEmployees().forEach(employee -> {
//            if (employee.getCompany().getAddress().getId() == 6) {
//                System.out.println(employee.getFullName());
//            }
//        });
//
//        System.out.println("**************** solution with stream **************");
//        getAllEmployees().stream()
//                .filter(employee -> employee.getCompany().getAddress().getId() == 6)
//                .map(Employee::getFullName)
//                .forEach(System.out::println);


        //System.out.println("***print all employees***");
//        System.out.println("*************** solution with behavior parameterization ****************");
//        printAll(getAllEmployees(), System.out::println);
//        System.out.println("*************** solution with forEach() method **************");
//        getAllEmployees().forEach(System.out::println);
//        System.out.println("**************** solution with stream **************");
//        getAllEmployees().stream()
//                .forEach(System.out::println);



        //System.out.println("***SORTING QUESTIONS***");

        //System.out.println("sort all employees with age in ascending order and then print their ages and names");
//        getAllEmployees().sort(Comparator.comparing(employee -> employee.getAge()));  // solution with comparing + lambda
//        getAllEmployees().sort(Comparator.comparing(Employee::getAge));               // solution with comparing + method reference
//        getAllEmployees().sort((e1, e2) -> e1.getAge().compareTo(e2.getAge()) );      // solution with Comparable interface
//        getAllEmployees().forEach(employee -> System.out.println(employee.getAge() + " | " + employee.getFullName()));


        //System.out.println("sort all employees with company id in ascending order and then print company id and company names");
//        getAllEmployees().sort(Comparator.comparing(employee -> employee.getCompany().getId()));              // solution with comparing + lambda
//        getAllEmployees().sort((e1, e2) -> e1.getCompany().getId().compareTo(e2.getCompany().getId()) );      // solution with Comparable interface
//        getAllEmployees().forEach(employee -> System.out.println(employee.getCompany().getId() + " | " + employee.getCompany().getCompanyName()));


        //System.out.println("sort all employees with age in descending order and then print their ages and names");
//       getAllEmployees().sort(Comparator.comparing(Employee::getAge).reversed());              // solution with comparing + method reference
//     //   getAllEmployees().sort(Comparator.comparing(employee -> employee.getAge()).reversed());           // not compile
//        getAllEmployees().sort((e1, e2) -> e2.getAge().compareTo(e1.getAge()) );                         // solution with Comparable interface
//        getAllEmployees().forEach(employee -> System.out.println(employee.getAge() + " | " + employee.getFullName()));


        //System.out.println("*** sort all employees with full name in ascending order and print only their full names ***");

//        System.out.println("**************** solution with list.sort() + Comparator & Comparable interface **************");
//        getAllEmployees().sort(Comparator.comparing(Employee::getFullName));               // solution with comparing + method reference
//        getAllEmployees().sort(Comparator.comparing(employee -> employee.getFullName()));  // solution with comparing + lambda
//        getAllEmployees().sort((e1, e2) -> e1.getFullName().compareTo(e2.getFullName()) );           // solution with Comparable interface
//        getAllEmployees().forEach(employee -> System.out.println(employee.getFullName()));

//        System.out.println("**************** solution with stream **************");
//        getAllEmployees().stream()
//                .sorted(Comparator.comparing(Employee::getFullName))
//                .forEach(employee -> System.out.println(employee.getFullName()));


        //System.out.println("*** sort all employees with full name in descending order and print only their full names ***");

//        System.out.println("**************** solution with list.sort() + Comparator & Comparable interface **************");
//        getAllEmployees().sort(Comparator.comparing(Employee::getFullName).reversed());              // solution with comparing + method reference
//        //getAllEmployees().sort(Comparator.comparing(employee -> employee.getFullName()).reversed());  // not compile
//        getAllEmployees().sort(Comparator.comparing(employee -> employee.getFullName(), Comparator.reverseOrder()));   // solution with comparing + lambda
//        getAllEmployees().sort((e1, e2) -> e2.getFullName().compareTo(e1.getFullName()) );           // solution with Comparable interface
//        getAllEmployees().forEach(employee -> System.out.println(employee.getFullName()));

//        System.out.println("**************** solution with stream **************");
//        getAllEmployees().stream()
//                .sorted(Comparator.comparing(Employee::getFullName).reversed())
//                .forEach(employee -> System.out.println(employee.getFullName()));


        //System.out.println("***sort all employees with company name in ascending order***");

//        System.out.println("**************** solution with list.sort() + Comparator & Comparable interface **************");
//        getAllEmployees().sort(Comparator.comparing(employee -> employee.getCompany().getCompanyName()));                     // solution with comparing + lambda
//        getAllEmployees().sort((e1, e2) -> e1.getCompany().getCompanyName().compareTo(e2.getCompany().getCompanyName()) );    // solution with Comparable interface
//        getAllEmployees().forEach(employee -> System.out.println(employee.getFullName() + " | " + employee.getCompany().getCompanyName()));

//        System.out.println("**************** solution with stream **************");
//        getAllEmployees().stream()
//                .sorted(Comparator.comparing(employee -> employee.getCompany().getCompanyName()))
//                .forEach(employee -> System.out.println(employee.getFullName() + " | " + employee.getCompany().getCompanyName()));

        //System.out.println("***sort all employees with company name in descending order***");

//        System.out.println("**************** solution with list.sort() + Comparator & Comparable interface **************");
//        getAllEmployees().sort(Comparator.comparing(employee -> employee.getCompany().getCompanyName(), Comparator.reverseOrder()));  // solution with comparing + lambda
//        getAllEmployees().sort((e1, e2) -> e2.getCompany().getCompanyName().compareTo(e1.getCompany().getCompanyName()) );            // solution with Comparable interface
//        getAllEmployees().forEach(employee -> System.out.println(employee.getFullName() + " | " + employee.getCompany().getCompanyName()));

//        System.out.println("**************** solution with stream **************");
//        getAllEmployees().stream()
//                .sorted(Comparator.comparing(employee -> employee.getCompany().getCompanyName(), Comparator.reverseOrder()))
//                .forEach(employee -> System.out.println(employee.getFullName() + " | " + employee.getCompany().getCompanyName()));


        //System.out.println("***sort all employees with their gender and then with their company name both in ascending order***");

//        System.out.println("**************** solution with list.sort() + Comparator interface **************");
//        getAllEmployees().sort(Comparator.comparing(Employee::getGender)
//                .thenComparing(employee -> employee.getCompany().getCompanyName()));
//        getAllEmployees().forEach(employee -> System.out.println(employee.getGender().getValue() + " | " + employee.getCompany().getCompanyName()));
//
//        System.out.println("**************** solution with stream **************");
//        getAllEmployees().stream()
//                .sorted(Comparator.comparing(Employee::getGender)
//                        .thenComparing(Comparator.comparing(employee -> employee.getCompany().getCompanyName())))
//                .forEach(employee -> System.out.println(employee.getGender().getValue() + " |" + employee.getCompany().getCompanyName()));


        //System.out.println("***sort all employees with their gender in ascending order and then with their name in descending order***");

//        System.out.println("**************** solution with list.sort() + Comparator & Comparable interface **************");
//        getAllEmployees().sort(Comparator.comparing(Employee::getGender)
//                .thenComparing(Comparator.comparing(Employee::getFullName).reversed()));
//        getAllEmployees().forEach(employee -> System.out.println(employee.getGender().getValue() + " | " + employee.getCompany().getCompanyName()));
//
//        System.out.println("**************** solution with stream **************");
//        getAllEmployees().stream()
//                .sorted(Comparator.comparing(Employee::getGender)
//                        .thenComparing(Comparator.comparing(Employee::getFullName).reversed()))
//                .forEach(employee -> System.out.println(employee.getGender().getValue() + " |" + employee.getFullName()));


        //System.out.println("***sort all employees with their gender in ascending order and then with their company name in descending order***");

//        System.out.println("**************** solution with list.sort() + Comparator + Comparable interface **************");
//        getAllEmployees().sort(Comparator.comparing(Employee::getGender)
//                .thenComparing((e1, e2) -> e2.getCompany().getCompanyName().compareTo(e1.getCompany().getCompanyName())));
//        getAllEmployees().forEach(employee -> System.out.println(employee.getGender().getValue() + " | " + employee.getCompany().getCompanyName()));
//
//        System.out.println("**************** solution with stream **************");
//        getAllEmployees().stream()
//                .sorted(Comparator.comparing(Employee::getGender)
//                        .thenComparing( (e1, e2) -> e2.getCompany().getCompanyName().compareTo(e1.getCompany().getCompanyName()) ))
//                .forEach(employee -> System.out.println(employee.getGender().getValue() + " |" + employee.getCompany().getCompanyName()));


        //System.out.println("***sort all employees with their company name in descending order and then with their full name in ascending order***");
        // this task cannot be solved similar to previous sorting tasks, we need to use two compareTo method

//        System.out.println("**************** solution with list.sort() + Comparator + Comparable interface **************");
//        getAllEmployees().sort((e1, e2) -> {
//            int res = e2.getCompany().getCompanyName().compareTo(e1.getCompany().getCompanyName());
//            return res != 0 ? res : e1.getFullName().compareTo(e2.getFullName());
//        });
//        getAllEmployees().forEach(employee -> System.out.println(employee.getCompany().getCompanyName() + " | " + employee.getFullName()));
//
//        System.out.println("**************** solution with stream **************");
//        getAllEmployees().stream()
//                .sorted((e1, e2) -> {
//                    int res = e2.getCompany().getCompanyName().compareTo(e1.getCompany().getCompanyName());
//                    return res != 0 ? res : e1.getFullName().compareTo(e2.getFullName());
//                })
//                .forEach(employee -> System.out.println(employee.getCompany().getCompanyName() + " | " + employee.getFullName()));


    }
}
