// -----------
// Store2.java
// -----------

/*
javac -Xlint Store2.java
java  -ea    Store2
*/

/*
Extract Method (110)
Create Customer.amountFor()

Move Method (142)
Move Customer.amountFor() to Rental.getCharge()

Replace Temp with Query (120)
Changed thisAmount to each.getCharge()
*/

import java.util.Enumeration;
import java.util.Vector;

import junit.framework.TestSuite;
import junit.textui.TestRunner;

class Movie {
    public static final int REGULAR     = 0;
    public static final int NEW_RELEASE = 1;
    public static final int CHILDRENS   = 2;

    private String _title;
    private int    _priceCode;

    public Movie (String title, int priceCode) {
        _title     = title;
        _priceCode = priceCode;}

    public int getPriceCode () { // const
        return _priceCode;}

    public String getTitle () { // const
        return _title;}

    public void setPriceCode (int priceCode) { // not used
        _priceCode = priceCode;}}

class Rental {
    private Movie _movie;
    private int   _daysRented;

    public Rental (Movie movie, int daysRented) {
        _movie      = movie;
        _daysRented = daysRented;}

    /**
     * Movie
     *     REGULAR
     *     NEW_RELEASE
     *     CHILDRENS
     * _movie
     *     getPriceCode()
     */
    public double getCharge () { // const
        double result = 0;
        switch (getMovie().getPriceCode()) {               // why not _movie?
            case Movie.REGULAR:
                result += 2;
                if (getDaysRented() > 2)                   // why not _daysRented?
                    result += (getDaysRented() - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE:
                result += getDaysRented() * 3;
                break;
            case Movie.CHILDRENS:
                result += 1.5;
                if (getDaysRented() > 3)
                    result += (getDaysRented() - 3) * 1.5;
                break;}
        return result;}

    public int getDaysRented () { // const
        return _daysRented;}

    public Movie getMovie () { // const
        return _movie;}}

class Customer {
    private String         _name;
    private Vector<Rental> _rentals = new Vector<Rental>();

    public Customer (String name) {
        _name = name;}

    public void addRental (Rental rental) {
        _rentals.addElement(rental);}

    public String getName () { // const
        return _name;}

    /**
     * Movie
     *     NEW_RELEASE
     * _rentals.elements().nextElement()
     *     getCharge()
     *     getDaysRented()
     *     getMovie()
     *         getPriceCode()
     *         getTitle()
     */
    public String statement () { // O(n)
        double              totalAmount          = 0;
        int                 frequentRenterPoints = 0;
        String              result               = "Rental Record for " + getName() + "\n";
        Enumeration<Rental> rentals              = _rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental each  = rentals.nextElement();
            totalAmount += each.getCharge();
            ++frequentRenterPoints;
            if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) &&
                (each.getDaysRented()           >  1))
                ++frequentRenterPoints;
            result +=
                "\t" + each.getMovie().getTitle()       +
                "\t" + String.valueOf(each.getCharge()) + "\n";}
        result +=
            "Amount owed is "                  +
            String.valueOf(totalAmount) + "\n";
        result +=
            "You earned "                        +
            String.valueOf(frequentRenterPoints) +
            " frequent renter points";
        return result;}}

final class Store2 {
    public static void main (String[] args) {
        System.out.println("Store2.java");
        TestRunner.run(new TestSuite(TestStore1.class));
        System.out.println("Done.");}}
