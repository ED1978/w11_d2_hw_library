import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class BorrowerTest {

    private Borrower borrower;
    private Library library;
    private Book book1;
    private Book book2;
    private Book book3;
    private Book book4;
    private Book book5;
    private Book book6;
    private ArrayList<Book> books1;
    private ArrayList<Book> books2;
    private HashMap<String, Integer> genreAmounts;

    @Before
    public void before() {
        books1 = new ArrayList<Book>();
        books2 = new ArrayList<Book>();
        genreAmounts = new HashMap<String, Integer>();
        genreAmounts.put("Drama", 2);
        genreAmounts.put("Surreal", 1);
        genreAmounts.put("Physics", 1);
        book1 = new Book("The Grapes of Wrath", "John Steinbeck", "Drama");
        book2 = new Book("Fear & Loathing in Las Vegas", "Hunter S. Thomson", "Surreal");
        book3 = new Book("The Grand Design", "Stephen Hawking", "Physics");
        book4 = new Book("The Wasp Factory", "Ian Banks", "Drama");
        book5 = new Book("Zen & the Art of Motorcycle Maintenance", "Robert Pirsig", "Philosophy");
        book6 = new Book("Delia's Vegetarian Selection ", "Delia Smith", "Cookery");
        books1.add(book1);
        books2.add(book2);
        books2.add(book3);
        books2.add(book4);
        borrower = new Borrower(books1);
        library = new Library(books2, genreAmounts);
    }

    @Test
    public void hasBooks() {
        assertEquals(1, borrower.bookCount());
    }

    @Test
    public void canBorrowBookFromLibrary() {
        borrower.borrowBookFromLibrary(library);
        assertEquals(2, borrower.bookCount());
    }
}
