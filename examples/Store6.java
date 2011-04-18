// -----------
// Store6.java
// -----------

/*
javac -Xlint Store6.java
java  -ea    Store6
*/

/*
Replace Type Code with State/Strategy (227)
Move Method(142)
Replace Conditional with Polymorphism (225)
Create Price
Create RegularPrice
Create NewReleasePrice
Create ChildrensPrice
Create Price.getCharge()
Create Price.getFrequentRenterPoints()
*/

import java.util.Enumeration;
import java.util.Vector;

import junit.framework.TestSuite;
import junit.textui.TestRunner;

abstract class Price {
    abstract double getCharge    (int daysRented);
    abstract int    getPriceCode ();               // not needed

    public int getFrequentRenterPoints (int daysRented) { // const
        return 1;}}

class RegularPrice extends Price {
    public double getCharge (int daysRented) { // const
        double result = 2;
        if (daysRented > 2)
            result += (daysRented - 2) * 1.5;
        return result;}

    public int getPriceCode () { // const // not needed
        return Movie.REGULAR;}}

class NewReleasePrice extends Price {
    public double getCharge (int daysRented) { // const
        return daysRented * 3;}

    public int getFrequentRenterPoints (int daysRented) { // const
        return (daysRented > 1) ? 2 : 1;}

    public int getPriceCode () { // const // not needed
        return Movie.NEW_RELEASE;}}

class ChildrensPrice extends Price {
    public double getCharge (int daysRented) { // const
        double result = 1.5;
        if (daysRented > 3)
            result += (daysRented - 3) * 1.5;
        return result;}

    public int getPriceCode () { // const // not needed
        return Movie.CHILDRENS;}}

class Movie {
    public static final int REGULAR     = 0;
    public static final int NEW_RELEASE = 1;
    public static final int CHILDRENS   = 2;

    private String _title;
    private Price  _price;

    public Movie (String title, int priceCode) {
        _title = title;
        setPriceCode(priceCode);}                // used once

    /**
     * _price
     *     getCharge()
     */
    public double getCharge (int daysRented) { // const
        return _price.getCharge(daysRented);}

    /**
     * _price
     *     getFrequentRenterPoints()
     */
    public int getFrequentRenterPoints (int daysRented) { // const
        return _price.getFrequentRenterPoints(daysRented);}

    /**
     * _price
     *     getPriceCode()
     */
    public int getPriceCode () { // const // not needed
        return _price.getPriceCode();}

    public String getTitle () { // const
        return _title;}

    public void setPriceCode (int priceCode) {
        switch (priceCode) {                                                   // used once, still have a switch!
            case Movie.REGULAR:
                _price = new RegularPrice();
                break;
            case Movie.NEW_RELEASE:
                _price = new NewReleasePrice();
                break;
            case Movie.CHILDRENS:
                _price = new ChildrensPrice();
                break;
            default:
                throw new IllegalArgumentException("Incorrect Price Code");}}}

class Rental {
    private Movie _movie;
    private int   _daysRented;

    public Rental (Movie movie, int daysRented) {
        _movie      = movie;
        _daysRented = daysRented;}

    /**
     * _movie
     *     getCharge()
     */
    public double getCharge () { // const
        return _movie.getCharge(_daysRented);}

    public int getDaysRented () { // const // not used
        return _daysRented;}

    /**
     * _movie
     *     getFrequentRenterPoints()
     */
    public int getFrequentRenterPoints () { // const
        return _movie.getFrequentRenterPoints(_daysRented);}

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

final class Store6 {
    public static void main (String[] args) {
        System.out.println("Store6.java");
        TestRunner.run(new TestSuite(TestStore1.class));
        System.out.println("Done.");}}
