import java.util.ArrayList;

public class Borrower {

    private ArrayList<Book> books;

    public Borrower(ArrayList<Book> books){
        this.books = books;
    }

    public int bookCount(){
        return this.books.size();
    }

    public void borrowBookFromLibrary(Library library){
        Book book = library.removeBook();
        this.books.add(book);
    }

}
