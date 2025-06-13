import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SampleDataDatabase {


    private static final String URL = "jdbc:mysql://localhost/car_service";
    private static final String USER = "admin";
    private static final String PSWD = "sicheresPasswort!";

    public static List<Car> getCarsFromDatabase() {
        List<Car> cars = new ArrayList<>();
        String query = "SELECT * FROM Cars";

        try (Connection connection = DriverManager.getConnection(URL, USER, PSWD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String model = resultSet.getString("model");
                String manufacturer = resultSet.getString("manufacturer");
                String yearOfConstruction = resultSet.getString("year_of_construction");
                String chassisNumber = resultSet.getString("chassis_number");
                String fuelType = resultSet.getString("fuel_type");
                int kilometers = resultSet.getInt("kilometers");
                String condition = resultSet.getString("car_condition");
                String wheelType = resultSet.getString("wheel_type");

                cars.add(new Car(id, model, manufacturer, yearOfConstruction, chassisNumber, fuelType, kilometers, condition, wheelType));

            }
        } catch (Exception e) {
            System.err.println(e);
        }
        return cars;
    }

    public static List<Employee> getEmployeeFromDatabase() {
        List<Employee> employees = new ArrayList<>();
        String query = "SELECT * FROM Employees";
        try (Connection connection = DriverManager.getConnection(URL, USER, PSWD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String department = resultSet.getString("department");
                String position = resultSet.getString("position");
                String phone = resultSet.getString("phone");
                String mail = resultSet.getString("email");

                employees.add(new Employee(id, name, department, position, phone, mail));
            }
        } catch (Exception e) {
            System.err.println(e);
        }

        return employees;
    }

    public static List<Customer> getCustomersFromDatabase() {
        List<Customer> customers = new ArrayList<>();
        String query = "SELECT * FROM Customers";
        try (Connection connection = DriverManager.getConnection(URL, USER, PSWD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String adress = resultSet.getString(("address"));
                String phone = resultSet.getString("phone");
                String mail = resultSet.getString("email");

                customers.add(new Customer(id, name, mail, phone, adress));

            }

        } catch (Exception e) {
            System.err.println(e);
        }
        return customers;
    }

    public static List<Order> getOrdersFromDatabase() {
        List<Order> orders = new ArrayList<>();
        String query = "SELECT * FROM Orders";

        try (Connection connection = DriverManager.getConnection(URL, USER, PSWD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                int orderID = resultSet.getInt("id");
                int carID = resultSet.getInt("car_id");
                int customerID = resultSet.getInt("customer_id");
                int employeeID = resultSet.getInt("employee_id");
                String description = resultSet.getString("description");

                orders.add(new Order(orderID, carID, customerID, employeeID, description));

            }

        } catch (Exception e) {
            System.err.println(e);
        }

        return orders;
    }

    public static List<Order> getClosedOrdersFromDatabase() {
        List<Order> closedOrders = new ArrayList<>();
        String query = "SELECT * FROM ClosedOrders";

        try (Connection connection = DriverManager.getConnection(URL, USER, PSWD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                int orderID = resultSet.getInt("id");
                int carID = resultSet.getInt("car_id");
                int customerID = resultSet.getInt("customer_id");
                int employeeID = resultSet.getInt("employee_id");
                String description = resultSet.getString("description");

                closedOrders.add(new Order(orderID, carID, customerID, employeeID, description));
            }

        } catch (Exception e) {
            System.err.println(e);
        }
        return closedOrders;
    }

}