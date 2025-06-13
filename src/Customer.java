/**
 * Die Klasse {@code Customer} repräsentiert einen Kunden im Autoservice-System.
 * <p>
 * Diese Klasse implementiert das {@link Identifiable}-Interface, um eine eindeutige Identifizierung
 * jedes Kunden durch eine ID zu ermöglichen. Sie enthält Attribute, die die Eigenschaften eines
 * Kunden beschreiben, sowie Methoden zum Abrufen und Ändern dieser Eigenschaften.
 * </p>
 */
public class Customer implements Identifiable {

    private final String mail;
    private final String phone;
    private final String adress;
    private int customerID;
    private String name;

    /**
     * Konstruktor zur Initialisierung eines {@code Customer}-Objekts mit den angegebenen Attributen.
     *
     * @param customerID Die eindeutige ID des Kunden.
     * @param name Der Name des Kunden.
     * @param mail Die E-Mail-Adresse des Kunden.
     * @param phone Die Telefonnummer des Kunden.
     * @param adress Die Adresse des Kunden.
     */
    public Customer(int customerID, String name, String mail, String phone, String adress) {
        this.customerID = customerID;
        this.name = name;
        this.mail = mail;
        this.phone = phone;
        this.adress = adress;
    }

    /**
     * Gibt die eindeutige ID des Kunden zurück.
     *
     * @return Die eindeutige ID des Kunden als {@code int}.
     */
    public int getID() {
        return customerID;
    }

    /**
     * Setzt die eindeutige ID des Kunden.
     *
     * @param customerID Die neue eindeutige ID des Kunden.
     */
    public void setID(int customerID) {
        this.customerID = customerID;
    }

    /**
     * Gibt den Namen des Kunden zurück.
     *
     * @return Der Name des Kunden als {@code String}.
     */
    public String getName() {
        return name;
    }

    /**
     * Setzt den Namen des Kunden.
     *
     * @param name Der neue Name des Kunden.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gibt die E-Mail-Adresse des Kunden zurück.
     *
     * @return Die E-Mail-Adresse des Kunden als {@code String}.
     */
    public String getMail() {
        return mail;
    }

    /**
     * Gibt die Telefonnummer des Kunden zurück.
     *
     * @return Die Telefonnummer des Kunden als {@code String}.
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Gibt die Adresse des Kunden zurück.
     *
     * @return Die Adresse des Kunden als {@code String}.
     */
    public String getAdress() {
        return adress;
    }

    /**
     * Gibt eine String-Darstellung des Kunden zurück, die alle relevanten Attribute enthält.
     *
     * @return Eine String-Darstellung des Kunden.
     */
    @Override
    public String toString() {
        return "Kunde " + customerID + " {Name:" + name + ", Mail:" + mail + ", Telefon:" + phone + ", Adresse:" + adress + "}";
    }
}
