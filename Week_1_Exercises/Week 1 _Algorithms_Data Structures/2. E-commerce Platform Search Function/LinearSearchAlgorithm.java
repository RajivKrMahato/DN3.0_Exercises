public class LinearSearchAlgorithm {
    public static Product linearSearch(Product[] products, String productId) {
         for (Product product : products) {
             if (product.getProductId().equals(productId))
                 return product;
        }
         return null; 
     }
 }
 
