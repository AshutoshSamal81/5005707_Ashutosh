import java.util.Arrays;

public class LibraryManagementSystem {

    // Class representing a book
    static class Book {
        private int bookId;
        private String title;
        private String author;

        public Book(int bookId, String title, String author) {
            this.bookId = bookId;
            this.title = title;
            this.author = author;
        }

        public int getBookId() {
            return bookId;
        }

        public String getTitle() {
            return title;
        }

        public String getAuthor() {
            return author;
        }

        @Override
        public String toString() {
            return "BookID: " + bookId + ", Title: " + title + ", Author: " + author;
        }
    }

    // Linear search to find book by title
    public static Book linearSearch(Book[] books, String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null; // Book not found
    }

    // Binary search to find book by title (assuming sorted by title)
    public static Book binarySearch(Book[] books, String title) {
        int low = 0;
        int high = books.length - 1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int result = title.compareToIgnoreCase(books[mid].getTitle());

            if (result == 0) {
                return books[mid];
            }
            if (result < 0) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return null; // Book not found
    }

    public static void main(String[] args) {
        // Setup library with books
        Book[] books = new Book[] {
            new Book(1, "Effective Java", "Joshua Bloch"),
            new Book(2, "Clean Code", "Robert C. Martin"),
            new Book(3, "Design Patterns", "Erich Gamma"),
            new Book(4, "The Pragmatic Programmer", "Andrew Hunt"),
            new Book(5, "Refactoring", "Martin Fowler")
        };

        // Sort books by title for binary search
        Arrays.sort(books, (b1, b2) -> b1.getTitle().compareToIgnoreCase(b2.getTitle()));

        // Test Linear Search
        System.out.println("Linear Search:");
        String searchTitleLinear = "Design Patterns";
        Book foundBookLinear = linearSearch(books, searchTitleLinear);
        if (foundBookLinear != null) {
            System.out.println("Found: " + foundBookLinear);
        } else {
            System.out.println("Book not found.");
        }

        // Test Binary Search
        System.out.println("\nBinary Search:");
        String searchTitleBinary = "Refactoring";
        Book foundBookBinary = binarySearch(books, searchTitleBinary);
        if (foundBookBinary != null) {
            System.out.println("Found: " + foundBookBinary);
        } else {
            System.out.println("Book not found.");
        }
    }
}


/*

 Q1 Explain linear search and binary search algorithms.

 Linear Search:
     Time Complexity: O(n). It requires checking each element one by one, making it less efficient for large datasets.
     Use Case: Ideal for small datasets or when the array is unsorted.

 Binary Search:
     Time Complexity: O(log n). It is much faster than linear search for large datasets, but requires the array to be sorted.
     Use Case: Best for large datasets where the array is sorted or can be sorted.

 In summary, the binary search algorithm provides a significant performance advantage over linear search for large and sorted datasets. 
 However, linear search remains useful for small or unsorted datasets where sorting might not be practical.


 
*/