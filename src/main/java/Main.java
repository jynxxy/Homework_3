import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Hello" + "\n" + "Please enter first name, last name and salary of five employees");
        createEmployeeList();

        System.out.println("Choose option:");
        System.out.println("1 – Print sum of all employees salary");
        System.out.println("2 – Display all user employees data");
        System.out.println("3 – Add new employee");
        System.out.println("4 – End program");

        Scanner scanner = new Scanner(System.in);
        String select = scanner.nextLine();


        switch (select) {
            case "1":
                System.out.println("Print sum of all employees salary");
                break;
            case "2":
                System.out.println("Display all user employees data");
                for (Employee employee : employeesList) {
                    System.out.println("Name: " + employee.getFirstname() + "Surname: " + employee.getLastname()
                            + "Salary: " + employee.getSalary() );
                }
                break;
            case "3":
                System.out.println("Add new employee");
                createEmployeeList();


                break;
            case "4":

                break;
        }
    }

    static ArrayList<Employee> employeesList = new ArrayList<Employee>();

    public static ArrayList<Employee> createEmployeeList() {

        for (int i = 0; i < 5; i++) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter the firstname of the " + (i + 1) + " employee: ");
            String firstname = scanner.next();
            System.out.println("Please enter the lastname of the " + (i + 1) + " employee");
            String lastname = scanner.next();
            System.out.println("Please enter the salary of the " + (i + 1) + " employee");
            int salary = scanner.nextInt();


            do {
                if (salary <= 0) {
                    System.out.println("You enter wrong salary,  please enter integer value > 0");
                } else if (!scanner.hasNextInt()) {
                    scanner.next();
                    System.out.println("You entered string, please enter integer value > 0");
                } else {
                    salary = scanner.nextInt();
                }
            } while (salary != 0);





//            System.out.println("You eneter wrong salary,  please enter integer value > 0");

            Employee employee = new Employee(firstname, lastname, salary);
            employeesList.add(employee);

        }

        return employeesList;
    }


}

