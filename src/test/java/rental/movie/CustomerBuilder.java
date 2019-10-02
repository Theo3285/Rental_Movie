package rental.movie;

class CustomerBuilder {
    private static final int DEFAULT_DAYS_RENTED = 1;
    private static final String DEFAULT_NAME = "Unnamed";

    private Movie[] movies = new Movie[]{};
    private int daysRented = DEFAULT_DAYS_RENTED;
    private String name = DEFAULT_NAME;

    static CustomerBuilder aCustomer() {
        return new CustomerBuilder();
    }

    CustomerBuilder named(String name) {
        this.name = name;
        return this;
    }

    CustomerBuilder rents(Movie... movies) {
        this.movies = movies;
        return this;
    }

    CustomerBuilder foraDurationOf(int daysRented) {
        this.daysRented = daysRented;
        return this;
    }

    Customer build() {
        Customer customer = new Customer(name);

        for (Movie movie : movies) {
            Rental aRental = new Rental(movie, daysRented);
            customer.addRental(aRental);
        }

        return customer;
    }
}
