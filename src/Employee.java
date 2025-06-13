/**
 * Die Klasse {@code Employee} repräsentiert einen Mitarbeiter mit verschiedenen Attributen wie Name, Abteilung und Position.
 * <p>
 * Diese Klasse implementiert das {@link Identifiable}-Interface, um eine eindeutige Identifizierung
 * jedes Mitarbeiters durch eine ID zu ermöglichen. Sie enthält Attribute, die die Eigenschaften eines
 * Mitarbeiters beschreiben, sowie Methoden zum Abrufen und Ändern dieser Eigenschaften.
 * </p>
 */
public class Employee implements Identifiable {

    private final String name;
    private final String department;
    private final String position;
    private final String phone;
    private final String mail;
    private int employeeID;

    /**
     * Konstruktor zur Initialisierung eines {@code Employee}-Objekts mit den angegebenen Attributen.
     *
     * @param employeeID Die eindeutige ID des Mitarbeiters.
     * @param name Der Name des Mitarbeiters.
     * @param department Die Abteilung des Mitarbeiters.
     * @param position Die Position des Mitarbeiters.
     * @param phone Die Telefonnummer des Mitarbeiters.
     * @param mail Die E-Mail-Adresse des Mitarbeiters.
     */
    public Employee(int employeeID, String name, String department, String position, String phone, String mail) {
        this.employeeID = employeeID;
        this.name = name;
        this.department = department;
        this.position = position;
        this.phone = phone;
        this.mail = mail;
    }

    /**
     * Gibt die eindeutige ID des Mitarbeiters zurück.
     *
     * @return Die eindeutige ID des Mitarbeiters als {@code int}.
     */
    public int getID() {
        return employeeID;
    }

    /**
     * Setzt die eindeutige ID des Mitarbeiters.
     *
     * @param employeeID Die neue eindeutige ID des Mitarbeiters.
     */
    public void setID(int employeeID) {
        this.employeeID = employeeID;
    }

    /**
     * Gibt den Namen des Mitarbeiters zurück.
     *
     * @return Der Name des Mitarbeiters als {@code String}.
     */
    public String getName() {
        return name;
    }

    /**
     * Gibt die Abteilung des Mitarbeiters zurück.
     *
     * @return Die Abteilung des Mitarbeiters als {@code String}.
     */
    public String getDepartment() {
        return department;
    }

    /**
     * Gibt die Position des Mitarbeiters zurück.
     *
     * @return Die Position des Mitarbeiters als {@code String}.
     */
    public String getPosition() {
        return position;
    }

    /**
     * Gibt die Telefonnummer des Mitarbeiters zurück.
     *
     * @return Die Telefonnummer des Mitarbeiters als {@code String}.
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Gibt die E-Mail-Adresse des Mitarbeiters zurück.
     *
     * @return Die E-Mail-Adresse des Mitarbeiters als {@code String}.
     */
    public String getMail() {
        return mail;
    }

    /**
     * Gibt eine String-Darstellung des Mitarbeiters zurück, die alle Attribute enthält.
     *
     * @return Eine String-Darstellung des Mitarbeiters.
     */
    @Override
    public String toString() {
        return "Mitarbeiter " + employeeID + " {Name:" + name + ", Abteilung:" + department + ", Position:" + position + ", Mail:" + mail + ", Telefon:" + phone + "}";
    }
}
