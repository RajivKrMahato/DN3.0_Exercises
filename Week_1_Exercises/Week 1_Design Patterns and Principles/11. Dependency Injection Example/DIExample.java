public class DIExample {
    public static void main(String[] args) {
    
        CustomerRepository repository = new CustomerRepositoryImpl();
        
        CustomerService service = new CustomerService(repository);
        
        String customerName = service.getCustomerName("123");
        System.out.println("Customer Name: " + customerName);
        
        customerName = service.getCustomerName("999");
        System.out.println("Customer Name: " + customerName);
    }
}
