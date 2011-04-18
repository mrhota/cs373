// -----------
// Store7.java
// -----------

/*
javac -Xlint Store7.java
java  -ea    Store7
*/

/*
Change Movie.Movie() to take a Price instead of a price code
Change Movie.setPriceCode() to Movie.setPrice()
Remove Movie.getPriceCode()
Remove Movie.REGULAR
Remove Movie.NEW_RELEASE
Remove Movie.CHILDRENS
Remove Rental.getDaysRented()
*/

import java.util.Enumeration;
import java.util.Vector;

import junit.framework.TestSuite;
import junit.textui.TestRunner;

abstract class Price {
    abstract double getCharge (int daysRented);

    public int getFrequentRenterPoints (int daysRented) { // const
        return 1;}}

class RegularPrice extends Price {
    public double getCharge (int daysRented) { // const
        double result = 2;
        if (daysRented > 2)
            result += (daysRented - 2) * 1.5;
        return result;}}

class NewReleasePrice extends Price {
    public double getCharge (int daysRented) { // const
        return daysRented * 3;}

    public int getFrequentRenterPoints (int daysRented) { // const
        return (daysRented > 1) ? 2 : 1;}}

class ChildrensPrice extends Price {
    public double getCharge (int daysRented) { // const
        double result = 1.5;
        if (daysRented > 3)
            result += (daysRented - 3) * 1.5;
        return result;}}

class Movie {
    private String _title;
    private Price  _price;

    public Movie (String title, Price price) {
        _title = title;
        _price = price;}

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

    public String getTitle () { // const
        return _title;}

    public void setPrice (Price price) {
        _price = price;}}

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
     * _rentals
     *     getCharge()
     */
    private double getTotalCharge () { // const, O(n)
        double result = 0;
        for (Rental rental : _rentals)
            result += rental.getCharge();
        return result;}

    /**
     * _rentals
     *     getFrequentRenterPoints()
     */
    private int getTotalFrequentRenterPoints () { // const, O(n)
        int result  = 0;
        for (Rental rental : _rentals)
            result += rental.getFrequentRenterPoints();
        return result;}

    /**
     * _rentals
     *     getCharge()
     *     getMovie()
     *         getTitle()
     */
    public String statement () { // O(3n)
        String result = "Rental Record for " + getName() + "\n";
        for (Rental rental : _rentals)
            result +=
                "\t" + rental.getMovie().getTitle()       +
                "\t" + String.valueOf(rental.getCharge()) + "\n";
        result +=
            "Amount owed is "                +
            String.valueOf(getTotalCharge()) + "\n";
        result +=
            "You earned "                                  +
            String.valueOf(getTotalFrequentRenterPoints()) +
            " frequent renter points";
        return result;}}

final class Store7 {
    public static void main (String[] args) {
        System.out.println("Store7.java");
        TestRunner.run(new TestSuite(TestStore2.class));
        System.out.println("Done.");}}
