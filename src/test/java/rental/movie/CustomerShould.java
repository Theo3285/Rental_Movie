package rental.movie;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class CustomerShould {

    private static final int ONE_DAY = 1;
    private static final int THREE_DAYS = 3;
    private static final int FOUR_DAYS = 4;

    private static final int REGULAR_MOVIE = 0;
    private static final int NEW_RELEASE = 1;
    private static final int CHILDREN = 2;

    private static final Movie BRASIL = new Movie("Brasil", REGULAR_MOVIE);
    private static final Movie DRAGON = new Movie("Dragon", CHILDREN);
    private static final Movie MEN_IN_BLACK_FOUR = new Movie("Men in black four", NEW_RELEASE);
    private static final String PAUL = "Paul";

    @Test
    public void print_statement_for_regular_movie_rented_more_than_three_days() {
        Customer paul = CustomerBuilder.aCustomer()
                .named(PAUL)
                .rents(BRASIL)
                .foraDurationOf(THREE_DAYS)
                .build();

        String expected = paul.statement();

        assertThat(expected, is("Rental Record for Paul\n\tBrasil\t3.5\nAmount owed is 3.5\nYou earned 1 frequent retner points"));
    }

    @Test
    public void print_statement_for_regular_movie_rented_less_than_three_days() {
        Customer paul = CustomerBuilder.aCustomer()
                .named(PAUL)
                .rents(BRASIL)
                .foraDurationOf(ONE_DAY)
                .build();

        String expected = paul.statement();

        assertThat(expected, is("Rental Record for Paul\n\tBrasil\t2.0\nAmount owed is 2.0\nYou earned 1 frequent retner points"));
    }

    @Test
    public void print_statement_for_new_release_movie_rented_only_one_day() {
        Customer paul = CustomerBuilder.aCustomer()
                .named(PAUL)
                .rents(MEN_IN_BLACK_FOUR)
                .foraDurationOf(ONE_DAY)
                .build();

        String expected = paul.statement();

        assertThat(expected, is("Rental Record for Paul\n\tMen in black four\t3.0\nAmount owed is 3.0\nYou earned 1 frequent retner points"));
    }

    @Test
    public void print_statement_for_new_release_movie_rented_more_three_days() {
        Customer paul = CustomerBuilder.aCustomer()
                .named(PAUL)
                .rents(MEN_IN_BLACK_FOUR)
                .foraDurationOf(THREE_DAYS)
                .build();

        String expected = paul.statement();

        assertThat(expected, is("Rental Record for Paul\n\tMen in black four\t9.0\nAmount owed is 9.0\nYou earned 2 frequent retner points"));
    }

    @Test
    public void print_statement_for_children_movie_rented_four_days() {
        Customer paul = CustomerBuilder.aCustomer()
                .named(PAUL)
                .rents(DRAGON)
                .foraDurationOf(FOUR_DAYS)
                .build();

        String expected = paul.statement();

        assertThat(expected, is("Rental Record for Paul\n\tDragon\t3.0\nAmount owed is 3.0\nYou earned 1 frequent retner points"));
    }

    @Test
    public void print_statement_for_children_movie_rented_one_day() {
        Customer paul = CustomerBuilder.aCustomer()
                .named(PAUL)
                .rents(DRAGON)
                .foraDurationOf(ONE_DAY)
                .build();

        String expected = paul.statement();

        assertThat(expected, is("Rental Record for Paul\n\tDragon\t1.5\nAmount owed is 1.5\nYou earned 1 frequent retner points"));
    }

    @Test
    public void print_statement_for_a_list_of_movies_rented_four_days() {
        Customer paul = CustomerBuilder.aCustomer()
                .named(PAUL)
                .rents(BRASIL, DRAGON, MEN_IN_BLACK_FOUR)
                .foraDurationOf(FOUR_DAYS)
                .build();

        String expected = paul.statement();

        assertThat(expected, is("Rental Record for Paul\n\tBrasil\t5.0\n\tDragon\t3.0\n\tMen in black four\t12.0\nAmount owed is 20.0\nYou earned 4 frequent retner points"));
    }
}