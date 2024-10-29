package csc8011;

// Imported DecimalFormat class from java.text package to return average value of all the books to two decimal places//
import java.text.DecimalFormat;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class BookStoreWindowIO {
    private static BookStoreWindow theStore = new BookStoreWindow();
    private static boolean readFiles = false;

    //Method representing the menu to be printed to console with options
    private static void printMenu() {
        System.out.println("1: Enter name of book store\n2: Read in CSV file\n3: Print summary\n4: Print statistics\n5: Type Q to quit");
    }

    //Main method for selecting options
    public static void main(String[] args) {
        boolean done = false;
        Scanner input = new Scanner(System.in);
        String response;
        while (!done) {
            printMenu();
            System.out.println("Enter an option: ");
            response = input.nextLine();

            switch (response) {
                case "1":
                    System.out.println("Enter book store name");
                    String answer = input.nextLine();
                    theStore.setBookStoreName(answer);
                    break;
                case "2":
                    readInFile();
                    break;
                case "3":
                    printSummary();
                    break;
                case "4":
                    printStatistics();
                    break;
                case "Q":
                    done = true;
                    break;
                default:
                    //error handling message if the user does not enter valid options(1,2,3,4 or Q)
                    System.out.println("Please enter a valid option");
                    break;
            }
        }
    }

    //Method representing to read book from .csv file
    private static void readInFile() {
        if (readFiles != true) {
            try {
                File input = new File("books.csv");
                Scanner line = new Scanner(input);
                line.nextLine();
                while (line.hasNext()) {
                    String[] split = line.nextLine().split(",");
                    Book bk = new Book(split[0], split[1], Integer.parseInt(split[2]), Double.parseDouble(split[3]));
                    theStore.addBookToWindow(bk);
                }
                readFiles = true;
            } catch (FileNotFoundException e) {
                //error handling message to be printed if .csv file is not found
                System.out.println("File not found");
            }
        } else {
            //error handling message if the user enters option 2 again//
            System.out.println("CSV File has already been read.");
        }
    }

    //Method representing the summary//
    private static void printSummary() {
        if (readFiles == true) {
            System.out.println("Book shop name: " + theStore.getBookStoreName());
            for (Book bk : theStore.getBookListItems()) {
                System.out.println("Book Id: " + bk.getId() + ", Title: " + bk.getTitle() + ", Year published: " + bk.getYearOfPublish() + ", Value: £" + bk.getValueInPounds());
            }
        } else {
            //error handling message if the user has skipped to option 3 before selecting previous options in the output
            System.out.println("Please select previous option to continue");
        }
    }

    //Method representing the statistics
    private static void printStatistics() {
        if (readFiles == true) {
            Book bkMaxValue = theStore.findBookWithHighestValue();
            System.out.println("The statistics on highest value, oldest book, and average value of the books:");
            System.out.println("Highest value book: " + bkMaxValue.getTitle() + " (published " + bkMaxValue.getYearOfPublish() + ")," + " £" + bkMaxValue.getValueInPounds());
            Book bkOldestYear = theStore.findBookWithOldestYear();
            System.out.println("Oldest book: " + bkOldestYear.getTitle() + " (published " + bkOldestYear.getYearOfPublish() + ")");
            double bkAverageValue = theStore.findAverageValueAllBooks();
            DecimalFormat df = new DecimalFormat("0.00");
            String averageValue = df.format(bkAverageValue);
            System.out.println("Average value of books: £" + averageValue);
        } else {
            //error handling message if the user has skipped to option 4 before selecting previous options in the output
            System.out.println("Please select previous option to continue");
        }
    }
}


