import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Employee {
    private String employeeID;
    private String name;
    private int age;
    private int salary;

    public Employee(String employeeID, String name, int age, int salary) {
        this.employeeID = employeeID;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee ID: " + employeeID + ", Name: " + name + ", Age: " + age + ", Salary: " + salary;
    }
}

class EmployeeComparator implements Comparator<Employee> {
    private String sortBy;

    public EmployeeComparator(String sortBy) {
        this.sortBy = sortBy;
    }

    @Override
    public int compare(Employee emp1, Employee emp2) {
        switch (sortBy) {
            case "Age":
                return Integer.compare(emp1.getAge(), emp2.getAge());
            case "Name":
                return emp1.getName().compareTo(emp2.getName());
            case "Salary":
                return Integer.compare(emp1.getSalary(), emp2.getSalary());
            default:
                throw new IllegalArgumentException("Invalid sorting parameter");
        }
    }
}

public class EmployeeSorter {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("161E90", "Ramu", 35, 59000));
        employees.add(new Employee("171E22", "Tejas", 30, 82100));
        employees.add(new Employee("171G55", "Abhi", 25, 100000));
        employees.add(new Employee("152K46", "Jaya", 32, 85000));

        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose sorting parameter:");
        System.out.println("1. Age\n2. Name\n3. Salary");

        int choice = scanner.nextInt();
        String sortBy;

        switch (choice) {
            case 1:
                sortBy = "Age";
                break;
            case 2:
                sortBy = "Name";
                break;
            case 3:
                sortBy = "Salary";
                break;
            default:
                System.out.println("Invalid choice. Exiting program.");
                return;
        }

        EmployeeComparator comparator = new EmployeeComparator(sortBy);
        Collections.sort(employees, comparator);

        System.out.println("\nSorted Employee Data:");
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}
