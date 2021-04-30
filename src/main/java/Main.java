import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Hello" + "\n" + "Please enter first name, last name and salary of five employees");
        createEmployeeList();

        System.out.println("Choose option:" + "\n" + "1 – Print sum of all employees salary" + "\n" +
                "2 – Display all user employees data" + "\n" + "3 – Add new employee" + "\n" + "4 – End program" );

        Scanner scanner = new Scanner(System.in);
        String select = scanner.nextLine();

        switch (select) {
            case "1":
                double sum = 0;

                for (Employee employee : employeesList) {
                    sum += employee.getSalary();
                }
                System.out.println("Salary: " + sum);
                break;
            case "2":
                getAllData();
                break;
            case "3":
                System.out.println("Add new employee");

                break;
            case "4":
                break;
        }
    }

    static ArrayList<Employee> employeesList = new ArrayList<Employee>();

    public static ArrayList<Employee> createEmployeeList() {

        for (int i = 0; i < 5; i++) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter the first name of the " + (i + 1) + " employee: ");
            String firstname = scanner.next();
            System.out.println("Please enter the last name of the " + (i + 1) + " employee");
            String lastname = scanner.next();
            System.out.println("Please enter the salary of the " + (i + 1) + " employee");

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
        }

        return employeesList;
    }

    public static void getAllData() {
        for (Employee employee : employeesList) {
            System.out.println("Salary for " + employee.getFirstname() + " " + employee.getLastname()
                    + " is " + employee.getSalary() );
        }
    }

}

