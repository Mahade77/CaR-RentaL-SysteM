import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarRentalSystem {
    private List<Car> cars;
    private List<Customer> customers;
    private List<Rental> rentals;

    public CarRentalSystem() {
        cars = new ArrayList<>();
        customers = new ArrayList<>();
        rentals = new ArrayList<>();
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void rentCar(String carId, String customerId) {
        Car car = findCar(carId);
        Customer customer = findCustomer(customerId);
        if (car != null && customer != null && !car.isRented()) {
            rentals.add(new Rental(car, customer));
            System.out.println("Car rented successfully.");
        } else {
            System.out.println("Car is not available or customer not found.");
        }
    }

    public void returnCar(String carId) {
        Rental rental = findRentalByCarId(carId);
        if (rental != null) {
            rental.endRental();
            rentals.remove(rental);
            System.out.println("Car returned successfully.");
        } else {
            System.out.println("Rental not found.");
        }
    }

    public void listCars() {
        System.out.println("Available Cars:");
        for (Car car : cars) {
            System.out.println(car);
        }
    }

    public void listCustomers() {
        System.out.println("Registered Customers:");
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }

    private Car findCar(String carId) {
        for (Car car : cars) {
            if (car.getCarId().equals(carId)) {
                return car;
            }
        }
        return null;
    }

    private Customer findCustomer(String customerId) {
        for (Customer customer : customers) {
            if (customer.getCustomerId().equals(customerId)) {
                return customer;
            }
        }
        return null;
    }

    private Rental findRentalByCarId(String carId) {
        for (Rental rental : rentals) {
            if (rental.getCar().getCarId().equals(carId)) {
                return rental;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        CarRentalSystem system = new CarRentalSystem();
        Scanner scanner = new Scanner(System.in);

        // Sample data
        system.addCar(new Car("C1", "koenigsegg jesko"));
        system.addCar(new Car("C2", "Pagani Zonda HP Barchetta"));
        system.addCar(new Car("C3", "Rolls-Royce Sweptail"));
        system.addCar(new Car("C4", "Lamborghini Veneno"));
        system.addCar(new Car("C5", "McLaren Sabre"));
        system.addCar(new Car("C6", "Ferrari 410 Superamerica"));
        system.addCar(new Car("C7", "Aston Martin Valkyrie"));
        system.addCar(new Car("C8", "Porsche 917"));
        system.addCar(new Car("C9", "Bentley Mulliner Bacalar"));
        system.addCar(new Car("C10", "Bugatti La Voiture Noire"));
        system.addCustomer(new Customer("U1", "Sadia"));
        system.addCustomer(new Customer("U2", "Mahade"));
        system.addCustomer(new Customer("U3", "Tahsin"));


        while (true) {
            System.out.println("\nCar Rental System");
            System.out.println("1. List Cars");
            System.out.println("2. List Customers");
            System.out.println("3. Rent a Car");
            System.out.println("4. Return a Car");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1 -> system.listCars();
                case 2 -> system.listCustomers();
                case 3 -> {
                    system.listCars();
                    System.out.print("Enter Car ID: ");
                    String carId = scanner.next();
                    System.out.print("Enter Customer ID: ");
                    String customerId = scanner.next();
                    system.rentCar(carId, customerId);
                }
                case 4 -> {
                    System.out.print("Enter Car ID to return: ");
                    String carId = scanner.next();
                    system.returnCar(carId);
                }
                case 5 -> {
                    System.out.println("Exiting the system.");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }
}
