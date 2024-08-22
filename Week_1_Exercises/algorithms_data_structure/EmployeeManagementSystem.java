import java.util.Arrays;

public class EmployeeManagementSystem {


    static class Employee {
        private String employeeId;
        private String name;
        private String position;
        private double salary;

        public Employee(String employeeId, String name, String position, double salary) {
            this.employeeId = employeeId;
            this.name = name;
            this.position = position;
            this.salary = salary;
        }


        public String getEmployeeId() {
            return employeeId;
        }

        public void setEmployeeId(String employeeId) {
            this.employeeId = employeeId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }

        public double getSalary() {
            return salary;
        }

        public void setSalary(double salary) {
            this.salary = salary;
        }

        @Override
        public String toString() {
            return "Employee ID: " + employeeId + ", Name: " + name + ", Position: " + position + ", Salary: " + salary;
        }
    }

        private Employee[] employees;
    private int size;
    private static final int INITIAL_CAPACITY = 10;

    public EmployeeManagementSystem() {
        employees = new Employee[INITIAL_CAPACITY];
        size = 0;
    }

        public void addEmployee(Employee employee) {
        if (size == employees.length) {
            resizeArray();
        }
        employees[size++] = employee;
    }

       public Employee searchEmployeeById(String employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId().equals(employeeId)) {
                return employees[i];
            }
        }
        return null; // Not found
    }

        public void traverseEmployees() {
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
    }

        public boolean deleteEmployeeById(String employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId().equals(employeeId)) {
                for (int j = i; j < size - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[--size] = null; // Clear the last element
                return true;
            }
        }
        return false; 
    }

        private void resizeArray() {
        int newCapacity = employees.length * 2;
        employees = Arrays.copyOf(employees, newCapacity);
    }

    public static void main(String[] args) {
        EmployeeManagementSystem ems = new EmployeeManagementSystem();

        ems.addEmployee(new Employee("E001", "Alice Smith", "Manager", 75000));
        ems.addEmployee(new Employee("E002", "Bob Johnson", "Developer", 50000));
        ems.addEmployee(new Employee("E003", "Charlie Brown", "Designer", 55000));

       
        System.out.println("All Employees:");
        ems.traverseEmployees();

      
        System.out.println("\nSearch Result:");
        Employee searchResult = ems.searchEmployeeById("E002");
        if (searchResult != null) {
            System.out.println("Found: " + searchResult);
        } else {
            System.out.println("Employee not found.");
        }

        
        System.out.println("\nDeleting Employee E002:");
        boolean deleted = ems.deleteEmployeeById("E002");
        if (deleted) {
            System.out.println("Employee E002 deleted.");
        } else {
            System.out.println("Employee E002 not found.");
        }

   
        System.out.println("\nAll Employees After Deletion:");
        ems.traverseEmployees();
    }
}