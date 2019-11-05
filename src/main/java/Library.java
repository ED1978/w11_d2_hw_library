import java.util.ArrayList;

public class Library {

    private ArrayList<Book> books;
    private int capacity;

    public Library(ArrayList<Book> books){
        this.books = books;
        this.capacity = 5;
    }

    public int bookCount(){
        return this.books.size();
    }

    public void addBook(Book book){
        if(hasEnoughCapacity() == true){
            this.books.add(book);
        }
    }

    public int getCapacity(){
        return this.capacity;
    }

    public boolean hasEnoughCapacity(){
        if(bookCount() < this.capacity){
            return true;
        } else {
            return false;
        }
    }


}
