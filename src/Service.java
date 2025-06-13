import java.util.List;

public class Service {

    private final List<Customer> customers;
    private final List<Employee> employees;
    private final List<Car> cars;

    private final List<Order> orders;

    public Service(List<Customer> customers, List<Employee> employees, List<Car> cars, List<Order> orders) {
        this.customers = customers;
        this.employees = employees;
        this.cars = cars;
        this.orders = orders;
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void removeCustomer(Customer customer) {
        customers.remove(customer);
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void removeEmployee(Employee employee) {
        employees.remove(employee);
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public void removeCars(Car car) {
        cars.remove(car);
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

}
