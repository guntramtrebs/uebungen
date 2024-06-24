import java.util.Scanner;

public class Main {

    public static double readDouble(String[] prompt) {
        Scanner eingabe = new Scanner(System.in);

        while (true) {
            try {
                for (String line : prompt) {
                    System.out.println(line);
                }

                return eingabe.nextDouble();

            } catch (Exception exception) {
                eingabe.nextDouble();
            }
        }
    }

    public static void main(String[] args) {

        // mögliche Geldstücke von 500-Euro-Schein bis 1-cent-Stück
        int[] geldArten = {50000, 20000, 10000, 5000, 2000, 1000, 500, 200, 100, 50, 20, 10, 5, 2, 1};

        int zuZahlen = (int) (100 * readDouble(new String[]{"zu zahlen: "}));
        // int zuZahlen = 23489;

        int bezahlt = (int) (100 * readDouble(new String[]{"bezahlt: "}));
        // int bezahlt = 897624;

        if (bezahlt==zuZahlen) {
            System.out.println("Passt genau, kein Wechselgeld nötig");
            return;
        }

        if (bezahlt<zuZahlen) {
            System.out.println("Zu wenig bezahlt.");
            return;
        }

        System.out.println("zu zahlen: " + "%02f".formatted(zuZahlen/100.0) + " cent");
        System.out.println("bezahlt: " + bezahlt + " cent");

        System.out.println();
        System.out.println("Wechselgeld: ");

        int rueckgeld = bezahlt - zuZahlen;
        for (int geldstueck : geldArten) {
            int anzahl = rueckgeld / geldstueck;
            rueckgeld -= anzahl * geldstueck;
            if (anzahl > 0) {

                String bezeichnung;
                if (geldstueck >= 500) {
                    bezeichnung = (geldstueck / 100) + "€-Schein";
                } else if (geldstueck >= 100) {
                    bezeichnung = (geldstueck / 100) + "€-Stück";
                } else {
                    bezeichnung = geldstueck + "-cent-Stück";
                }

                System.out.println(anzahl + "x " + bezeichnung);
            }
        }
    }
}