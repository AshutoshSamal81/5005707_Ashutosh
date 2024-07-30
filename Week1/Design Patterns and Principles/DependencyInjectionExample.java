// DependencyInjectionExample.java

// Repository Interface
interface CustomerRepository {
    String findCustomerById(int id);
}

// Concrete Repository Implementation
class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public String findCustomerById(int id) {
        // For demonstration, returning a dummy customer
        return "Customer with ID " + id;
    }
}

// Service Class
class CustomerService {
    private final CustomerRepository customerRepository;

    // Constructor Injection
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public String getCustomerDetails(int id) {
        return customerRepository.findCustomerById(id);
    }
}

// Test the Dependency Injection
public class DependencyInjectionExample {
    public static void main(String[] args) {
        // Create a concrete repository implementation
        CustomerRepository customerRepository = new CustomerRepositoryImpl();
        
        // Inject the repository into the service
        CustomerService customerService = new CustomerService(customerRepository);
        
        // Use the service to find a customer
        int customerId = 1;
        String customerDetails = customerService.getCustomerDetails(customerId);
        
        // Display the customer details
        System.out.println(customerDetails);
    }
}
