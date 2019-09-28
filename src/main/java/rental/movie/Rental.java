package rental.movie;

public class Rental {
    private rental.movie.Movie _movie;
    private int _daysRented;

    public Rental(rental.movie.Movie movie, int daysRented) {
        _movie = movie;
        _daysRented = daysRented;
    }

    public rental.movie.Movie getMovie() {
        return _movie;
    }

    public int getDaysRented() {
        return _daysRented;
    }


}