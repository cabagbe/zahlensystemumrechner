import java.util.Scanner;

public class Main {

    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        boolean continueConversion = true;

        while (continueConversion) {
            int convertFrom = Calculations.getSystemInput("Von welchem Zahlensystem wollen Sie umrechnen?");
            String numberToConvert = userInput(convertFrom);
            int convertedNumber = Calculations.convertToDecimal(numberToConvert, convertFrom);

            int convertTo = Calculations.getSystemInput("Zu welchem Zahlensystem wollen Sie umrechnen?");

            // Überprüfen, ob die Zahlensysteme gleich sind
            if (convertFrom == convertTo) {
                System.out.println("Du hast das gleiche Zahlensystem gewählt... also bleibt die Nummer auch gleich: " + numberToConvert);
            } else {
                String convertedResult = Calculations.convertNumber(convertedNumber, convertTo);
                System.out.println("Die konvertierte Zahl in das gewählte Zahlensystem ist: " + convertedResult);
            }

            // Aufrufen von weiterMachen() um zu entscheiden, ob das Programm fortgesetzt werden soll
            continueConversion = weiterMachen();
        }
    }

    private static String userInput(int convertFrom) {
        boolean validInput = false;
        String numberInput = " ";
        while (!validInput) {
            System.out.println("\n Welche Zahl wollen Sie umrechnen?");
            numberInput = s.nextLine().toUpperCase();  // Für Hexadezimal einfacher zu handhaben

            if (Calculations.isValidNumber(numberInput, convertFrom)) {
                validInput = true;
            } else {
                System.out.println("Ungültige Eingabe für das ausgewählte Zahlensystem. Bitte versuchen Sie es erneut.");
            }
        }
        return numberInput;
    }

    private static boolean weiterMachen() {
        String choice;

        while (true) {
            System.out.println("\n Wollen Sie noch eine Zahl umrechnen?");
            System.out.println("Optionen:");
            System.out.println("1 Ja");
            System.out.println("2 Nein");

            choice = s.nextLine().toLowerCase(); // Eingabe in Kleinbuchstaben umwandeln

            switch (choice) {
                case "1":
                case "ja":
                    return true; // Ja, weiter machen
                case "2":
                case "nein":
                    return false; // Nein, Programm beenden
                default:
                    System.out.println("⚠️ Ungültige Eingabe. Bitte wählen Sie '1' oder '2', oder geben Sie 'ja' oder 'nein' ein.");
            }
        }
    }
}
