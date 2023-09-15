//Not in Lab
public class Employee {
    int salary;
    private String name;

    //constutor
    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Emp " + name + "(" + salary + ")";
    }
}
