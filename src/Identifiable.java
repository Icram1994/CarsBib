
/**
 * Das Interface {@code Identifiable} definiert eine Methode zur eindeutigen Identifizierung von Objekten.
 * <p>
 * Klassen, die dieses Interface implementieren, müssen eine Methode bereitstellen, die eine eindeutige
 * ID für das Objekt zurückgibt. Diese ID kann verwendet werden, um Objekte in einer Datenbank oder
 * anderen Speichersystemen zu identifizieren und zu unterscheiden.
 * </p>
 */

public interface Identifiable {

    /**
     * Gibt die eindeutige ID des Objekts zurück.
     *
     * @return Die eindeutige ID des Objekts als {@code int}.
     */

    int getID();
}
