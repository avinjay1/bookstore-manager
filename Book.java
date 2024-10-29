package csc8011;


public class Book {
    //Declaring instance variables
    private String id;
    private String title;
    private int yearOfPublish;
    private double valueInPounds;

    //Constructor method with parameters
     public Book(String id, String title, int yearOfPublish, double valueInPounds) {

         //Instance variables assignment to parameters
        this.id = id;
        this.title = title;
        this.yearOfPublish = yearOfPublish;
        this.valueInPounds = valueInPounds;
    }

    // Get method to retrieve ID, book title, publishing year of book and the book's value in pounds. These methods were not used in this class//
    public String getId() {return id;}
    public String getTitle() {return title;}
    public int getYearOfPublish() {return yearOfPublish;}
    public double getValueInPounds() {return valueInPounds;}

    //toString method to provide a representation of Book ID, title, year published and monetary value in the output//
    public String toString() {
        return "Book ID: " + id + ", Title: " + title + ", Publishing Year: " + yearOfPublish + ", Price £: " + valueInPounds + ".";
    }
}