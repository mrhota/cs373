// -----------
// Store1.java
// -----------

/*
javac -Xlint Store1.java
java  -ea    Store1
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
     *     REGULAR
     *     NEW_RELEASE
     *     CHILDRENS
     * _rentals.elements().nextElement()
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
            Rental each       = rentals.nextElement();
            double thisAmount = 0;
            switch (each.getMovie().getPriceCode()) {
                case Movie.REGULAR:
                    thisAmount += 2;
                    if (each.getDaysRented() > 2)
                        thisAmount += (each.getDaysRented() - 2) * 1.5;
                    break;
                case Movie.NEW_RELEASE:
                    thisAmount += each.getDaysRented() * 3;
                    break;
                case Movie.CHILDRENS:
                    thisAmount += 1.5;
                    if (each.getDaysRented() > 3)
                        thisAmount += (each.getDaysRented() - 3) * 1.5;
                    break;}
            totalAmount += thisAmount;
            ++frequentRenterPoints;
            if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) &&
                (each.getDaysRented()           >  1))
                ++frequentRenterPoints;
            result +=
                "\t" + each.getMovie().getTitle() +
                "\t" + String.valueOf(thisAmount) + "\n";}
        result +=
            "Amount owed is "                  +
            String.valueOf(totalAmount) + "\n";
        result +=
            "You earned "                        +
            String.valueOf(frequentRenterPoints) +
            " frequent renter points";
        return result;}}

final class Store1 {
    public static void main (String[] args) {
        System.out.println("Store1.java");
        TestRunner.run(new TestSuite(TestStore1.class));
        System.out.println("Done.");}}
