import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class LibraryTest {

    private Library library;
    private Book book1;
    private Book book2;
    private Book book3;
    private Book book4;
    private Book book5;
    private Book book6;
    private ArrayList<Book> books;
    private HashMap<String, Integer> genreAmounts;

    @Before
    public void before() {
        books = new ArrayList<Book>();
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
        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        library = new Library(books, genreAmounts);
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

    @Test
    public void canGetCapacity() {
        assertEquals(5, library.getCapacity());
    }

    @Test
    public void hasEnoughCapacityTrue() {
        assertEquals(true, library.hasEnoughCapacity());
    }

    @Test
    public void hasEnoughCapacityFalse() {
        library.addBook(book5);
        assertEquals(false, library.hasEnoughCapacity());
    }

    @Test
    public void addBookIfEnoughCapacity() {
        library.addBook(book5);
        assertEquals(5, library.bookCount());
    }

    @Test
    public void addBookNotEnoughCapacity() {
        library.addBook(book5);
        library.addBook(book6);
        assertEquals(5, library.bookCount());
    }

    @Test
    public void canRemoveBook() {
        library.removeBook();
        assertEquals(3, library.bookCount());
    }

    @Test
    public void canFindNumberOfBooksByGenre() {
        assertEquals(2, library.findNumberOfBooksByGenre("Drama"));
    }
}
