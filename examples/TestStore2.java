// ---------------
// TestStore2.java
// ---------------

import junit.framework.Assert;
import junit.framework.TestCase;

// ----------
// TestStore2
// ----------

public final class TestStore2 extends TestCase {
    public void test () {
        Customer x = new Customer("Penelope");
        assertTrue(x.statement().equals(
            "Rental Record for Penelope\n" +
            "Amount owed is 0.0\n"         +
            "You earned 0 frequent renter points"));

        x.addRental(new Rental(new Movie("Shane", new RegularPrice()), 2));
        assertTrue(x.statement().equals(
            "Rental Record for Penelope\n" +
            "\tShane\t2.0\n"               +
            "Amount owed is 2.0\n"         +
            "You earned 1 frequent renter points"));

        x.addRental(new Rental(new Movie("Red River", new RegularPrice()), 5));
        assertTrue(x.statement().equals(
            "Rental Record for Penelope\n" +
            "\tShane\t2.0\n"               +
            "\tRed River\t6.5\n"           +
            "Amount owed is 8.5\n"         +
            "You earned 2 frequent renter points"));

        x.addRental(new Rental(new Movie("Giant", new NewReleasePrice()), 1));
        assertTrue(x.statement().equals(
            "Rental Record for Penelope\n" +
            "\tShane\t2.0\n"               +
            "\tRed River\t6.5\n"           +
            "\tGiant\t3.0\n"               +
            "Amount owed is 11.5\n"        +
            "You earned 3 frequent renter points"));

        x.addRental(new Rental(new Movie("2001", new NewReleasePrice()), 3));
        assertTrue(x.statement().equals(
            "Rental Record for Penelope\n" +
            "\tShane\t2.0\n"               +
            "\tRed River\t6.5\n"           +
            "\tGiant\t3.0\n"               +
            "\t2001\t9.0\n"                +
            "Amount owed is 20.5\n"        +
            "You earned 5 frequent renter points"));

        x.addRental(new Rental(new Movie("Big Country", new ChildrensPrice()), 3));
        assertTrue(x.statement().equals(
            "Rental Record for Penelope\n" +
            "\tShane\t2.0\n"               +
            "\tRed River\t6.5\n"           +
            "\tGiant\t3.0\n"               +
            "\t2001\t9.0\n"                +
            "\tBig Country\t1.5\n"         +
            "Amount owed is 22.0\n"        +
            "You earned 6 frequent renter points"));

        x.addRental(new Rental(new Movie("Spartacus", new ChildrensPrice()), 5));
        assertTrue(x.statement().equals(
            "Rental Record for Penelope\n" +
            "\tShane\t2.0\n"               +
            "\tRed River\t6.5\n"           +
            "\tGiant\t3.0\n"               +
            "\t2001\t9.0\n"                +
            "\tBig Country\t1.5\n"         +
            "\tSpartacus\t4.5\n"           +
            "Amount owed is 26.5\n"        +
            "You earned 7 frequent renter points"));}}
