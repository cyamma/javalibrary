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
public class Book
{
    // instance variables - replace the example below with your own
    private String name;
    private String author;
    private String category;

    /**
    * Sets the default constructor of the Book class.
    * Sets name, author and category as an empty String.
    */
    public Book()
    {
        name = "";
        author = "";
        category = "";
    }

    /**
    * Non-default constructor, sets the name of the book, age and ID of the person.
    * name, age and ID are taken in as a parameter. 
    */  
    public Book(String bookName, String bookAuthor, String bookCategory)
    {
        name = bookName;
        author = bookAuthor;
        category = bookCategory;
    }
    
    /**
     * Get method to return the book's name
     */
    public String getBookName()
    {
        return name; // returns the name of the book
    }

    /**
     * Get method to return the borrower's name
     */
    public String getBookAuthor()
    {
        return author; // returns the author of the book
        
    }

    /**
     * Get method to return the category of the book
     */
    public String getBookCategory()
    {
        return category; // returns the rating of the book
    }
    
    /**
     * Get method store each of the variables,name, author and category are stored and return as String()
     */
    
    public String bookDetail()
    {
        // concatinating the book detail
        String bookInformation = name + " " + author + " " + category;
        return bookInformation;
    }
    
     /**
     * Get method store each of the variables,name, author and category are stored and return as String()
     */
    public String bookDetail2()
    {
        String bookInformation = name + "," + author + "," + category;
        return bookInformation;
    }
}
