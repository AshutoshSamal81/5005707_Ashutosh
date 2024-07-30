public class EmployeeManagementSystem {

    // Employee class definition
    static class Employee {
        private int employeeId;
        private String name;
        private String position;
        private double salary;

        public Employee(int employeeId, String name, String position, double salary) {
            this.employeeId = employeeId;
            this.name = name;
            this.position = position;
            this.salary = salary;
        }

        public int getEmployeeId() {
            return employeeId;
        }

        public String getName() {
            return name;
        }

        public String getPosition() {
            return position;
        }

        public double getSalary() {
            return salary;
        }

        @Override
        public String toString() {
            return "EmployeeID: " + employeeId + ", Name: " + name + ", Position: " + position + ", Salary: " + salary;
        }
    }

    // Employee Management System
    static class EmployeeManager {
        private Employee[] employees;
        private int size;

        public EmployeeManager(int capacity) {
            employees = new Employee[capacity];
            size = 0;
        }

        // Add employee
        public void addEmployee(Employee employee) {
            if (size < employees.length) {
                employees[size++] = employee;
            } else {
                System.out.println("Employee array is full.");
            }
        }

        // Search employee by ID
        public Employee searchEmployee(int employeeId) {
            for (int i = 0; i < size; i++) {
                if (employees[i].getEmployeeId() == employeeId) {
                    return employees[i];
                }
            }
            return null; // Employee not found
        }

        // Traverse and print all employees
        public void traverseEmployees() {
            if (size == 0) {
                System.out.println("No employees to display.");
                return;
            }
            for (int i = 0; i < size; i++) {
                System.out.println(employees[i]);
            }
        }

        // Delete employee by ID
        public boolean deleteEmployee(int employeeId) {
            for (int i = 0; i < size; i++) {
                if (employees[i].getEmployeeId() == employeeId) {
                    // Shift elements to the left
                    for (int j = i; j < size - 1; j++) {
                        employees[j] = employees[j + 1];
                    }
                    employees[--size] = null; // Remove last element
                    return true;
                }
            }
            return false; // Employee not found
        }
    }

    public static void main(String[] args) {
        // Create EmployeeManager with capacity of 5
        EmployeeManager manager = new EmployeeManager(5);

        // Add employees
        manager.addEmployee(new Employee(1, "Alice", "Developer", 80000));
        manager.addEmployee(new Employee(2, "Bob", "Manager", 90000));
        manager.addEmployee(new Employee(3, "Charlie", "Designer", 75000));

        // Traverse employees
        System.out.println("All Employees:");
        manager.traverseEmployees();

        // Search employee
        System.out.println("\nSearching for employee with ID 2:");
        Employee employee = manager.searchEmployee(2);
        if (employee != null) {
            System.out.println("Found: " + employee);
        } else {
            System.out.println("Employee not found.");
        }

        // Delete employee
        System.out.println("\nDeleting employee with ID 2:");
        if (manager.deleteEmployee(2)) {
            System.out.println("Employee deleted.");
        } else {
            System.out.println("Employee not found.");
        }

        // Traverse employees after deletion
        System.out.println("\nAll Employees after deletion:");
        manager.traverseEmployees();
    }
}
