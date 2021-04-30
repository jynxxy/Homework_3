public class Employee {

    private String firstname;
    private String lastname;
    private int salary;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Employee(String firstname, String lastname, int salary) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.salary = salary;
    }

}
