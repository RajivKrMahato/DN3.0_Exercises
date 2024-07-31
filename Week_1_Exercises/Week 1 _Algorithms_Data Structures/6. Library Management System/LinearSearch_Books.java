public class LinearSearch_Books {

    public static Book linearSearchByTitle(Book[] books, String title) 
    {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null; 
    }
}

