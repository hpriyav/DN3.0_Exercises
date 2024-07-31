public class DependencyInjectionExample {

        interface CustomerRepository {
        Customer findCustomerById(int id);
    }

        static class CustomerRepositoryImpl implements CustomerRepository {
        @Override
        public Customer findCustomerById(int id) {
            // Simulate fetching customer from a database
            // For demonstration purposes, returning a mock customer
            if (id == 1) {
                return new Customer(1, "John Doe", "john.doe@example.com");
            } else if (id == 2) {
                return new Customer(2, "Jane Smith", "jane.smith@example.com");
            } else {
                return null; // Customer not found
            }
        }
    }

       static class CustomerService {
        private final CustomerRepository customerRepository;

        // Constructor Injection
        public CustomerService(CustomerRepository customerRepository) {
            this.customerRepository = customerRepository;
        }

        public Customer getCustomerById(int id) {
            return customerRepository.findCustomerById(id);
        }
    }

        static class Customer {
        private final int id;
        private final String name;
        private final String email;

        public Customer(int id, String name, String email) {
            this.id = id;
            this.name = name;
            this.email = email;
        }

        @Override
        public String toString() {
            return "Customer ID: " + id + ", Name: " + name + ", Email: " + email;
        }
    }

  
    public static void main(String[] args) {
       
        CustomerRepository customerRepository = new CustomerRepositoryImpl();
        CustomerService customerService = new CustomerService(customerRepository);

              Customer customer1 = customerService.getCustomerById(1);
        Customer customer2 = customerService.getCustomerById(2);
        Customer customer3 = customerService.getCustomerById(3); 
        System.out.println("Customer 1: " + customer1);
        System.out.println("Customer 2: " + customer2);
        System.out.println("Customer 3: " + customer3); 
    }
}
