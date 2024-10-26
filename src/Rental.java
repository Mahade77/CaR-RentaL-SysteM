public class Rental {
    private Car car;
    private Customer customer;

    public Rental(Car car, Customer customer) {
        this.car = car;
        this.customer = customer;
        car.rentCar();
    }

    public Car getCar() {
        return car;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void endRental() {
        car.returnCar();
    }

    @Override
    public String toString() {
        return "Rental: " + car.getModel() + " rented by " + customer.getName();
    }
}
