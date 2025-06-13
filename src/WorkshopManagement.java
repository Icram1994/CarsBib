import javax.swing.*;
import java.io.IOException;

/**
 * Die Klasse {@code WorkshopManagement} ist der Einstiegspunkt für das Autoservice-Management-System.
 * <p>
 * Diese Klasse initialisiert die grafische Benutzeroberfläche (GUI) des Systems und behandelt
 * potenzielle Ausnahmen, die während der Initialisierung auftreten können.
 * </p>
 */
public class WorkshopManagement {

    /**
     * Der Haupteinstiegspunkt der Anwendung.
     * <p>
     * Diese Methode startet die grafische Benutzeroberfläche in einem separaten Event-Dispatch-Thread
     * und sorgt dafür, dass die Anwendung ordnungsgemäß initialisiert wird.
     * </p>
     *
     * @param args Die Befehlszeilenargumente (werden nicht verwendet).
     */
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            try {
                Handler handler = new Handler();
                new GUI(handler);
                handler.printLog();
            } catch (IOException e) {
                throw new RuntimeException();
            }
        });
    }
}
