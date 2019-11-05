import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class LibraryTest {

    private Library library;
    private Book book1;
    private Book book2;
    private Book book3;
    private Book book4;
    private Book book5;
    private ArrayList<Book> books;

    @Before
    public void before() {
        books = new ArrayList<Book>();
        book1 = new Book("The Grapes of Wrath", "John Steinbeck", "Drama");
        book2 = new Book("Fear & Loathing in Las Vegas", "Hunter S. Thomson", "Surreal");
        book3 = new Book("The Grand Design", "Stephen Hawking", "Physics");
        book4 = new Book("The Wasp Factory", "Ian Banks", "Drama");
        book5 = new Book("Zen & the Art of Motorcycle Maintenance", "Robert Pirsig", "Philosophy");
        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        library = new Library(books);
    }

    @Test
    public void hasBooks() {
        assertEquals(4, library.bookCount());
    }

    @Test
    public void canAddBook() {
        library.addBook(book5);
        assertEquals(5, library.bookCount());
    }
}
