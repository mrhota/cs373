// -----------
// Store4.java
// -----------

/*
javac -Xlint Store4.java
java  -ea    Store4
*/

/*
Extract Method (110)
Create Customer.getTotalCharge()
Create Customer.getTotalFrequentRenterPoints()

Replace Temp with Query (120)
Changed totalAmount          to getTotalCharge()
Changed frequentRenterPoints to getTotalFrequentRenterPoints()
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

    public int getDaysRented () { // const // not needed
        return _daysRented;}

    /**
     * Movie
     *     NEW_RELEASE
     * _movie
     *     getPriceCode()
     */
    public int getFrequentRenterPoints () { // const
        if ((getMovie().getPriceCode() == Movie.NEW_RELEASE) && // why not _movie?
            (getDaysRented()           >  1))                   // why not _daysRented?
            return 2;
        return 1;}

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
     * _rentals.elements().nextElement()
     *     getCharge()
     */
    private double getTotalCharge () { // const, O(n)
        double              result  = 0;
        Enumeration<Rental> rentals = _rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental each  = rentals.nextElement();
            result      += each.getCharge();}
        return result;}

    /**
     * _rentals.elements().nextElement()
     *     getFrequentRenterPoints()
     */
    private int getTotalFrequentRenterPoints () { // const, O(n)
        int                 result  = 0;
        Enumeration<Rental> rentals = _rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental each  = rentals.nextElement();
            result      += each.getFrequentRenterPoints();}
        return result;}

    /**
     * _rentals.elements().nextElement()
     *     getCharge()
     *     getMovie()
     *         getTitle()
     */
    public String statement () { // O(3n)
        String              result  = "Rental Record for " + getName() + "\n";
        Enumeration<Rental> rentals = _rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental each  = rentals.nextElement();
            result      +=
                "\t" + each.getMovie().getTitle()       +
                "\t" + String.valueOf(each.getCharge()) + "\n";}
        result +=
            "Amount owed is "                +
            String.valueOf(getTotalCharge()) + "\n";
        result +=
            "You earned "                                  +
            String.valueOf(getTotalFrequentRenterPoints()) +
            " frequent renter points";
        return result;}}

final class Store4 {
    public static void main (String[] args) {
        System.out.println("Store4.java");
        TestRunner.run(new TestSuite(TestStore1.class));
        System.out.println("Done.");}}
