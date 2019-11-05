import java.util.ArrayList;
import java.util.HashMap;

public class Library {

    private ArrayList<Book> books;
    private int capacity;
    private HashMap<String, Integer> genreAmounts = new HashMap<String, Integer>();
    private int dramaAmount;

    public Library(ArrayList<Book> books, HashMap<String, Integer> genreAmounts){
        this.books = books;
        this.capacity = 5;
        this.genreAmounts = genreAmounts;
        this.dramaAmount = 2;
    }

    public int bookCount(){
        return this.books.size();
    }

    public int getDramaAmount(){
        return this.dramaAmount;
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

    public Book removeBook(){
        return this.books.remove(0);
    }

    public int findNumberOfBooksByGenre(String genre){
        return this.genreAmounts.get(genre);
    }

    public int countGenreAmountInBooks(String genre){
        int genreCount = 0;
        for(Book book : books){
            if(book.genre == genre){
                genreCount += 1;
            }
        }
        return genreCount;
    }


}
