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
    private Book book7;
    private ArrayList<Book> books;
    private HashMap<String, Integer> genreAmounts;

    @Before
    public void before() {
        books = new ArrayList<Book>();
        genreAmounts = new HashMap<String, Integer>();
        genreAmounts.put("Drama", 0);
        genreAmounts.put("Surreal", 0);
        genreAmounts.put("Physics", 0);
        book1 = new Book("The Grapes of Wrath", "John Steinbeck", "Drama");
        book2 = new Book("Fear & Loathing in Las Vegas", "Hunter S. Thomson", "Surreal");
        book3 = new Book("The Grand Design", "Stephen Hawking", "Physics");
        book4 = new Book("The Wasp Factory", "Ian Banks", "Drama");
        book5 = new Book("Zen & the Art of Motorcycle Maintenance", "Robert Pirsig", "Philosophy");
        book6 = new Book("Delia's Vegetarian Selection ", "Delia Smith", "Cookery");
        book7 = new Book("The Adventures of Tom Sawyer ", "Mark Twain", "Drama");
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
        library.removeBook(book1);
        assertEquals(3, library.bookCount());
    }

    @Test
    public void canFindNumberOfBooksByGenre() {
        assertEquals(0, library.findNumberOfBooksByGenre("Drama"));
    }

    @Test
    public void canCountGenreAmountInBooks() {
        assertEquals(2, library.updateHashMapValueWithGenreAmount("Drama"));
    }

    @Test
    public void canUpDateHashMapValue() {
        library.updateHashMapValue("Drama", 3);
        assertEquals(3, library.findNumberOfBooksByGenre("Drama"));
    }

    @Test
    public void canUpDateHashMapValueWithGenreAmount() {
        library.updateHashMapValueWithGenreAmount("Drama");
        assertEquals(2, library.findNumberOfBooksByGenre("Drama"));
    }

    @Test
    public void canUpdateHashMapValueWhenAddingBook() {
        library.addBook((book1));
        library.addBook((book2));
        library.addBook((book3));
        library.addBook((book4));
        library.addBook((book7));
        assertEquals(3, library.findNumberOfBooksByGenre("Drama"));
    }

    @Test
    public void canUpdateHashMapValueWhenRemovingBook() {
        library.addBook((book1));
        library.addBook((book2));
        library.addBook((book3));
        library.addBook((book4));
        library.addBook((book7));
        library.removeBook(book1);
        assertEquals(2, library.findNumberOfBooksByGenre("Drama"));
    }
}
