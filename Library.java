import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.io.File;
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
public class Library
{
    private BorrowerList borrowerList;
    private Booklist listBook;
    private ArrayList<String> textFields;
    
    /**
    * Sets the default constructor of the Library class.
    * sets new BorrowerList, Booklist and textFields
    */
    public Library()
    {
        borrowerList = new BorrowerList();
        textFields = new ArrayList<String>();
        listBook = new Booklist();
    }
    
    /**
     * Method to check for various of condition while user borrowing the book. Checks
     * the rating and correspond that to the borrower age, checks if same book is getting borrowed twice,
     * and preventing user from borrowing more than 2 books. Then add books if all conditions are met.
     * @param borrowerIndex, bookChosen      set borrowerIndex as index and set bookChosen as bookChosen
     */
    private void addBorrowerBook(int borrowerIndex, int bookChosen)
    {
        if (listBorrower().get(borrowerIndex).getAge() < 18 && bookCollection().get(bookChosen).getBookCategory().toString().equals("Adult")) // checks if borrower old enough
            System.out.println("This book is for Adult, over 18 only, borrower another book");
        else if (listBorrower().get(borrowerIndex).getBorrowedBook().contains(bookCollection().get(bookChosen))) // checks if borrower boring same book twice
            System.out.println("You already have this book");
        else if (listBorrower().get(borrowerIndex).getBorrowedBook().size() >= 2) // checks if borrower has two books
            System.out.println("Please return a book first, maximum number of books had exceeded");
        else
            addBooks(borrowerIndex, bookChosen); // adds the book to the user using the book index and the borrower's index
    }
    
    /**
     * Method to list the books that is borrowed by the specified borrower.
     * Takes in index of the borrower and the book as parameters
     * @param getIndexBorrower, getIndexBook      set getIndexBorrower as index and set getIndexBook as getIndexBook
     */
    private void addBooks(int getIndexBorrower, int getIndexBook)
    {
        listBorrower().get(getIndexBorrower).setBorrowerBook(bookCollection().get(getIndexBook)); // add book to the borrower according to their index and book index
    }
    
    /**
     * Method that returns the ArrayList of
     * the booklist class
     */
    private ArrayList<Book> bookCollection()
    {
        return listBook.getBookList();
    }
    
    /**
     * Method that returns the ArrayList of
     * the borrowerList class
     */
    private ArrayList<Borrower> listBorrower()
    {
        return borrowerList.getBorrowerList();
    }
    
    /**
     * Method that prints the available book in the library
     */
    private void bookList()
    {
        listBook.printAllBook();
    }
    
    /**
     * Method that removes the books. Checks to ensure
     * user are entering the index of the book in the specified.
     * Also ensure that input entered are of type Integer not a String
     * or contain any characters. Removes the book based on the user by 
     * using their ArrayList index
     * @param index      set index as the index of the ArrayList of the borrower
     */
    private int bookRemove(int index)
    {
        int bookRemove = 0;
        do
        {
            System.out.print("Choose a number to remove the book: ");
            try
            {
                bookRemove = integerScanner();
                if (bookRemove > listBorrower().get(index).getBorrowedBook().size() || bookRemove <= 0) 
                {
                    System.out.println("Please enter the number shown that corresponds to the book you would like to return: ");
                }
            }
            catch (InputMismatchException error)
            {
                System.out.println("You must enter the number shown above that corresponds to the book you would like to return: ");
            }
        } 
        while (bookRemove > listBorrower().get(index).getBorrowedBook().size() || bookRemove <= 0);
        return bookRemove;
    }
    
    /**
     * Method to print out the main menu for the library
     */
    private void displayMainMenu()
    {
        System.out.println("Welcome to the Jeno's Library");
        System.out.println("=============================");
        System.out.println("(1) Register New Borrower");
        System.out.println("(2) Manage Borrower");
        System.out.println("(3) List All Borrowers");
        System.out.println("(4) Display Help");
        System.out.println("(5) Exit Library");
    }
    
    /**
     * Method that produces random generated number for the ID
     * Number is between 1 and 100
     * Number are generated everytime if it matches any of the previous ID
     */
    private int getGeneratedID()
    {
        int generateID = (int)(Math.random()*(100) + 1); // generates number between 1 and 100
        for (int i = 0; i < listBorrower().size(); i++) // checks if any ID exists
        {
            if (generateID == listBorrower().get(i).getID())
            {
                generateID = (int)(Math.random()*(100) + 1);
            } else
            return generateID;
        }
        return generateID; // returns the ID as int
    }
    
    /**
     * Method that returns the borrowerList ArrayList index
     * that corresponds to the inputed ID
     * @param ID      set ID as userInputID
     */
    private int getBorrowerIndex(int ID)
    {
        System.out.println("Enter borrowers name: ");
        int userInputID = ID; // sets userInputId as ID entered in the parameter
         for(int i = 0; i < listBorrower().size(); i++)
        {
            if (listBorrower().get(i).getID() == ID) // checks if ID input exists in the borrower's ArrayList
                return i; // return the ArrayList index corresponding to the ID
        }
        return -1; // return -1 if no corresponding ID was found
    }
    
    private void help()
    {
        System.out.println("These are the instructions to the library system!");
        System.out.println("The purpose of the library is to allow borrowers to borrow");
        System.out.println("or return ebooks. These ebooks consist of both have a rating of");
        System.out.println("either Children or Adult, whereby only those who are 18+ are allowed");
        System.out.println("to borrow Adult book. The borrower can only borrow up to a maximum of 2");
        System.out.println("books at a time, and of course the borrower cannot borrow the same book.");
        System.out.println("");
        System.out.println("The library allows the user to create new borrower, in which a random");
        System.out.println("generated number between 1 and 100 would be created. The user can then");
        System.out.println("choose an option to manage a borrow and enter either the intended");
        System.out.println("borrower full name or part of their name to search for their unique ID.");
        System.out.println("The ID will be used to uniquely identify the borrower, where a list");
        System.out.println("of book is presented, allowing the borrower to choose thier book by entering");
        System.out.println("a number. The borrower can remove their book by selecting the return");
        System.out.println("option.");
        System.out.println("");
        System.out.println("The user of the program can also produce a report of all the borrowers");
        System.out.println("and their borrowed books.");
        System.out.println("");
        System.out.println("Hope you enjoy this ebook library, happy reading!");
    }
    
    /**
     * Method to create new scanner of type int
     */
    private int integerScanner()
    {
        Scanner sc = new Scanner(System.in); // define new scanner
        int userInput = sc.nextInt(); // scanner is of type int
        return userInput;
    }
    
    /**
     * Method to load the borrower file and book file
     * Also load in the main menu
     */
    public void loadlibrary()
    {
        readBorrower();
        readBook();
        loadMenu();
    }
    
    /**
     * Method to allow user view the main menu
     * and allow user to input one of the five options.
     * Option 1 creates new borrower, option 2 checkes if any borrower exists
     * by checking the length of the borrower ArrayList then loads sub-menu
     */
    private void loadMenu()
    {
        int userInput = 0;
        do
        {
            displayMainMenu(); // calls the main menu method to display the menu of the library
            userInput = validateUserInputMain(1, 5); // calls method that passes on scanner and only allows user to enter input in ranges of 1-5
            switch(userInput) // the input from the user is the expression
            {
                case 1:
                    newBorrower(); // calls method to create new borrower
                break;
                case 2:
                    if(listBorrower().size() > 0) // checkes if any borrowers exist
                    {
                        loadSubMenu(); // loads sub menu
                    } else
                        System.out.println("There are no borrowers to select from");
                break;
                case 3:
                    showReport();
                break;
                case 4:
                    help();
                break;
                case 5:
                    System.out.println("");
                break;
            }
        } 
        while (userInput != 5); // exits the loop if the user's input is 5
        writeToFile(); // writes the records to a file
        System.exit(0); // exits the library, deletes the class's object
    }
    
    /**
     * Method to allow user view the sub menu
     * and allow user to input one of the four options.
     * Requests for borrower to be selected by searching, lists all borrowers
     * related to the search, locates their corresponding ArrayList index.
     * Option 1 checks if any book exists in the library then allow user to
     * select their book. Option 2 removes the book from the user and
     * option 3 allows the viewing of the borrowed book.
     */
    private void loadSubMenu()
    {
        int userInput = 0; // sets default variable for userInput as 0
        String inputedName = validateName(); // calls validation method when user search borrower name 
        printSearchedUser(inputedName); // displays list of all the borrower that contains the inputedName
        int indexScanner = validateIndexInput(); // calls validation method to store the user inputed ID
        int index = getBorrowerIndex(indexScanner); // converts ID into the index of the ArrayList of the Borrower that correspond to the ID inputed
        if (index == -1) // if the ID inputed does not match any of the borrower's ID
        {
            System.out.println("Wrong ID, enter process again");
            loadMenu(); // exits out of the sub-menu if ID entered does not match any corresponding ID
        }
        else 
        {
            System.out.println("Borrower: " + listBorrower().get(index).getName() + " selected"); // if ID matches, display the selected user name
            do
            {
                subMainMenu(); // load sub-menu information 
                userInput = validateUserInputMain(1, 4); // performs validation to make sure user input is only between 1 and 4
                switch(userInput)
                {
                    case 1:
                        if (listBook.getBookList().size() > 0) // checks to see if any book exists
                        {
                            bookList(); // display the list of books
                            int bookChosen = validateBook() - 1; // choosing the index that correspond to the book
                            addBorrowerBook(index, bookChosen); // add in the chosen book index to the corresponding index searched from the ID
                        }
                        else
                            System.out.println("There are no books to select from"); // display this message if no books exist in the library
                    break;
                    case 2:
                        if (listBorrower().get(index).getBorrowedBook().size() > 0) // checks to see if borrower has any books
                        {
                            listBorrower().get(index).booksBorrowed(); // display the books borrowed by the specific borrower
                            int bookRemove = bookRemove(index) - 1; // select which book to remove
                            listBorrower().get(index).getBorrowedBook().remove(bookRemove); // remove book based on the book index and borrower index
                        }
                        else
                            System.out.println("There are no books to remove based on this selected borrower"); // display this if borrower has no books
                    break;
    
                    case 3:
                        listBorrower().get(index).booksBorrowed(); // list all the books borrowed by borrower
                    break;
    
                    case 4:
                    break;
                }
            } 
            while (userInput !=4);
        }
    }
    
    /**
     * Method that creates new borrower based upon
     * the values that the user inputs using the Scannner
     * Generates random ID from 1-100 for the user
     */
    private void newBorrower()
    {
        String name = validateName(); // prompts borrower to enter name, validates that its appropriatness
        int age = validateAge(); // prompts borrower to enter age between 6 and 110
        int id = getGeneratedID(); // generates random ID between 1 and 100
        System.out.println("Your Identification Number is: " + id); // presents the ID generated
        System.out.println("");
        borrowerList.setBorrower(new Borrower(name, age, id)); // creates new borrower based on the information
    }

    /**
     * Method that prints the list of borrowers and their
     * ID based upon the search made by the user
     * @param input      set input as input
     */
    private void printSearchedUser(String input)
    {
        for (int i = 0; i < listBorrower().size(); i++) // iterates over all object in the borrower's ArrayList
            {
                if (listBorrower().get(i).getName().toLowerCase().contains(input.toLowerCase())) // checks if what the user inputed exists partly in the ArrayList
                    System.out.println("ID: " + listBorrower().get(i).getID() + ", Name: " + listBorrower().get(i).getName()); // prints the existing information
            }
    }
    
    /**
     * Method that reads each books into the library and stores them in the bookList class
     */
    private void readBook()
    {
        String filename = ("book.txt"); // read in the text file
        try
        {
            FileReader inputFile = new FileReader(filename);
            Scanner parser = new Scanner(inputFile);
            String file = parser.next();
            while (parser.hasNextLine())
            {
                file = parser.nextLine();
                String[] textFields = file.split(",");
                String bookName = textFields[0];
                String bookAuthor = textFields[1];
                String bookRating = textFields[2];
                listBook.setBook(new Book(bookName, bookAuthor, bookRating));
            }
            inputFile.close();
        }
        catch (FileNotFoundException exception)
        {
            System.out.println(filename + " not found");
        }
        catch (IOException exception)
        {
            System.out.println("Unexpected I/O error occured");
        }
    }
    
    /**
     * Method that reads borrowers and their borrowed books, if any
     * from a text file and store it into objects.
     */
    private void readBorrower()
    {
        String filename = ("borrowers.txt"); // file name
        try
        {
            FileReader inputFile = new FileReader(filename); // define new file reader
            Scanner parser = new Scanner(inputFile);
            while (parser.hasNextLine()) // reads each line
            {
                //file = parser.nextLine();
                String file = parser.nextLine();
                String textFields[] = file.split(","); // splits the text via comma
                String borrowerName = textFields[0]; // stores the first String in the file as borrowerName
                String id = textFields[1];
                String age = textFields[2];
                int borrowerId = Integer.parseInt(id);
                int borrowerAge = Integer.parseInt(age);
                Borrower b1 = new Borrower(borrowerName, borrowerAge, borrowerId);
                if (textFields.length == 6) // if the file contains 5 String per line, that borrower has one book
                {
                    String book1Name = textFields[3];
                    String book1Author = textFields[4];
                    String book1Rating = textFields[5];
                    Book bk1 = new Book(book1Name, book1Author, book1Rating); // create new borrower
                    b1.setBorrowerBook(bk1); // create new book, assign that book to the new borrower
                    borrowerList.setBorrower(b1);
                }
                else if (textFields.length == 9) // if the file contains 9 String per line, that borrower has two books
                {
                    String book1Name = textFields[3];
                    String book1Author = textFields[4];
                    String book1Rating = textFields[5];
                    String book2Name = textFields[6];
                    String book2Author = textFields[7];
                    String book2Rating = textFields[8];
                    Book bk1 = new Book(book2Name, book2Author, book2Rating);
                    Book bk2 = new Book(book1Name, book1Author, book1Rating);
                    b1.setBorrowerBook(bk1);
                    b1.setBorrowerBook(bk2);
                    borrowerList.setBorrower(b1);
                }
                else
                    borrowerList.getBorrowerList().add(b1);
            }
            inputFile.close();
        }
        catch (FileNotFoundException exception)
        {
            System.out.println(filename + " not found"); // throw this erorr if file isn't found
        }
        catch (IOException exception)
        {
            System.out.println("Unexpected I/O error occured"); // catch this error if above error occurs again
        }
    }
    
    /**
     * Method the print the user detail and their corresponding books borrowed if any
     */
    private void showReport()
    {
        for(int i = 0; i < borrowerList.getBorrowerList().size(); i++) // check all borrowers
        {
            System.out.println("");
            System.out.println("Name: " + listBorrower().get(i).getName()); // print their name
            System.out.println(("Age: " + listBorrower().get(i).getAge()));
            System.out.println(("ID: " + listBorrower().get(i).getID()));
            System.out.println(("Books Borrowered:"));
            listBorrower().get(i).booksBorrowed(); // print the books detail
        }
    }

    /**
     * Method to create new scanner of type String
     */
    private String stringScanner()
    {
        Scanner sc = new Scanner(System.in);
        String userInput = sc.nextLine().trim();
        return userInput;
    }
    
    /**
     * Method to print out the sub menu for the library
     */
    private void subMainMenu()
    {
        System.out.println("(1) Borrow a Book");
        System.out.println("(2) Return a Book");
        System.out.println("(3) List Borrowed Books");
        System.out.println("(4) Return to Main Menu");   
    }
    
    private void testAddBooks()
    {
        String bookName = validateName();
        String bookAuthor = validateName();
        String bookCategory = validateName();
        listBook.setBook(new Book(bookName, bookAuthor, bookCategory));
    }
    
    /**
     * Method that performs validation on the
     * age. Ensures user enters age between 5 and 110
     * Ensures the age inputed is strictly of type integer
     * and no Strings or character can be passed
     */
    private int validateAge()
    {
        int age = 0; // default age as 0
        do
        {
            System.out.print("Please enter your age: ");
            try
            {
                age = integerScanner(); // calls the integer Scanner
                if (age < 6 || age > 111) // age is between 5 and 110
                {
                    System.out.println("Please enter a sensible age.");
                }
            }
            catch (InputMismatchException error) // display error if user enters character or String
            {
                System.out.println("You must enter a number: ");
            }
        } 
        while (age < 6 || age > 111);
        return age; // returns the age
    }
    
    /**
     * Method that validates the borrower input when choosing 
     * the index in which they wish to borrow the book
     * Method displays error if index of book chosen does not exist or if
     * user enteres non Int type such as Strig or character.
     */
    private int validateBook()
    {
        int bookChosen = 0;
        do
        {
            System.out.print("Choose a number to borrow the book: ");
            try
            {
                bookChosen = integerScanner();
                if (bookChosen > listBook.getBookList().size() || bookChosen <= 0) // input range is between size of the ArrayList of the book and 1
                {
                    System.out.println("Please enter the number corresponding to the books listed: ");
                }
            }
            catch (InputMismatchException error) // if user enters a String or Char as oppose to int
            {
                System.out.println("You must enter a number: ");
            }
        } 
        while (bookChosen > listBook.getBookList().size() || bookChosen <= 0);
        return bookChosen;
    }

    /**
     * Method that performs validation on the
     * ID. Ensures user enters ID between 1 and 100
     * Ensures the ID inputed is strictly of type integer
     * and no Strings or character can be passed
     */
    private int validateIndexInput()
    {
        int userId = 0;
        do
        {
            System.out.print("Please enter the ID: ");
            try
            {
                userId = integerScanner();
                if (userId < 1 || userId > 100) // range between 1 and 100
                {
                    System.out.println("Enter the ID that corresponds to the registered borrowers");
                }
            }
            catch (InputMismatchException error)
            {
                System.out.println("You must enter a number: ");
            }
        } 
        while (userId < 1 || userId > 100);
        return userId;
    }
    
    /**
     * Method that performs validation on the
     * user input for seleting the case in menu 
     * Ensures user enters option between 1 and 4 or 1 and 5
     * Ensures the option inputed is strictly of type integer
     * and no Strings or character can be passed
     * @param lowerRange, higherRange      set lowest option entered as lowerRange and set highest option entered as higherRange
     */
    private int validateUserInputMain(int lowerRange, int higherRange)
    {
        int userInput = 0;
        do
        {
            System.out.print("Please enter your option: ");
            try
            {
                userInput = integerScanner();
                if (userInput < lowerRange || userInput > higherRange) // range is between the inputed lower range and inputed higher range
                {
                    System.out.println("Please select the specified options between " + lowerRange + " and " + higherRange + ", ");
                }
            }
            catch (InputMismatchException error)
            {
                System.out.println("You must enter a number: ");
            }
        } 
        while (userInput < lowerRange || userInput > higherRange);
        return userInput;
    }
    
    /**
     * Method that checks if the name entered does not contains any number
     * if number are presented, error message is shown.
     */
    private String validateName()
    {
        String name = "";
        do
        {
            System.out.print("Please enter name: ");
            try
            {
                name = stringScanner().trim();
                if (name.matches(".*\\d.*")) // checks if String contains any digit
                {
                    System.out.print("Name should not contain any number, ");
                }
            }
            catch (InputMismatchException error)
            {
                System.out.println("Mismatch found, try again");
            }
        } while (name.matches(".*\\d.*"));
        return name;
    }
    
    /**
     * Method that writes the data into file
     */
    private void writeToFile()
    {
        File file = new File("newBorrower.txt"); // name of text being outputed
        
        PrintWriter printWriter = null;
        try 
        {
            printWriter = new PrintWriter(file); // defining new print writer
            for(int i = 0; i < borrowerList.getBorrowerList().size(); i++)
            {
                if (listBorrower().get(i).getBorrowedBook().size() == 1)
                    // print this text onto the file
                    printWriter.println(listBorrower().get(i).borrowerDetail() + "," + listBorrower().get(i).getBorrowedBook().get(0).bookDetail2()); 
                else if(listBorrower().get(i).getBorrowedBook().size() == 2)
                    printWriter.println(listBorrower().get(i).borrowerDetail() + "," + listBorrower().get(i).getBorrowedBook().get(0).bookDetail2() + "," 
                    + listBorrower().get(i).getBorrowedBook().get(1).bookDetail2());
                else
                    printWriter.println(listBorrower().get(i).borrowerDetail());
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found"); 
        }
        finally
        {
            if (printWriter != null)
                printWriter.close();
        }
    }
}