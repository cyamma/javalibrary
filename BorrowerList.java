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
public class BorrowerList
{
    private ArrayList<Borrower> list;
    
    /**
    * Sets the default constructor of the BorrowerList class.
    * Sets defines a new ArrayList of type Borrower
    */public BorrowerList()
    {
        list = new ArrayList<Borrower>();
    }
    
    /**
    * returns the collection of the ArrayList of Borrower
    */
    public ArrayList<Borrower> getBorrowerList()
    {
        return list;
    }
    
    /**
     * get method to return the name of the borrower throught the ArrayList
     */
    public String getBorrowerName(int index)
    {
        return list.get(index).getName(); // ArrayList index is entered in the get()
    }
    
    /**
     * method to print all of the books information in the library
     */
    public void listBorrowers()
    {
        for (int i = 0; i < list.size(); i++) // iterates over all the object arraylist
        {
            System.out.println((i + 1) + ". " + list.get(i).getName()); // print name and assign them to rank
        }
    }
    
    /**
     * set method to add the object of Borrower to the ArralyList of the Book
     */
    public void setBorrower(Borrower borrower)
    {
        list.add(borrower);
    }
}
