import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * Die Klasse {@code Handler} bietet Methoden zum Verwalten von Datenbankoperationen
 * in einem Autoservice-System.
 * <p>
 * Diese Klasse stellt CRUD-Operationen (Erstellen, Lesen, Aktualisieren, Löschen) für
 * verschiedene Entitäten wie Autos, Kunden, Mitarbeiter und Bestellungen bereit. Sie
 * verwendet JDBC, um mit einer MySQL-Datenbank zu kommunizieren, und stellt sicher,
 * dass alle Datenbankoperationen in Transaktionen ausgeführt werden, um die Datenintegrität
 * zu gewährleisten.
 * </p>
 * <p>
 * Die Klasse bietet außerdem Methoden zum Exportieren von Daten in Textdateien und
 * zum Erstellen von Rechnungen für Bestellungen.
 * </p>
 * <p>
 * Alle SQL-Fehler und unerwarteten Ausnahmen werden mit einem {@link Logger} protokolliert,
 * um die Fehlersuche und -behebung zu erleichtern.
 * </p>
 * <p>
 * <strong>Verwendung:</strong> Erstellen Sie eine Instanz der Klasse {@code Handler}, um
 * auf die bereitgestellten Methoden zuzugreifen und Datenbankoperationen durchzuführen.
 * </p>
 * <p>
 * <strong>Beispiel:</strong>
 * <pre>
 *     Handler handler = new Handler();
 *     Car car = new Car(1, "Model S", "Tesla", "2020", "5YJSA1E26MF1XXXXX", "Electric", 15000, "New", "Alloy");
 *     handler.addCar(car);
 * </pre>
 * </p>
 *
 * @see Car
 * @see Customer
 * @see Employee
 * @see Order
 */

public class Handler {

    private static final String URL = "jdbc:mysql://localhost/car_service";
    private static final String USER = "admin";
    private static final String PASS = "sicheresPasswort!";
    private static final Logger LOGGER = Logger.getLogger(Handler.class.getName());

    /**
     * Fügt ein neues Auto in die Datenbank ein.
     * <p>
     * Diese Methode nimmt ein {@link Car}-Objekt als Parameter und fügt die entsprechenden
     * Daten in die Tabelle "Cars" der Datenbank ein. Die Methode verwendet eine Transaktion,
     * um sicherzustellen, dass die Einfügung entweder vollständig oder gar nicht erfolgt.
     * </p>
     *
     * @param car Das {@link Car}-Objekt, das in die Datenbank eingefügt werden soll.
     */

    public void addCar(Car car) {
        String insertSQL = "INSERT INTO Cars (id, model, manufacturer, year_of_construction, chassis_number, " + "fuel_type, kilometers, car_condition, wheel_type) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASS)) {
            connection.setAutoCommit(false);

            try (PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {
                preparedStatement.setInt(1, car.getID());
                preparedStatement.setString(2, car.getModel());
                preparedStatement.setString(3, car.getManufacturer());
                preparedStatement.setString(4, car.getYearOfConstruction());
                preparedStatement.setString(5, car.getChassisNumber());
                preparedStatement.setString(6, car.getFuelType());
                preparedStatement.setInt(7, car.getKilometers());
                preparedStatement.setString(8, car.getCondition());
                preparedStatement.setString(9, car.getWheelType());

                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    connection.commit();
                    System.out.println(rowsAffected + " row(s) inserted.");
                } else {
                    connection.rollback();
                    System.out.println("Insert failed, transaction rolled back.");
                }
            } catch (SQLException e) {
                connection.rollback();
                LOGGER.log(Level.SEVERE, "Transaction failed and was rolled back: " + e.getMessage(), e);
            } finally {
                connection.setAutoCommit(true);
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "SQL error: " + e.getMessage(), e);
        }
    }

    /**
     * Fügt einen neuen Kunden in die Datenbank ein.
     * <p>
     * Diese Methode nimmt ein {@link Customer}-Objekt als Parameter und fügt die entsprechenden
     * Daten in die Tabelle "Customers" der Datenbank ein. Die Methode verwendet eine Transaktion,
     * um sicherzustellen, dass die Einfügung entweder vollständig oder gar nicht erfolgt.
     * </p>
     *
     * @param customer Das {@link Customer}-Objekt, das in die Datenbank eingefügt werden soll.
     */

    public void addCustomer(Customer customer) {
        String insertSQL = "INSERT INTO Customers (id, name, email, phone, address) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASS)) {
            connection.setAutoCommit(false);

            try (PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {
                preparedStatement.setInt(1, customer.getID());
                preparedStatement.setString(2, customer.getName());
                preparedStatement.setString(3, customer.getMail());
                preparedStatement.setString(4, customer.getPhone());
                preparedStatement.setString(5, customer.getAdress());

                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    connection.commit();
                    System.out.println(rowsAffected + " row(s) inserted.");
                } else {
                    connection.rollback();
                    System.out.println("Insert failed, transaction rolled back.");
                }
            } catch (SQLException e) {
                connection.rollback();
                LOGGER.log(Level.SEVERE, "Transaction failed and was rolled back: " + e.getMessage(), e);
            } finally {
                connection.setAutoCommit(true);
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "SQL error: " + e.getMessage(), e);
        }
    }

    /**
     * Fügt einen neuen Mitarbeiter in die Datenbank ein.
     * <p>
     * Diese Methode nimmt ein {@link Employee}-Objekt als Parameter und fügt die entsprechenden
     * Daten in die Tabelle "Employees" der Datenbank ein. Die Methode verwendet eine Transaktion,
     * um sicherzustellen, dass die Einfügung entweder vollständig oder gar nicht erfolgt.
     * </p>
     *
     * @param employee Das {@link Employee}-Objekt, das in die Datenbank eingefügt werden soll.
     */

    public void addEmployee(Employee employee) {
        String insertSQL = "INSERT INTO Employees (id, name, department, position, phone, email) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASS)) {
            connection.setAutoCommit(false);

            try (PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {
                preparedStatement.setInt(1, employee.getID());
                preparedStatement.setString(2, employee.getName());
                preparedStatement.setString(3, employee.getDepartment());
                preparedStatement.setString(4, employee.getPosition());
                preparedStatement.setString(5, employee.getPhone());
                preparedStatement.setString(6, employee.getMail());

                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    connection.commit();
                    System.out.println(rowsAffected + " row(s) inserted.");
                } else {
                    connection.rollback();
                    System.out.println("Insert failed, transaction rolled back.");
                }
            } catch (SQLException e) {
                connection.rollback();
                LOGGER.log(Level.SEVERE, "Transaction failed and was rolled back: " + e.getMessage(), e);
            } finally {
                connection.setAutoCommit(true);
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "SQL error: " + e.getMessage(), e);
        }
    }

    /**
     * Fügt eine neue Bestellung in die Datenbank ein.
     * <p>
     * Diese Methode nimmt ein {@link Order}-Objekt als Parameter und fügt die entsprechenden
     * Daten in die Tabelle "Orders" der Datenbank ein. Die Methode verwendet eine Transaktion,
     * um sicherzustellen, dass die Einfügung entweder vollständig oder gar nicht erfolgt.
     * </p>
     *
     * @param order Das {@link Order}-Objekt, das in die Datenbank eingefügt werden soll.
     */

    public void addOrder(Order order) {
        String insertSQL = "INSERT INTO Orders (id, car_id, customer_id, employee_id, description) VALUES (?, ?, ?, ?, ? )";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASS)) {
            connection.setAutoCommit(false);

            try (PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {
                preparedStatement.setInt(1, order.getID());
                preparedStatement.setString(2, String.valueOf(order.getCarID()));
                preparedStatement.setString(3, String.valueOf(order.getCustomerID()));
                preparedStatement.setString(4, String.valueOf(order.getEmployeeID()));
                preparedStatement.setString(5, order.getDescription());

                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    connection.commit();
                    System.out.println(rowsAffected + " row(s) inserted.");
                } else {
                    connection.rollback();
                    System.out.println("Insert failed, transaction rolled back.");
                }
            } catch (SQLException e) {
                connection.rollback();
                LOGGER.log(Level.SEVERE, "Transaction failed and was rolled back: " + e.getMessage(), e);
            } finally {
                connection.setAutoCommit(true);
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "SQL error: " + e.getMessage(), e);
        }
    }

    /**
     * Ruft alle Autos aus der Datenbank ab.
     * <p>
     * Diese Methode führt eine Abfrage auf der Tabelle "Cars" aus und gibt eine Liste
     * von {@link Car}-Objekten zurück, die alle Datensätze der Tabelle repräsentieren.
     * </p>
     *
     * @return Eine Liste von {@link Car}-Objekten, die alle Autos in der Datenbank repräsentieren.
     */

    public List<Car> getCars() {
        List<Car> cars = new ArrayList<>();
        String query = "SELECT * FROM Cars";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASS); PreparedStatement preparedStatement = connection.prepareStatement(query); ResultSet resultSet = preparedStatement.executeQuery()) {

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
        } catch (SQLIntegrityConstraintViolationException e) {
            LOGGER.log(Level.SEVERE, "Integrity constraint violation: " + e.getMessage(), e);
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "SQL error: " + e.getMessage(), e);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Unexpected error: " + e.getMessage(), e);
        }
        return cars;
    }

    /**
     * Ruft alle Kunden aus der Datenbank ab.
     * <p>
     * Diese Methode führt eine Abfrage auf der Tabelle "Customers" aus und gibt eine Liste
     * von {@link Customer}-Objekten zurück, die alle Datensätze der Tabelle repräsentieren.
     * </p>
     *
     * @return Eine Liste von {@link Customer}-Objekten, die alle Kunden in der Datenbank repräsentieren.
     */

    public List<Customer> getCustomers() {
        List<Customer> customers = new ArrayList<>();
        String query = "SELECT * FROM Customers";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASS); PreparedStatement preparedStatement = connection.prepareStatement(query); ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String address = resultSet.getString(("address"));
                String phone = resultSet.getString("phone");
                String mail = resultSet.getString("email");

                customers.add(new Customer(id, name, mail, phone, address));
            }

        } catch (SQLIntegrityConstraintViolationException e) {
            LOGGER.log(Level.SEVERE, "Integrity constraint violation: " + e.getMessage(), e);
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "SQL error: " + e.getMessage(), e);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Unexpected error: " + e.getMessage(), e);
        }
        return customers;
    }

    /**
     * Ruft alle Mitarbeiter aus der Datenbank ab.
     * <p>
     * Diese Methode führt eine Abfrage auf der Tabelle "Employees" aus und gibt eine Liste
     * von {@link Employee}-Objekten zurück, die alle Datensätze der Tabelle repräsentieren.
     * </p>
     *
     * @return Eine Liste von {@link Employee}-Objekten, die alle Mitarbeiter in der Datenbank repräsentieren.
     */

    public List<Employee> getEmployees() {
        List<Employee> employees = new ArrayList<>();
        String query = "SELECT * FROM Employees";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASS); PreparedStatement preparedStatement = connection.prepareStatement(query); ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String department = resultSet.getString("department");
                String position = resultSet.getString("position");
                String phone = resultSet.getString("phone");
                String mail = resultSet.getString("email");

                employees.add(new Employee(id, name, department, position, phone, mail));
            }
        } catch (SQLIntegrityConstraintViolationException e) {
            LOGGER.log(Level.SEVERE, "Integrity constraint violation: " + e.getMessage(), e);
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "SQL error: " + e.getMessage(), e);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Unexpected error: " + e.getMessage(), e);
        }
        return employees;
    }

    /**
     * Ruft alle Bestellungen aus der Datenbank ab.
     * <p>
     * Diese Methode führt eine Abfrage auf der Tabelle "Orders" aus und gibt eine Liste
     * von {@link Order}-Objekten zurück, die alle Datensätze der Tabelle repräsentieren.
     * </p>
     *
     * @return Eine Liste von {@link Order}-Objekten, die alle Bestellungen in der Datenbank repräsentieren.
     */

    public List<Order> getOrders() {
        List<Order> orders = new ArrayList<>();
        String query = "SELECT * FROM Orders";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASS); PreparedStatement preparedStatement = connection.prepareStatement(query); ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                int orderID = resultSet.getInt("id");
                int carID = resultSet.getInt("car_id");
                int customerID = resultSet.getInt("customer_id");
                int employeeID = resultSet.getInt("employee_id");
                String description = resultSet.getString("description");

                orders.add(new Order(orderID, carID, customerID, employeeID, description));
            }

        } catch (SQLIntegrityConstraintViolationException e) {
            LOGGER.log(Level.SEVERE, "Integrity constraint violation: " + e.getMessage(), e);
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "SQL error: " + e.getMessage(), e);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Unexpected error: " + e.getMessage(), e);
        }
        return orders;
    }

    /**
     * Ruft alle abgeschlossenen Bestellungen aus der Datenbank ab.
     * <p>
     * Diese Methode führt eine Abfrage auf der Tabelle "ClosedOrders" aus und gibt eine Liste
     * von {@link Order}-Objekten zurück, die alle abgeschlossenen Bestellungen repräsentieren.
     * </p>
     *
     * @return Eine Liste von {@link Order}-Objekten, die alle abgeschlossenen Bestellungen in der Datenbank repräsentieren.
     */

    public List<Order> getClosedOrders() {
        List<Order> closedOrders = new ArrayList<>();
        String query = "SELECT * FROM ClosedOrders";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASS); PreparedStatement preparedStatement = connection.prepareStatement(query); ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                int orderID = resultSet.getInt("id");
                int carID = resultSet.getInt("car_id");
                int customerID = resultSet.getInt("customer_id");
                int employeeID = resultSet.getInt("employee_id");
                String description = resultSet.getString("description");

                closedOrders.add(new Order(orderID, carID, customerID, employeeID, description));
            }

        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "SQL error while retrieving closed orders: " + e.getMessage(), e);
        }
        return closedOrders;
    }

    /**
     * Generiert eine neue eindeutige ID für die angegebene Tabelle.
     * <p>
     * Diese Methode ermittelt die höchste vorhandene ID in der angegebenen Tabelle
     * und gibt eine neue, um eins erhöhte ID zurück. Bei der Tabelle "Orders" werden
     * auch die IDs aus der Tabelle "ClosedOrders" berücksichtigt.
     * </p>
     *
     * @param tableName Der Name der Tabelle, für die eine neue ID generiert werden soll.
     * @return Eine neue eindeutige ID für die angegebene Tabelle.
     * @throws IllegalArgumentException Wenn der Tabellenname ungültig ist.
     */

    public int generateID(String tableName) {
        if (tableValidator(tableName)) {
            throw new IllegalArgumentException(tableName + " konnte nicht gelesen werden");
        }

        int generatedID = 0;
        String query;

        if (tableName.equals("Orders")) {
            query = "SELECT MAX(id) AS max_id FROM Orders UNION SELECT MAX(id) AS max_id FROM closedOrders";
        } else {
            query = "SELECT MAX(id) AS max_id FROM " + tableName;
        }

        try (Connection connection = DriverManager.getConnection(URL, USER, PASS); PreparedStatement preparedStatement = connection.prepareStatement(query); ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("max_id");
                if (id > generatedID) {
                    generatedID = id;
                }
            }

        } catch (SQLIntegrityConstraintViolationException e) {
            LOGGER.log(Level.SEVERE, "Integrity constraint violation: " + e.getMessage(), e);
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "SQL error: " + e.getMessage(), e);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Unexpected error: " + e.getMessage(), e);
        }
        System.out.println(generatedID);
        return generatedID + 1;
    }

    /**
     * Formatiert eine Liste von Objekten als String.
     * <p>
     * Diese Methode nimmt eine Liste von Objekten eines beliebigen Typs und gibt
     * eine String-Darstellung der Liste zurück, wobei jedes Objekt in einer neuen Zeile steht.
     * </p>
     *
     * @param list Die Liste von Objekten, die formatiert werden soll.
     * @param <T> Der Typ der Objekte in der Liste.
     * @return Eine String-Darstellung der Liste.
     */

    public <T> String showList(List<T> list) {
        StringBuilder output = new StringBuilder();
        for (T item : list) {
            output.append(item.toString()).append("\n");
        }
        return output.toString();
    }

    /**
     * Löscht einen Datensatz aus der angegebenen Tabelle basierend auf der ID.
     * <p>
     * Diese Methode nimmt den Namen einer Tabelle und eine ID als Parameter und
     * löscht den entsprechenden Datensatz aus der Tabelle. Die Methode verwendet
     * eine Transaktion, um sicherzustellen, dass die Löschung entweder vollständig
     * oder gar nicht erfolgt.
     * </p>
     *
     * @param tableName Der Name der Tabelle, aus der der Datensatz gelöscht werden soll.
     * @param ID Die ID des Datensatzes, der gelöscht werden soll.
     */

    public void deleteItem(String tableName, int ID) {
        String deleteSQL = "DELETE FROM `" + tableName + "` WHERE id = ?";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASS)) {
            connection.setAutoCommit(false);

            try (PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL)) {
                preparedStatement.setInt(1, ID);

                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    connection.commit();
                    System.out.println(rowsAffected + " row(s) deleted.");
                } else {
                    connection.rollback();
                    System.out.println("No matching row found to delete, transaction rolled back.");
                }
            } catch (SQLException e) {
                connection.rollback();
                LOGGER.log(Level.SEVERE, "Transaction failed and was rolled back: " + e.getMessage(), e);
            } finally {
                connection.setAutoCommit(true);
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "SQL error: " + e.getMessage(), e);
        }
    }

    /**
     * Kopiert eine Bestellung in die Tabelle "ClosedOrders" und löscht sie aus der Tabelle "Orders".
     * <p>
     * Diese Methode kopiert eine Bestellung mit der angegebenen ID aus der Tabelle "Orders"
     * in die Tabelle "ClosedOrders" und löscht sie anschließend aus der Tabelle "Orders".
     * Die Methode verwendet eine Transaktion, um sicherzustellen, dass beide Operationen
     * entweder vollständig oder gar nicht erfolgen.
     * </p>
     *
     * @param tableName Der Name der Tabelle, aus der die Bestellung gelöscht werden soll.
     * @param orderID Die ID der Bestellung, die kopiert und gelöscht werden soll.
     * @throws IllegalArgumentException Wenn der Tabellenname ungültig ist.
     */

    public void copyAndDeleteOrder(String tableName, int orderID) {

        if (tableValidator(tableName)) {
            throw new IllegalArgumentException(tableName + " konnte nicht gelesen werden");
        }

        String copySQL = "INSERT INTO `closedOrders` (id, car_id, customer_id, employee_id, description) SELECT id, " + "car_id, customer_id, employee_id, description FROM `Orders` WHERE id = ? " + "AND NOT EXISTS (SELECT 1 FROM `closedorders` WHERE id = ?);";
        String deleteSQL = "DELETE FROM `Orders` WHERE id = ?";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASS)) {

            connection.setAutoCommit(false);

            try (PreparedStatement copyStatement = connection.prepareStatement(copySQL); PreparedStatement deleteStatement = connection.prepareStatement(deleteSQL)) {
                copyStatement.setInt(1, orderID);
                copyStatement.setInt(2, orderID);
                int rowsInserted = copyStatement.executeUpdate();

                deleteStatement.setInt(1, orderID);

                int rowsDeleted = deleteStatement.executeUpdate();
                if (rowsInserted > 0 && rowsDeleted > 0) {
                    connection.commit();
                    System.out.println("Order copied and deleted successfully.");
                } else {
                    connection.rollback();
                    System.out.println("Order copy and delete failed, transaction rolled back.");
                }
            } catch (SQLException e) {
                connection.rollback();
                LOGGER.log(Level.SEVERE, "Transaction failed and was rolled back: " + e.getMessage(), e);
            } finally {
                connection.setAutoCommit(true);
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "SQL error: " + e.getMessage(), e);
        }

        deleteItem(tableName, orderID);

    }

    /**
     * Erstellt eine Rechnung für eine Bestellung und speichert sie in einer Datei.
     * <p>
     * Diese Methode sucht nach einer Bestellung mit der angegebenen ID in den Tabellen
     * "Orders" und "ClosedOrders". Wenn die Bestellung gefunden wird, wird ihre String-Darstellung
     * in eine Textdatei mit dem angegebenen Dateinamen geschrieben.
     * </p>
     *
     * @param orderID Die ID der Bestellung, für die eine Rechnung erstellt werden soll.
     * @param fileName Der Name der Datei, in der die Rechnung gespeichert werden soll.
     */

    public void printInvoice(int orderID, String fileName) {
        List<Order> orders = getOrders();
        List<Order> closedOrders = getClosedOrders();
        Optional<Order> orderToPrint = orders.stream().filter(order -> order.getID() == orderID).findFirst();

        if (orderToPrint.isEmpty()) {
            orderToPrint = closedOrders.stream().filter(closedOrder -> closedOrder.getID() == orderID).findFirst();
        }
        orderToPrint.ifPresentOrElse(order -> {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName + ".txt"))) {
                writer.write(order.toString());
                writer.newLine();
            } catch (IOException e) {
                System.err.println("Fehler beim Exportieren der Liste: " + e.getMessage());
            }
        }, () -> System.err.println("Kein passender Auftrag gefunden"));
    }

    /**
     * Exportiert eine Liste von Objekten in eine Textdatei.
     * <p>
     * Diese Methode nimmt eine Liste von Objekten eines beliebigen Typs und schreibt
     * ihre String-Darstellung in eine Textdatei mit dem angegebenen Dateinamen.
     * Jedes Objekt wird in einer neuen Zeile geschrieben.
     * </p>
     *
     * @param list Die Liste von Objekten, die exportiert werden soll.
     * @param fileName Der Name der Datei, in die die Liste exportiert werden soll.
     * @param <T> Der Typ der Objekte in der Liste.
     */

    public <T> void exportItem(List<T> list, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName + ".txt"))) {
            list.stream().map(Object::toString).forEach(item -> {
                try {
                    writer.write(item);
                    writer.newLine();
                } catch (IOException e) {
                    throw new RuntimeException("Fehler beim Schreiben in die Datei", e);
                }
            });
        } catch (IOException e) {
            System.err.println("Fehler beim Exportieren der Liste: " + e.getMessage());
        }
    }

    /**
     * Validiert den Namen einer Tabelle.
     * <p>
     * Diese Methode überprüft, ob der gegebene Tabellenname nur Buchstaben und Unterstriche
     * enthält und somit gültig ist.
     * </p>
     *
     * @param tableName Der Name der Tabelle, der validiert werden soll.
     * @return {@code true} wenn der Tabellenname ungültig ist, {@code false} wenn er gültig ist.
     */

    public boolean tableValidator(String tableName) {
        return !tableName.matches("[a-zA-Z_]+");
    }

    /**
     * Konfiguriert den Logger, um Protokollnachrichten in die Datei "log.txt" zu schreiben.
     * <p>
     * Diese Methode erstellt einen {@link FileHandler}, der die Protokollausgaben
     * in die Datei "log.txt" schreibt. Der FileHandler wird mit einem {@link SimpleFormatter}
     * konfiguriert, um die Protokollnachrichten in einem einfachen Textformat zu formatieren.
     * Der Logger wird auf das Level {@link Level#ALL} gesetzt, um alle Protokollnachrichten
     * zu erfassen.
     * </p>
     * <p>
     * Falls beim Erstellen oder Konfigurieren des FileHandlers ein {@link IOException}
     * auftritt, wird dies als schwerwiegender Fehler im Logger protokolliert.
     * </p>
     */
    public void printLog() {
        try {
            FileHandler fileHandler = new FileHandler("log.txt", true);
            fileHandler.setFormatter(new SimpleFormatter());

            LOGGER.addHandler(fileHandler);
            LOGGER.setLevel(Level.ALL);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Fehler beim Konfigurieren des Loggers", e);
        }
    }
}
