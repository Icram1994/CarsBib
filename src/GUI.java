import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Die Klasse {@code GUI} erstellt eine grafische Benutzeroberfläche für das MK Carservice-System.
 * <p>
 * Diese Klasse verwendet {@link JFrame} und {@link JPanel}, um eine Fensteranwendung zu erstellen,
 * die es dem Benutzer ermöglicht, verschiedene Aktionen im Zusammenhang mit dem Autoservice-System
 * durchzuführen, wie das Hinzufügen, Löschen und Exportieren von Daten.
 * </p>
 * <p>
 * Die GUI enthält Schaltflächen für verschiedene Operationen, die mit einem {@link Handler}-Objekt
 * interagieren, um Datenbankoperationen auszuführen.
 * </p>
 *
 * @see Handler
 */

public class GUI {
    private final Handler handler;
    private List<JButton> buttons;

    /**
     * Konstruktor für die {@code GUI}-Klasse.
     * <p>
     * Initialisiert die GUI mit einem {@link Handler}-Objekt, das für die Durchführung
     * der Datenbankoperationen verantwortlich ist.
     * </p>
     *
     * @param handler Das {@link Handler}-Objekt, das für die Datenbankoperationen verwendet wird.
     * @throws IOException Wenn ein Fehler beim Laden des Bannerbildes auftritt.
     */

    public GUI(Handler handler) throws IOException {
        this.handler = handler;
        initialize();
    }

    /**
     * Initialisiert die Hauptkomponenten der GUI.
     * <p>
     * Diese Methode erstellt das Hauptfenster der Anwendung und fügt die Bild- und
     * Schaltflächenpanels hinzu. Sie legt auch die Layouts und Größen der Panels fest.
     * </p>
     *
     * @throws IOException Wenn ein Fehler beim Laden des Bannerbildes auftritt.
     */

    private void initialize() throws IOException {
        JFrame frame = new JFrame("MK Carservice");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 500);
        frame.setLayout(new BorderLayout());

        JPanel imagePanel = createImagePanel();
        JPanel buttonPanel = createButtonPanel(frame);

        frame.add(imagePanel);
        frame.add(buttonPanel);
        frame.add(imagePanel, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.CENTER);

        frame.setVisible(true);

    }

    /**
     * Erstellt ein Panel, das ein Bild anzeigt.
     * <p>
     * Diese Methode lädt ein Bild von der Festplatte und zeigt es in einem {@link JPanel} an,
     * das als Banner im oberen Bereich des Fensters dient.
     * </p>
     *
     * @return Ein {@link JPanel}, das das Bild enthält.
     * @throws IOException Wenn ein Fehler beim Laden des Bildes auftritt.
     */

    private JPanel createImagePanel() throws IOException {


        String imgPath = "src/img/banner.jpg";
        BufferedImage img = ImageIO.read(new File(imgPath));

        JPanel imagePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
            }
        };
        imagePanel.setPreferredSize(new Dimension(800, 100));

        return imagePanel;
    }

    /**
     * Erstellt ein Panel mit Schaltflächen für verschiedene Aktionen.
     * <p>
     * Diese Methode erstellt ein {@link JPanel} mit einem Rasterlayout, das Schaltflächen
     * für verschiedene Benutzeraktionen enthält, wie das Hinzufügen, Löschen und Exportieren
     * von Daten. Jede Schaltfläche ist mit einem Aktionslistener verknüpft, der die entsprechende
     * Methode im {@link Handler} aufruft.
     * </p>
     *
     * @param parentFrame Das übergeordnete {@link JFrame}, in dem das Panel angezeigt wird.
     * @return Ein {@link JPanel}, das die Schaltflächen enthält.
     */

    private JPanel createButtonPanel(JFrame parentFrame) {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(0, 4));

        JButton addCustomer = new JButton("Neuen Kunden anlegen");
        JButton deleteCustomer = new JButton("Kunden löschen");
        JButton addCar = new JButton("Neues Auto anlegen");
        JButton deleteCar = new JButton("Auto löschen");
        JButton addEmployee = new JButton("Neuen Angestellten anlegen");
        JButton deleteEmployee = new JButton("Mitarbeiter löschen");
        JButton addOrder = new JButton("Neuen Auftrag anlegen");
        JButton openOrders = new JButton("Auftragsliste");
        JButton closeOrder = new JButton("Auftrag abschließen");
        JButton invoice = new JButton("Rechnung drucken");
        JButton customerList = new JButton("Kundenliste");
        JButton carList = new JButton("Autoliste");
        JButton employeeList = new JButton("Mitarbeiterliste");
        JButton employeeExport = new JButton("Mitarbeiter exportieren");
        JButton customerExport = new JButton("Kunden exportieren");
        JButton carExport = new JButton("Autos exportieren");
//       JButton support = new JButton("Support/Hilfe");
        JButton settings = new JButton("Einstellungen");
        JButton exportOrders = new JButton("Aufträge exportieren");
//        JButton exit = new JButton("Programm beenden");
        JButton closedOrders = new JButton("Abgeschlossene Aufträge");
        JButton deleteOrder = new JButton("Auftrag löschen");

        buttons = List.of(addCustomer, deleteCustomer, addCar, deleteCar, addCustomer, deleteCustomer, addEmployee, deleteEmployee, addOrder, deleteOrder, openOrders, closeOrder, invoice, customerList, carList, employeeList, employeeExport, customerExport, carExport, settings, exportOrders, closedOrders, deleteOrder);

        buttonPanel.add(openOrders);
        buttonPanel.add(addOrder);
        buttonPanel.add(closeOrder);
        buttonPanel.add(invoice);

        buttonPanel.add(carList);
        buttonPanel.add(addCar);
        buttonPanel.add(deleteCar);
        buttonPanel.add(carExport);

        buttonPanel.add(customerList);
        buttonPanel.add(addCustomer);
        buttonPanel.add(deleteCustomer);
        buttonPanel.add(customerExport);

        buttonPanel.add(employeeList);
        buttonPanel.add(addEmployee);
        buttonPanel.add(deleteEmployee);
        buttonPanel.add(employeeExport);

        buttonPanel.add(closedOrders);
        buttonPanel.add(exportOrders);
        buttonPanel.add(deleteOrder);
        buttonPanel.add(settings);

        openOrders.addActionListener(_ -> {
            String output = handler.showList(handler.getOrders());
            JOptionPane.showMessageDialog(null, output);
        });

        addOrder.addActionListener(_ -> {
            try {
                int carID = Integer.parseInt(JOptionPane.showInputDialog("Auto ID"));
                int customerID = Integer.parseInt(JOptionPane.showInputDialog("Kunden ID"));
                int employeeID = Integer.parseInt(JOptionPane.showInputDialog("Angestellten ID"));
                String description = JOptionPane.showInputDialog("Was soll gemacht werden?");

                int orderID = handler.generateID("Orders");

                Order order = new Order(orderID, carID, customerID, employeeID, description);
                handler.addOrder(order);

                JOptionPane.showMessageDialog(null, "Der Auftrag wurde mit der ID " + orderID + " angelegt");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Eingabe fehlerhaft. Bitte erneut versuchen");
            }
        });

        closeOrder.addActionListener(_ -> {
            try {
                int input = Integer.parseInt(JOptionPane.showInputDialog("Zum abschließen des Auftrags bitte die AuftragsID eingeben."));
                handler.copyAndDeleteOrder("closed_orders", input);
                JOptionPane.showMessageDialog(null, "Auftrag mit der ID " + input + " wurde abgeschlossen.");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Eingabe fehlerhaft. Bitte erneut versuchen");
            }
        });

        invoice.addActionListener(_ -> {
            try {
                int inputID = Integer.parseInt(JOptionPane.showInputDialog("Zu welchem Auftrag soll die Rechnung gedruckt werden?"));
                String outputFile = JOptionPane.showInputDialog("In welche Datei soll die Rechnung exportiert werden?");
                handler.printInvoice(inputID, outputFile);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Bitte eine gültige AuftragsID eingeben.", "Eingabefehler", JOptionPane.ERROR_MESSAGE);
            }
        });

        carList.addActionListener(_ -> {
            String output = handler.showList(handler.getCars());
            JOptionPane.showMessageDialog(null, output);
        });

        addCar.addActionListener(_ -> {
            String model = JOptionPane.showInputDialog("Automodell");
            String manufacturer = JOptionPane.showInputDialog("Hersteller");
            String yearOfConstruction = JOptionPane.showInputDialog("Baujahr");
            String chassisNumber = JOptionPane.showInputDialog("Chassisnummer");
            String fuelType = JOptionPane.showInputDialog("Antriebsart");
            int kilometers = Integer.parseInt(JOptionPane.showInputDialog("Kilometerstand"));
            String condition = JOptionPane.showInputDialog("Autozustand");
            String wheelType = JOptionPane.showInputDialog("Reifentyp");

            int carID = handler.generateID("Cars");

            Car car = new Car(carID, model, manufacturer, yearOfConstruction, chassisNumber, fuelType, kilometers, condition, wheelType);
            handler.addCar(car);

            JOptionPane.showMessageDialog(null, "Das neue Auto wurde mit der ID " + carID + " angelegt");
        });

        deleteCar.addActionListener(_ -> {
            try {
                int inputID = Integer.parseInt(JOptionPane.showInputDialog("Zum löschen eines Autos bitte die AutoID eingeben."));
                handler.deleteItem("Cars", inputID);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Eingabe fehlerhaft! Bitte erneut versuchen.");
            }
        });

        carExport.addActionListener(_ -> {
            String outputFileName = JOptionPane.showInputDialog("In welche Datei sollen die Autos exportiert werden?");
            JOptionPane.showMessageDialog(null, "Autos exportiert.");
            handler.exportItem(handler.getCars(), outputFileName);
        });

        customerList.addActionListener(_ -> {
            String output = handler.showList(handler.getCustomers());
            JOptionPane.showMessageDialog(null, output);
        });

        addCustomer.addActionListener(_ -> {
            String name = JOptionPane.showInputDialog("Name des Kunden");
            String mail = JOptionPane.showInputDialog("Mailadresse des Kunden");
            String phone = JOptionPane.showInputDialog("Telefonnummer des Kunden");
            String address = JOptionPane.showInputDialog("Adresse des Kunden");
            int customerID = handler.generateID("Customers");

            Customer customer = new Customer(customerID, name, mail, phone, address);
            handler.addCustomer(customer);

            JOptionPane.showMessageDialog(null, "Der neue Kunde wurde mit der ID " + customerID + " angelegt");
        });

        deleteCustomer.addActionListener(_ -> {
            try {
                int inputID = Integer.parseInt(JOptionPane.showInputDialog("Zum löschen eines Kunden bitte die KundenID eingeben."));
                handler.deleteItem("Customers", inputID);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Eingabe fehlerhaft! Bitte erneut versuchen.");
            }
        });

        customerExport.addActionListener(_ -> {
            String outputFilenname = JOptionPane.showInputDialog("In welche Datei sollen die Kunden exportiert werden?");
            JOptionPane.showMessageDialog(null, "Kunden exportiert.");
            handler.exportItem(handler.getCustomers(), outputFilenname);
        });

        employeeList.addActionListener(_ -> {
            String output = handler.showList(handler.getEmployees());
            JOptionPane.showMessageDialog(null, output);
        });

        addEmployee.addActionListener(_ -> {
            String name = JOptionPane.showInputDialog("Name des Angestellten");
            String department = JOptionPane.showInputDialog("Abteilung des Angestellten");
            String position = JOptionPane.showInputDialog("Position des Angestellten");
            String mail = JOptionPane.showInputDialog("Mailadresse des Angestellten");
            String phone = JOptionPane.showInputDialog("Telefonnummer des Angestellten");

            int employeeID = handler.generateID("Employees");

            Employee employee = new Employee(employeeID, name, department, position, phone, mail);
            handler.addEmployee(employee);

            JOptionPane.showMessageDialog(null, "Der neue Angestellte wurde mit der ID " + employeeID + " angelegt");
        });

        deleteEmployee.addActionListener(_ -> {
            try {
                int inputID = Integer.parseInt(JOptionPane.showInputDialog("Zum löschen eines Mitarbeiters bitte die MitarbeiterID eingeben."));
                handler.deleteItem("Employees", inputID);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Eingabe fehlerhaft! Bitte erneut versuchen.");
            }
        });

        employeeExport.addActionListener(_ -> {
            String outputFileName = JOptionPane.showInputDialog("In welche Datei sollen die Mitarbeiter exportiert werden");
            JOptionPane.showMessageDialog(null, "Mitarbeiter exportiert.");
            handler.exportItem(handler.getEmployees(), outputFileName);
        });

        deleteOrder.addActionListener(_ -> {
            int inputID = Integer.parseInt(JOptionPane.showInputDialog("Zum löschen eines Auftrages bitte die AuftragsID eingeben."));
            handler.deleteItem("Orders", inputID);
        });

        exportOrders.addActionListener(_ -> {
            String outputFileName = JOptionPane.showInputDialog("In welche Datei sollen die Aufträge exportiert werden?");
            String outputFileName2 = JOptionPane.showInputDialog("In welche Datei sollen die abgeschlossenen Aufträge exportiert werden?");
            JOptionPane.showMessageDialog(null, "Aufträge exportiert.");
            handler.exportItem(handler.getOrders(), outputFileName);
            handler.exportItem(handler.getClosedOrders(), outputFileName2);
        });

        closedOrders.addActionListener(_ -> {
            String output = handler.showList(handler.getClosedOrders());
            JOptionPane.showMessageDialog(null, output);
        });

        settings.addActionListener(_ -> openAppearanceSettings(parentFrame));
        return buttonPanel;
    }

    /**
     * Öffnet ein Dialogfeld für die Erscheinungsbildeinstellungen.
     * <p>
     * Diese Methode zeigt ein modales {@link JDialog} an, das es dem Benutzer ermöglicht,
     * das Theme der Anwendung zu ändern. Der Benutzer kann zwischen verschiedenen Themes
     * wählen, die das Erscheinungsbild der GUI beeinflussen.
     * </p>
     *
     * @param parentFrame Das übergeordnete {@link JFrame}, zu dem das Dialogfeld gehört.
     */

    private void openAppearanceSettings(JFrame parentFrame) {
        JDialog settingsDialog = new JDialog(parentFrame, "Erscheinungsbild-Einstellungen", true);
        settingsDialog.setLayout(new FlowLayout());
        settingsDialog.setSize(400, 150);

        JLabel label = new JLabel("Wählen sie ein Theme");
        JButton defaultButton = new JButton("Default");
        JButton darkButton = new JButton("Dark");
        JButton greyButton = new JButton("Grey");

        defaultButton.addActionListener(_ -> setTheme(parentFrame, "Default"));
        darkButton.addActionListener(_ -> setTheme(parentFrame, "Dark"));
        greyButton.addActionListener(_ -> setTheme(parentFrame, "Grey"));

        settingsDialog.add(label);
        settingsDialog.add(defaultButton);
        settingsDialog.add(darkButton);
        settingsDialog.add(greyButton);

        settingsDialog.setVisible(true);

    }

    /**
     * Setzt das Erscheinungsbild der GUI auf das angegebene Theme.
     * <p>
     * Diese Methode ändert die Hintergrund- und Schaltflächenfarben der GUI basierend
     * auf dem ausgewählten Theme. Sie aktualisiert auch die Textfarbe der Schaltflächen.
     * </p>
     *
     * @param frame Das {@link JFrame}, dessen Erscheinungsbild geändert werden soll.
     * @param theme Der Name des Themes, das angewendet werden soll ("Default", "Dark", "Grey").
     */

    private void setTheme(JFrame frame, String theme) {

        Color backgroundColor;
        Color buttonColor;
        Color buttonTextColor;

        switch (theme) {
            case "Dark":
                backgroundColor = Color.DARK_GRAY;
                buttonColor = Color.GRAY;
                buttonTextColor = Color.WHITE;
                break;
            case "Grey":
                backgroundColor = Color.LIGHT_GRAY;
                buttonColor = Color.WHITE;
                buttonTextColor = Color.BLACK;
                break;
            default:
                backgroundColor = null; // Standard-Hintergrund
                buttonColor = null; // Standard-Button-Farbe
                buttonTextColor = Color.BLACK; // Standard-Textfarbe
                break;
        }

        frame.getContentPane().setBackground(backgroundColor);
        for (JButton button : buttons) {
            button.setBackground(buttonColor);
            button.setForeground(buttonTextColor);
        }
        SwingUtilities.updateComponentTreeUI(frame);
    }

}
