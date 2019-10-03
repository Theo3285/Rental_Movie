package rental.movie;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class RentalShould {

    @Mock
    Movie regularMovie;
    @Mock
    Movie newReleaseMovie;
    @Mock
    Movie childrenMovie;

    @Before
    public void initialise() {
        given(regularMovie.getPriceCode()).willReturn(0);
        given(newReleaseMovie.getPriceCode()).willReturn(1);
        given(childrenMovie.getPriceCode()).willReturn(2);
    }

    @Test
    public void return_amount_for_regular_movie_rented_more_than_two_days() {
        Rental rental = new Rental(regularMovie, 3);

        assertThat(rental.amountFor(), is(3.5));
    }

    @Test
    public void return_amount_for_regular_movie_rented_one_day() {
        Rental rental = new Rental(regularMovie, 1);

        assertThat(rental.amountFor(), is(2.0));
    }

    @Test
    public void return_amount_for_children_movie_rented_more_than_three_days() {
        Rental rental = new Rental(childrenMovie, 4);

        assertThat(rental.amountFor(), is(3.0));
    }

    @Test
    public void return_amount_for_children_movie_rented_two_days() {
        Rental rental = new Rental(childrenMovie, 2);

        assertThat(rental.amountFor(), is(1.5));
    }

    @Test
    public void return_amount_for_new_release_movie_rented_two_days() {
        Rental rental = new Rental(newReleaseMovie, 2);

        assertThat(rental.amountFor(), is(6.0));
    }


}