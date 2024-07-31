import java.util.Arrays;

public class BinarySearchAlgorithm {
    public static Product binarySearch(Product[] products, String productId) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            Product midProduct = products[mid];

            int check = midProduct.getProductId().compareTo(productId);

            if (check == 0)
                return midProduct; 
            else if (check < 0)
                left = mid + 1;
            else 
                right = mid - 1;
        }
        return null; 
    }
    
    public static void sortProductsById(Product[] products) {
        Arrays.sort(products, (p1, p2) -> p1.getProductId().compareTo(p2.getProductId()));
    }
}

