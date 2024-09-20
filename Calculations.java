import java.util.Scanner;

public class Calculations {

    static Scanner s = new Scanner(System.in);

    // Zahlensystem bekommen & validieren

    public static int getSystemInput(String message) {

        boolean validInput = false;
        int system = 0;

        while (!validInput) {

            System.out.println("\n" + message);
            System.out.println("Optionen:");
            System.out.println("➔ 1 Dezimalsystem");
            System.out.println("➔ 2 Binärsystem");
            System.out.println("➔ 3 Oktalsystem");
            System.out.println("➔ 4 Hexadezimalsystem");

            String userInput = s.nextLine().toLowerCase();   // Lowercase, damit es weniger cases sind

            switch (userInput) {
                case "1":
                case "dezimal":
                case "dezimalsystem":
                    System.out.println("Sie haben das Dezimalsystem ausgewählt.");
                    system = 1;
                    validInput = true;
                    break;
                case "2":
                case "binär":
                case "binärsystem":
                    System.out.println("Sie haben das Binärsystem ausgewählt.");
                    system = 2;
                    validInput = true;
                    break;
                case "3":
                case "oktal":
                case "oktalsystem":
                    System.out.println("Sie haben das Oktalsystem ausgewählt.");
                    system = 3;
                    validInput = true;
                    break;
                case "4":
                case "hexa":
                case "hexadezimal":
                case "hexadezimalsystem":
                    System.out.println("Sie haben das Hexadezimalsystem ausgewählt.");
                    system = 4;
                    validInput = true;
                    break;
                default:
                    System.out.println("⚠️ Ungültige Eingabe. Geben Sie eine gültige Zahl oder das Wort ein.");
                    break;
            }
        }
        return system;
    }

    // Methode um sicherzustellen, dass die Nummer gültig ist

    public static boolean isValidNumber(String number, int system) {

        return switch (system) {

            case 1 -> // Dezimalsystem: Alle Ziffern sind erlaubt

                    number.matches("[0-9]+");

            case 2 -> // Binärsystem: Nur 0 und 1

                    number.matches("[01]+");

            case 3 -> // Oktalsystem: Nur Ziffern von 0 bis 7

                    number.matches("[0-7]+");

            case 4 -> // Hexadezimalsystem: Ziffern 0-9 und Buchstaben A-F

                    number.matches("[0-9A-F]+");

            default -> false;
        };
    }

    // Methode, die die Nummer in das Dezimalsystem umwandelt, um es besser zu verrechnen

    public static int convertToDecimal(String number, int system) {

        return switch (system) {

            case 1 -> // Dezimalsystem

                    Integer.parseInt(number);

            case 2 -> // Binärsystem

                    Integer.parseInt(number, 2);  // Basis 2

            case 3 -> // Oktalsystem

                    Integer.parseInt(number, 8);  // Basis 8

            case 4 -> // Hexadezimalsystem

                    Integer.parseInt(number, 16);  // Basis 16

            default -> 0;
        };
    }

    // Nummer wird jetzt in das erwünschte System umgewandelt

    public static String convertNumber(int number, int system) {

        return switch (system) {

            case 1 -> // Dezimalsystem

                    String.valueOf(number);

            case 2 -> // Binärsystem

                    Integer.toBinaryString(number);

            case 3 -> // Oktalsystem

                    Integer.toOctalString(number);

            case 4 -> // Hexadezimalsystem

                    Integer.toHexString(number).toUpperCase();

            default -> "Ungültige Option.";

        };
    }
}
