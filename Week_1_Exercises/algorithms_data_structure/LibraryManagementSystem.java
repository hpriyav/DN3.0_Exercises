import java.util.Arrays;

public class LibraryManagementSystem {

   
    static class Book {
        private String bookId;
        private String title;
        private String author;

        public Book(String bookId, String title, String author) {
            this.bookId = bookId;
            this.title = title;
            this.author = author;
        }

        public String getBookId() {
            return bookId;
        }

        public void setBookId(String bookId) {
            this.bookId = bookId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        @Override
        public String toString() {
            return "Book ID: " + bookId + ", Title: " + title + ", Author: " + author;
        }
    }

    public static Book linearSearch(Book[] books, String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;     }

        public static Book binarySearch(Book[] books, String title) {
        int left = 0;
        int right = books.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = books[mid].getTitle().compareToIgnoreCase(title);

            if (comparison == 0) {
                return books[mid]; // Found
            } else if (comparison < 0) {
                left = mid + 1; // Search in the right half
            } else {
                right = mid - 1; // Search in the left half
            }
        }
        return null; 
    }

    public static void main(String[] args) {
       
        Book[] books = {
            new Book("B001", "A Brief History of Time", "Stephen Hawking"),
            new Book("B002", "The Catcher in the Rye", "J.D. Salinger"),
            new Book("B003", "To Kill a Mockingbird", "Harper Lee"),
            new Book("B004", "1984", "George Orwell"),
            new Book("B005", "Pride and Prejudice", "Jane Austen")
        };


        String searchTitleLinear = "The Catcher in the Rye";
        System.out.println("Linear Search Result:");
        Book foundBookLinear = linearSearch(books, searchTitleLinear);
        if (foundBookLinear != null) {
            System.out.println("Found: " + foundBookLinear);
        } else {
            System.out.println("Book not found.");
        }

        

        String searchTitleBinary = "1984";
        System.out.println("\nBinary Search Result:");
        Book foundBookBinary = binarySearch(books, searchTitleBinary);
        if (foundBookBinary != null) {
            System.out.println("Found: " + foundBookBinary);
        } else {
            System.out.println("Book not found.");
        }
    }
}