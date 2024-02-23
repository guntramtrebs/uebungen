import java.util.InputMismatchException;
import java.util.Scanner;

public class BodyMassIndex {
    public static void main(String[] args) {

        // Körpergröße in cm
        double groesse;

        // Gewicht in kg
        double gewicht;

        // Geschlecht
        char geschlecht;

        // Body Mass Index
        double bmi;

        gewicht = leseGewicht();
        groesse = leseGroesse();
        geschlecht = leseGeschlecht();

        bmi = bodyMassIndex(gewicht, groesse);

        System.out.println("------------------------");
        System.out.println("Gewicht: " + gewicht);
        System.out.println("Körpergröße: " + groesse);
        System.out.println("Geschlecht: " + geschlecht);

        System.out.println("BMI: " + bmi);

        double untergewicht;
        double normalgewicht;
        double uebergewicht;

        switch (geschlecht) {
            case 'w':
                untergewicht = 19.0;
                normalgewicht = 24.5;
                uebergewicht = 30.0;
                break;
            default:
                untergewicht = 20.0;
                normalgewicht = 25.5;
                uebergewicht = 30.0;
        }

        if (bmi < untergewicht) {
            System.out.println("Grobe Diagnose: Untergewicht");
        } else if (bmi < normalgewicht) {
                    System.out.println("Grobe Diagnose: Normalgewicht");
        } else if (bmi < uebergewicht) {
            System.out.println("Grobe Diagnose: Übergewicht");
        } else {
            System.out.println("Grobe Diagnose: Behandlung empfohlen");
        }

    }


    public static double leseGewicht() {
        Scanner scanner = new Scanner(System.in);

        double gewicht = 0.0;
        boolean gewichtOK = false;
        // Größe erfragen

        while (!gewichtOK) {
            System.out.print("Bitte gib das Gewicht in kg ein [2-500]: ");

            try {
                gewicht = scanner.nextDouble();
            } catch(InputMismatchException ime) {
                scanner.nextLine();
                System.out.println("Eingabe nicht korrekt, bitte nochmal versuchen");

                continue;
            }

            if (gewicht < 2) {
                System.out.println("Das Gewicht ist zu klein.");
                continue;
            }

            if (gewicht > 500) {
                System.out.println("Das Gewicht ist zu groß.");
                continue;
            }



            gewichtOK = true;
        }

        return gewicht;
    }



    public static double leseGroesse() {
        Scanner scanner = new Scanner(System.in);

        double groesse = 0.0;
        boolean groesseOk = false;
        // Größe erfragen

        while (!groesseOk) {
            System.out.print("Bitte gib die Körpergröße in cm ein [20-250]: ");

            try {
                groesse = scanner.nextDouble();
            } catch(InputMismatchException ime) {
                scanner.nextLine();
                System.out.println("Eingabe nicht korrekt, bitte nochmal versuchen");

                continue;
            }

            if (groesse < 20) {
                System.out.println("Die Körpergröße ist zu klein.");
                continue;
            }

            if (groesse > 250) {
                System.out.println("Die Körpergröße ist zu groß.");
                continue;
            }
            groesseOk = true;
        }

        return groesse;
    }


    public static char leseGeschlecht() {
        Scanner scanner = new Scanner(System.in);

        String geschlecht;


        while (true) {
            System.out.print("Bitte gib das Geschlecht ein [m/w]: ");

            try {
                geschlecht = scanner.nextLine();
            } catch(InputMismatchException ime) {
                scanner.nextLine();
                System.out.println("Eingabe nicht korrekt, bitte nochmal versuchen");

                continue;
            }

            if (geschlecht.equalsIgnoreCase("w")) {
                System.out.println("Das Geschlecht ist weiblich.");
                return 'w';
            }

            if (geschlecht.equalsIgnoreCase("m")) {
                System.out.println("Das Geschlecht ist männlich.");
                return 'm';
            }
        }
    }


    /**
     *
     * @param gewicht double in kg
     * @param groesse in cm
     * @return double Body Mass Index
     */
    public static double bodyMassIndex(double gewicht, double groesse) {
        return gewicht * 10000 / (groesse * groesse);
    }


}
