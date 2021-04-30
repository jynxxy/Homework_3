import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        createEmployeeList();

        boolean quit = false;
        do {
            System.out.println("\n" + "Choose option:" + "\n" + "1 – Print sum of all employees salary" + "\n" +
                    "2 – Display all user employees data" + "\n" + "3 – Add new employee" + "\n" + "4 – End program" );

            Scanner scanner = new Scanner(System.in);
            int select = scanner.nextInt();
            switch (select) {
                case 1:
                    double sum = 0;
                    for (Employee employee : employeesList) {
                        sum += employee.getSalary();
                    }
                    System.out.println("Sum of salaries: " + sum);
                    break;
                case 2:
                    getAllData();
                    break;
                case 3:
                    System.out.println("Add new employee");
                    addEmployeeToList();
                    break;
                case 4:
                    System.out.println("Good bye");
                    quit = true;
            }
        } while (!quit);

    }

    static ArrayList<Employee> employeesList = new ArrayList<Employee>();

    public static ArrayList<Employee> createEmployeeList() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Please enter the first name, last name and salary of the " + (i + 1) + " employee: ");
            addEmployeeToList();
        }
        return employeesList;
    }

    public static void getAllData() {
        for (Employee employee : employeesList) {
            System.out.println("Salary for " + employee.getFirstname() + " " + employee.getLastname()
                    + " is " + employee.getSalary() );
        }
    }

    public static ArrayList<Employee> addEmployeeToList() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter the first name of the employee: ");
            String firstname = scanner.next();
            System.out.println("Please enter the last name of the employee");
            String lastname = scanner.next();
            System.out.println("Please enter the salary of the employee");

            boolean isValid = false;
            int intSalary = 0;
            while (!isValid){
                String salary = scanner.next();

                try {
                    intSalary = Integer.parseInt(salary);
                } catch (NumberFormatException e) {
                    System.out.println("You entered string, please enter integer value");
                    continue;
                }
                if (intSalary <= 0) {
                    System.out.println("You enter wrong salary,  please enter integer value > 0");
                    continue;
                }
                isValid = true;
            }

            Employee employee = new Employee(firstname, lastname, intSalary);
            employeesList.add(employee);

        return employeesList;
    }

}

