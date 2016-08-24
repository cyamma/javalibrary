import java.util.*;
/**
 * This library system permits the user to create new borrower or choose from existing 
 * borrower loaded from a file to either borrow new book or return book. The book
 * contains two different ratings, the Children and Adult, only those who have an age of 
 * 18+ are allowed to borrow adult book. Nevertheless, each borrower are only allowed
 * to borrow up to 2 books, and cannot borrow the same book if they already have it.
 * A report can be printed to show all the borrowers and their current book as well
 * as the once the program ends, the program will write the report to a new file.
 * 
 * @author Chaiyaporn Yamma
 * @version 27.05.2016
 */
public class Booklist
{
    private String name;
    private ArrayList<Book> books;
    
    /**
    * Sets the default constructor of the booklist class.
    * Creates new ArrayList for to store the book
    */
    public Booklist()
    {
        books = new ArrayList<Book>();
    }
    
    /**
     * get method to access the author of the book and conveert to String
     */
    public String getAuthorName(int index)
    {
        return getBookList().get(index).getBookAuthor().toString();
    }
    
    /**
     * get method to get the collection of the book
     */
    public ArrayList<Book> getBookList()
    {
        return books;
    }
    
    /**
    * method to print all of the books and their detail
    */
    public String getBook(int index)
    {
        //concatinating the book name, author and rating to a single String
        String book = getBookName(index) + " " + getAuthorName(index) + " " + getBookCategory(index);
        return book;
    }
    
    /**
     * get method to access the rating of the book and conveert to String
     */
    public String getBookCategory(int index)
    {
        // get the rating of the book convert to String
        return getBookList().get(index).getBookCategory().toString();
    }
    
    /**
     * get method to access the name of the book and conveert to String
     */
    public String getBookName(int index)
    {
        return getBookList().get(index).getBookName().toString();
    }
    
    /**
     * method to print all of the books information in the library
     */
    public void printAllBook()
    {
        for(int i = 0; i < getBookList().size(); i ++)
        {
            String text = getBookName(i) + " " + getAuthorName(i) + " " + getBookCategory(i);
            int number = i + 1;
            System.out.println(number + ". " + text);
        }
    }
    
    /**
     * set method to add the object book to the Arraly:ist of the Book
     */
    public void setBook(Book book)
    {
        books.add(book); // add books to book ArrayList
    }
}
