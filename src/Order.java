/**
 * Die Klasse {@code Order} repräsentiert einen Auftrag im Autoservice-System.
 * <p>
 * Diese Klasse implementiert das {@link Identifiable}-Interface, um eine eindeutige Identifizierung
 * jedes Auftrags durch eine ID zu ermöglichen. Sie enthält Attribute, die die Eigenschaften eines
 * Auftrags beschreiben, sowie Methoden zum Abrufen dieser Eigenschaften.
 * </p>
 */
public class Order implements Identifiable {

    private final int orderID;
    private final int carID;
    private final int customerID;
    private final int employeeID;
    private final String description;

    /**
     * Konstruktor zur Initialisierung eines {@code Order}-Objekts mit den angegebenen Attributen.
     *
     * @param orderID Die eindeutige ID des Auftrags.
     * @param carID Die ID des Autos, das mit dem Auftrag verbunden ist.
     * @param customerID Die ID des Kunden, der den Auftrag erteilt hat.
     * @param employeeID Die ID des Mitarbeiters, der den Auftrag bearbeitet.
     * @param description Die Beschreibung des Auftrags.
     */
    public Order(int orderID, int carID, int customerID, int employeeID, String description) {
        this.orderID = orderID;
        this.carID = carID;
        this.customerID = customerID;
        this.employeeID = employeeID;
        this.description = description;
    }

    /**
     * Gibt die eindeutige ID des Auftrags zurück.
     *
     * @return Die eindeutige ID des Auftrags als {@code int}.
     */
    public int getID() {
        return orderID;
    }

    /**
     * Gibt die ID des Autos zurück, das mit dem Auftrag verbunden ist.
     *
     * @return Die ID des Autos als {@code int}.
     */
    public int getCarID() {
        return carID;
    }

    /**
     * Gibt die ID des Kunden zurück, der den Auftrag erteilt hat.
     *
     * @return Die ID des Kunden als {@code int}.
     */
    public int getCustomerID() {
        return customerID;
    }

    /**
     * Gibt die ID des Mitarbeiters zurück, der den Auftrag bearbeitet.
     *
     * @return Die ID des Mitarbeiters als {@code int}.
     */
    public int getEmployeeID() {
        return employeeID;
    }

    /**
     * Gibt die Beschreibung des Auftrags zurück.
     *
     * @return Die Beschreibung des Auftrags als {@code String}.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gibt eine String-Darstellung des Auftrags zurück, die alle relevanten Attribute enthält.
     *
     * @return Eine String-Darstellung des Auftrags.
     */
    @Override
    public String toString() {
        return "Auftrag " + orderID + " {AutoID:" + carID + ", MitarbeiterID:" + employeeID + ", Auftrag:" + description + "}";
    }
}
