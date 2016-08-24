import java.util.ArrayList;

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
public class Borrower
{
    private String name;
    private int age;
    private int id; 
    private ArrayList<Book> borrowedBook = new ArrayList<Book>();
    
    /**
    * Sets the default constructor of the Borrower class.
    * Sets name to blank, and age and id as default 0
    */
    public Borrower()
    {
        age = 0;
        name = "";
        id = 0;
        borrowedBook = new ArrayList<Book>();
    }
    
    /**
    * Non-default constructor, sets the name, age and ID of the person.
    * name, age and ID are taken in as a parameter. 
    */
    public Borrower(String personName, int personAge, int personId)
    {
        // if(personName.trim().equals(""))
        //     throw new IllegalArgumentException();
        // else
            name = personName;
            
        // if (personAge < 5 || personAge > 100)
        //      throw new IllegalArgumentException();
        // else
            age = personAge;  
        
        // if (personId < 0 || personId > 110)
        //     throw new IllegalArgumentException();
        // else
            id = personId;
    }
    
    /**
     * method to print all of the books borrowed by the borrower
     */
    public void booksBorrowed()
    {
        for (int i = 0; i < borrowedBook.size(); i++) //iterate over all of the arraylist
        {
            System.out.println((i + 1) + ". " + borrowedBook.get(i).bookDetail());
        }
    }
    
    /**
     * get method to access the collection of the borrowed Book
     */    
    public ArrayList<Book> getBorrowedBook()
    {
        return borrowedBook; // get the ArrayList of the borrowed Book linked to Book class
    }
    
    /**
     * Get method to return the age of the borrower's
     */
    public int getAge()
    {
        return age; // returns the age of the borrower
    }
    
    /**
     * Get method to return the borrower's ID
     */
    public int getID()
    {
        return id; // returns the id number
    }
    
    /**
     * Get method to return the borrower's name
     */
    public String getName()
    {
        return name; // returns the borrower's name
    }
    
    /**
     * get method to return the information of the book borrowed
     */
    public String borrowerDetail()
    {
        // concatinate the information as one string
        String borrowerInfo = name + "," + id + "," + age;
        return borrowerInfo;
    }
    
    /**
     * Set method to replace the age inputed as age
     * @param personAge    set input age to age
     */
    public void setAge(int personAge)
    {
        // if (personAge < 5 || personAge > 100)
        //     throw new IllegalArgumentException();
        // else
            age = personAge;
    }
    
    /**
     * Set method to add in the book to the arrayList of the object Book
     * @param book    adds book to ArrayList of Book 
     */
    public void setBorrowerBook(Book book)
    {
        borrowedBook.add(book);
    }
    
    /**
     * Set method to replace the id inputed as id
     * @param personID    set input age to age
     */
    public void setID(int personID)
    {
        // if (personID < 0 || personID > 110)
        //     throw new IllegalArgumentException();
        // else
            id = personID;
    }
    
    /**
     * Set method to replace the name inputed as personName
     * @param personName     set input name as personName
     */
    public void setName(String personName)
    {
        // if(personName.trim().equals(""))
        //     throw new IllegalArgumentException();
        // else
            name = personName;
    }
}
