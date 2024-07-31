public class CustomerRepositoryImpl implements CustomerRepository {
    public String findCustomerById(String id) {
      
        if ("123".equals(id)) {
            return "Rajiv Kr Mahato";
        }
        return "Customer not found";
    }
}
