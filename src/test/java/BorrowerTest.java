import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class BorrowerTest {

    private Borrower borrower;
    private Book book;
    private ArrayList<Book> books;

    @Before
    public void before() {
        books = new ArrayList<Book>();
        book = new Book("The Grapes of Wrath", "John Steinbeck", "Drama");
        books.add(book);
        borrower = new Borrower(books);
    }

    @Test
    public void hasBooks() {
        assertEquals(1, borrower.bookCount());
    }
}
