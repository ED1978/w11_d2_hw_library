import java.util.ArrayList;

public class Borrower {

    private ArrayList<Book> books;

    public Borrower(ArrayList<Book> books){
        this.books = books;
    }

    public int bookCount(){
        return this.books.size();
    }

}
