import java.util.Arrays;
public class EmployeeManagementSystem {
    private Employee[] employees;
    private int size;
    public EmployeeManagementSystem(int capacity) {
        employees = new Employee[capacity];
        size = 0;
    }

    public void addEmployee(Employee employee) {
        if (size < employees.length) {
            employees[size++] = employee;
        } else {
            System.out.println("Employee array is full.");
        }
    }

    public Employee searchEmployee(String employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId().equals(employeeId)) {
                return employees[i];
            }
        }
        return null; 
    }

    public void traverseEmployees() {
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
    }

    public void deleteEmployee(String employeeId) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId().equals(employeeId)) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            for (int i = index; i < size - 1; i++) {
                employees[i] = employees[i + 1];
            }
            employees[size - 1] = null; 
            size--;
        } else {
            System.out.println("Employee with ID " + employeeId + " not found.");
        }
    }

    public static void main(String[] args) 
    {
        EmployeeManagementSystem ems = new EmployeeManagementSystem(20);

        ems.addEmployee(new Employee("E101", "David", "Director", 120000));
        ems.addEmployee(new Employee("E102", "Emma", "Lead Engineer", 95000));
        ems.addEmployee(new Employee("E103", "Fiona", "Consultant", 70000));

        System.out.println("List of all employees:");
        ems.traverseEmployees();

        System.out.println("\nSearching for employee with ID E102:");
        Employee foundEmployee = ems.searchEmployee("E102");
        System.out.println(foundEmployee);

        System.out.println("\nRemoving employee with ID E102:");
        ems.deleteEmployee("E102");

        System.out.println("\nEmployees list after removal:");
        ems.traverseEmployees();
    }
}

