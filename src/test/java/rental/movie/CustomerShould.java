package rental.movie;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class CustomerShould {

    public static final int RENTED_ONE_DAY = 1;
    public static final int RENTED_THREE_DAYS = 3;
    public static final int RENTED_FOUR_DAYS = 4;

    public static final int NEW_RELEASE = 1;
    public static final int REGULAR_MOVIE = 0;
    public static final int CHILDREN = 2;

    public static final String MOVIE_TITLE = "movie";
    public static final String CUSTOMER_NAME = "customer";

    private Customer customer;
    private Movie regularMovie;
    private Movie newReleaseMovie;
    private Movie childrenMovie;

    @Before
    public void setUp() throws Exception {
        customer = new Customer(CUSTOMER_NAME);
        regularMovie = new Movie(MOVIE_TITLE, REGULAR_MOVIE);
        newReleaseMovie = new Movie(MOVIE_TITLE, NEW_RELEASE);
        childrenMovie = new Movie(MOVIE_TITLE, CHILDREN);
    }

    @Test
    public void print_statement_for_regular_movie_rented_more_than_three_days() {
        Rental rental = new Rental(regularMovie, RENTED_THREE_DAYS);
        customer.addRental(rental);

        String expected = customer.statement();

        assertThat(expected, is("Rental Record for customer\n\tmovie\t3.5\nAmount owed is 3.5\nYou earned 1 frequent retner points"));
    }

    @Test
    public void print_statement_for_regular_movie_rented_less_than_three_days() {
        Rental rental = new Rental(regularMovie, RENTED_ONE_DAY);
        customer.addRental(rental);

        String expected = customer.statement();

        assertThat(expected, is("Rental Record for customer\n\tmovie\t2.0\nAmount owed is 2.0\nYou earned 1 frequent retner points"));
    }

    @Test
    public void print_statement_for_new_release_movie_rented_only_one_day() {
        Rental rental = new Rental(newReleaseMovie, RENTED_ONE_DAY);
        customer.addRental(rental);

        String expected = customer.statement();

        assertThat(expected, is("Rental Record for customer\n\tmovie\t3.0\nAmount owed is 3.0\nYou earned 1 frequent retner points"));
    }

    @Test
    public void print_statement_for_new_release_movie_rented_more_three_days() {
        Rental rental = new Rental(newReleaseMovie, RENTED_THREE_DAYS);
        customer.addRental(rental);

        String expected = customer.statement();

        assertThat(expected, is("Rental Record for customer\n\tmovie\t9.0\nAmount owed is 9.0\nYou earned 2 frequent retner points"));
    }

    @Test
    public void print_statement_for_children_movie_rented_four_days() {
        Rental rental = new Rental(childrenMovie, RENTED_FOUR_DAYS);
        customer.addRental(rental);

        String expected = customer.statement();

        assertThat(expected, is("Rental Record for customer\n\tmovie\t3.0\nAmount owed is 3.0\nYou earned 1 frequent retner points"));
    }

    @Test
    public void print_statement_for_children_movie_rented_one_day() {
        Rental rental = new Rental(childrenMovie,RENTED_ONE_DAY);
        customer.addRental(rental);

        String expected = customer.statement();

        assertThat(expected, is("Rental Record for customer\n\tmovie\t1.5\nAmount owed is 1.5\nYou earned 1 frequent retner points"));
    }
}