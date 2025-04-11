package Com.Learn.CollectionLearn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Employee implements Comparable<Employee>{
    String name;
    int age;

    public Employee(String name,int age){
        this.name=name;
        this.age=age;
    }

    @Override
    public int compareTo(Employee e){
        return this.name.compareTo(e.name);
    }

    @Override
    public String toString(){
        return name + "( "+age+" years)";
    }
}

public class EmployeeSorting {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("John", 25));
        employees.add(new Employee("Alice", 30));
        employees.add(new Employee("Bob", 28));

        // Sorting using Comparable (by name)
        Collections.sort(employees);

        System.out.println("Sorted Employees by Name: " + employees);
    }
}
