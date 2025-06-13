/**
 * Die Klasse {@code Car} repräsentiert ein Auto mit verschiedenen Attributen wie Modell, Hersteller und Baujahr.
 * <p>
 * Diese Klasse implementiert das {@link Identifiable}-Interface, um eine eindeutige Identifizierung
 * jedes Autos durch eine ID zu ermöglichen. Sie enthält Attribute, die die Eigenschaften eines Autos
 * beschreiben, sowie Methoden zum Abrufen und Ändern dieser Eigenschaften.
 * </p>
 */
public class Car implements Identifiable {

    private final String manufacturer;
    private final String yearOfConstruction;
    private final String chassisNumber;
    private final String fuelType;
    private final int kilometers;
    private final String condition;
    private final String wheelType;
    private int carID;
    private String model;

    /**
     * Konstruktor zur Initialisierung eines {@code Car}-Objekts mit den angegebenen Attributen.
     *
     * @param carID Die eindeutige ID des Autos.
     * @param model Das Modell des Autos.
     * @param manufacturer Der Hersteller des Autos.
     * @param yearOfConstruction Das Baujahr des Autos.
     * @param chassisNumber Die Fahrgestellnummer des Autos.
     * @param fuelType Die Antriebsart des Autos.
     * @param kilometers Der Kilometerstand des Autos.
     * @param condition Der Zustand des Autos.
     * @param wheelType Der Reifentyp des Autos.
     */
    public Car(int carID, String model, String manufacturer, String yearOfConstruction, String chassisNumber, String fuelType,
               int kilometers, String condition, String wheelType) {
        this.carID = carID;
        this.model = model;
        this.manufacturer = manufacturer;
        this.yearOfConstruction = yearOfConstruction;
        this.chassisNumber = chassisNumber;
        this.fuelType = fuelType;
        this.kilometers = kilometers;
        this.condition = condition;
        this.wheelType = wheelType;
    }

    /**
     * Gibt das Modell des Autos zurück.
     *
     * @return Das Modell des Autos als {@code String}.
     */
    public String getModel() {
        return model;
    }

    /**
     * Setzt das Modell des Autos.
     *
     * @param model Das neue Modell des Autos.
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * Gibt den Reifentyp des Autos zurück.
     *
     * @return Der Reifentyp des Autos als {@code String}.
     */
    public String getWheelType() {
        return wheelType;
    }

    /**
     * Gibt den Zustand des Autos zurück.
     *
     * @return Der Zustand des Autos als {@code String}.
     */
    public String getCondition() {
        return condition;
    }

    /**
     * Gibt den Kilometerstand des Autos zurück.
     *
     * @return Der Kilometerstand des Autos als {@code int}.
     */
    public int getKilometers() {
        return kilometers;
    }

    /**
     * Gibt die Antriebsart des Autos zurück.
     *
     * @return Die Antriebsart des Autos als {@code String}.
     */
    public String getFuelType() {
        return fuelType;
    }

    /**
     * Gibt die Fahrgestellnummer des Autos zurück.
     *
     * @return Die Fahrgestellnummer des Autos als {@code String}.
     */
    public String getChassisNumber() {
        return chassisNumber;
    }

    /**
     * Gibt das Baujahr des Autos zurück.
     *
     * @return Das Baujahr des Autos als {@code String}.
     */
    public String getYearOfConstruction() {
        return yearOfConstruction;
    }

    /**
     * Gibt den Hersteller des Autos zurück.
     *
     * @return Der Hersteller des Autos als {@code String}.
     */
    public String getManufacturer() {
        return manufacturer;
    }

    /**
     * Gibt die eindeutige ID des Autos zurück.
     *
     * @return Die eindeutige ID des Autos als {@code int}.
     */
    public int getID() {
        return carID;
    }

    /**
     * Setzt die eindeutige ID des Autos.
     *
     * @param carID Die neue eindeutige ID des Autos.
     */
    public void setID(int carID) {
        this.carID = carID;
    }

    /**
     * Gibt eine String-Darstellung des Autos zurück, die alle Attribute enthält.
     *
     * @return Eine String-Darstellung des Autos.
     */
    @Override
    public String toString() {
        return "Auto " + carID + " {Modell:" + model + ", Hersteller: " + manufacturer + ", Baujahr:" + yearOfConstruction + ", Fahrgestellnummer:" + chassisNumber + ", Antrieb:" + fuelType + ", Kilometerstand:" + kilometers + ", Zustand:" + condition + ", Reifentyp:" + wheelType + "}";
    }

}
