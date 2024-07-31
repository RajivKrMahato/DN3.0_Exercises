import java.util.Arrays;
import java.util.Comparator;
        public class BinarySearch_Books{

    public static Book binarySearchByTitle(Book[] books, String title) {
            int left = 0;
            int right = books.length - 1;
            while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = books[mid].getTitle().compareToIgnoreCase(title);

            if (comparison == 0) 
                return books[mid]; 
            else if (comparison < 0) 
                left = mid + 1; 
            else 
                right = mid - 1; 
        }
        return null; 
    }

    public static void sortBooksByTitle(Book[] books) {
        Arrays.sort(books, Comparator.comparing(Book::getTitle, String.CASE_INSENSITIVE_ORDER));
    }
}

