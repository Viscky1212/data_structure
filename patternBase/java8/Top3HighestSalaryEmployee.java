package patternBase.java8;


//department wise top 3 highest salary employee
import java.util.*;
import java.util.stream.Collectors;


class Employee {
    private int id;
    private String department;
    private String name;
    private double salary;

    public Employee(int id, String department, String name, double salary) {
        this.id = id;
        this.department = department;
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }
    public String getDepartment() {
        return department;
    }
}

public class Top3HighestSalaryEmployee {

    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
                new Employee(1, "IT", "Alice", 90000),
                new Employee(2, "IT", "Bob", 85000),
                new Employee(3, "IT", "Charlie", 95000),
                new Employee(4, "HR", "David", 70000),
                new Employee(5, "HR", "Eve", 75000),
                new Employee(6, "HR", "Frank", 72000),
                new Employee(1, "IT", "Alice", 90001),
                new Employee(2, "IT", "Bob", 85001),
                new Employee(3, "IT", "Charlie", 96000),
                new Employee(4, "HR", "David", 70001),
                new Employee(5, "HR", "Eve", 75001),
                new Employee(6, "HR", "Frank", 72001)
        );

        Map<String, List<Employee>> top3ByDepartment = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.collectingAndThen(Collectors.toList(), list -> {
                            list.sort((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()));
                            return list.stream().limit(3).collect(Collectors.toList());
                        })));

        top3ByDepartment.forEach((department, topEmployees) -> {
            System.out.println("Department: " + department);
            topEmployees.forEach(employee ->
                System.out.println("Name: " + employee.getName() + ", Salary: " + employee.getSalary()));
            System.out.println();
        });


    }
}
