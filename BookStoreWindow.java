package csc8011;


import java.util.ArrayList;

public class BookStoreWindow {
    private String bookStoreName;
    private ArrayList<Book> bookListItems;


    public BookStoreWindow(String bookStoreName) {
        this.bookStoreName = bookStoreName;
    }

    //Set method to set the name of the book store
    public void setBookStoreName(String bookStoreName) {
        this.bookStoreName = bookStoreName;
    }

    //Get method to return the book store name
    public String getBookStoreName() {
        return bookStoreName;
    }


    public BookStoreWindow() {
        bookListItems = new ArrayList<>();
    }

    //Method to store books to list of book items
    public void addBookToWindow(Book bk) {
        bookListItems.add(bk);
    }

    //Get method to return a list of all books displayed on window
    public ArrayList<Book> getBookListItems() {
        return bookListItems;
    }

    //Method to find book with the highest value
    public Book findBookWithHighestValue() {
        Book max = bookListItems.get(0);
        for (Book bookItem : bookListItems) {
            //for each loop to iterate through each book item until the highest valued book is reached
            if(bookItem.getValueInPounds() > max.getValueInPounds()){
                max = bookItem;
            }
        }
        return max;
    }

    //Method to find the oldest book
    public Book findBookWithOldestYear() {
        Book eldest = bookListItems.get(0);
        for (Book bookItem : bookListItems) {
            //for each loop to iterate through each book item until the oldest book is reached
            if(bookItem.getYearOfPublish() < eldest.getYearOfPublish()){
                eldest = bookItem;
            }
        }
        return eldest;
    }

    //Method to find average value of all books
    public double findAverageValueAllBooks() {
        double totalSumValue = 0.0;
        for (Book bookItems : bookListItems) {
            totalSumValue += bookItems.getValueInPounds();
        }
        return totalSumValue / bookListItems.size();
    }
}
