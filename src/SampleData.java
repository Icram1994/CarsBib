import java.util.ArrayList;
import java.util.List;

public class SampleData {

    public static List<Car> getSampleCars() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car(1, "Model S", "Tesla", "2020", "5YJSA1E26MF123456", "Elektrisch", 15000, "Neu", "Aluminium"));
        cars.add(new Car(2, "Model 3", "Tesla", "2021", "5YJ3E1EA7MF123457", "Elektrisch", 10000, "Neu", "Aluminium"));
        cars.add(new Car(3, "Mustang", "Ford", "2019", "1FA6P8TH7K5151234", "Benzin", 30000, "Gebraucht", "Stahl"));
        cars.add(new Car(4, "Civic", "Honda", "2018", "2HGFC2F59JH123456", "Benzin", 25000, "Gebraucht", "Aluminium"));
        cars.add(new Car(5, "A4", "Audi", "2022", "WAUENAF48MN123456", "Diesel", 5000, "Neu", "Aluminium"));
        cars.add(new Car(6, "Corolla", "Toyota", "2020", "JTDEPRAE3LJ123456", "Hybrid", 15000, "Gebraucht", "Aluminium"));
        cars.add(new Car(7, "X5", "BMW", "2023", "5UXCR6C59P1234567", "Diesel", 2000, "Neu", "Aluminium"));
        cars.add(new Car(8, "E-Class", "Mercedes-Benz", "2021", "WDDZF4JB1KA123456", "Benzin", 12000, "Gebraucht", "Stahl"));
        cars.add(new Car(9, "CX-5", "Mazda", "2022", "JM3KFBCM4N1234567", "Benzin", 8000, "Neu", "Aluminium"));
        cars.add(new Car(10, "Impreza", "Subaru", "2019", "JF1GPAK61K1234567", "Benzin", 40000, "Gebraucht", "Stahl"));
        return cars;
    }

    public static List<Employee> getSampleEmployees() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "Hans Mueller", "Karosserie", "Lehrling", "1234", "test@test.de"));
        employees.add(new Employee(2, "Anna Schmidt", "Mechanik", "Geselle", "5678", "anna.schmidt@example.com"));
        employees.add(new Employee(3, "Peter Fischer", "Elektrik", "Meister", "9101", "peter.fischer@example.com"));
        employees.add(new Employee(4, "Maria Weber", "Lackierung", "Facharbeiter", "1121", "maria.weber@example.com"));
        employees.add(new Employee(5, "Thomas Becker", "Verwaltung", "Sachbearbeiter", "3141", "thomas.becker@example.com"));
        employees.add(new Employee(6, "Julia Hoffmann", "Kundenservice", "Leiterin", "5161", "julia.hoffmann@example.com"));
        employees.add(new Employee(7, "Michael Wagner", "Einkauf", "Einkäufer", "7181", "michael.wagner@example.com"));
        employees.add(new Employee(8, "Laura Schulz", "IT", "Administratorin", "9202", "laura.schulz@example.com"));
        employees.add(new Employee(9, "Robert Braun", "Logistik", "Fahrer", "1223", "robert.braun@example.com"));
        employees.add(new Employee(10, "Katharina Kaiser", "HR", "Personalreferentin", "3243", "katharina.kaiser@example.com"));
        return employees;
    }

    public static List<Customer> getSampleCustomers() {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer(1, "Max Mustermann", "max.mustermann@example.com", "+491234567890", "Musterstraße 1, 12345 Musterstadt"));
        customers.add(new Customer(2, "Erika Musterfrau", "erika.musterfrau@example.com", "+491234567891", "Beispielweg 2, 23456 Beispielstadt"));
        customers.add(new Customer(3, "Hans Meier", "hans.meier@example.com", "+491234567892", "Hauptstraße 3, 34567 Hauptstadt"));
        customers.add(new Customer(4, "Petra Schulz", "petra.schulz@example.com", "+491234567893", "Nebenstraße 4, 45678 Nebenstadt"));
        customers.add(new Customer(5, "Lukas Huber", "lukas.huber@example.com", "+491234567894", "Ringstraße 5, 56789 Ringstadt"));
        customers.add(new Customer(6, "Anna Fischer", "anna.fischer@example.com", "+491234567895", "Gartenweg 6, 67890 Gartendorf"));
        customers.add(new Customer(7, "Julia Schneider", "julia.schneider@example.com", "+491234567896", "Waldweg 7, 78901 Waldstadt"));
        customers.add(new Customer(8, "Michael Becker", "michael.becker@example.com", "+491234567897", "Seestraße 8, 89012 Seestadt"));
        customers.add(new Customer(9, "Laura Hoffmann", "laura.hoffmann@example.com", "+491234567898", "Bergstraße 9, 90123 Bergdorf"));
        customers.add(new Customer(10, "Robert Wagner", "robert.wagner@example.com", "+491234567899", "Talweg 10, 01234 Talstadt"));
        return customers;
    }

    public static List<Order> getSampleOrders() {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order(2, 101, 201, 301, "Ölwechsel"));
        orders.add(new Order(5, 102, 202, 302, "Reifenwechsel"));
        orders.add(new Order(6, 103, 203, 303, "Bremsenprüfung"));
        orders.add(new Order(8, 104, 204, 304, "Klimaanlagenwartung"));
        orders.add(new Order(9, 105, 205, 305, "Inspektion"));

        return orders;
    }

    public static List<Order> getClosedOrders() {
        List<Order> closedOrders = new ArrayList<>();
        closedOrders.add(new Order(1, 101, 201, 301, "Ölwechsel"));
        closedOrders.add(new Order(3, 102, 202, 302, "Reifenwechsel"));
        closedOrders.add(new Order(4, 103, 203, 303, "Inspektion"));
        closedOrders.add(new Order(7, 104, 204, 304, "Bremsenservice"));
        closedOrders.add(new Order(10, 105, 205, 305, "Klimaanlagenwartung"));
        return closedOrders;
    }
}