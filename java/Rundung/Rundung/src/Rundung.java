public class Rundung {

    // der Algorithmus ist mathematisch korrekt, kommt aber wegen der Rundungsfehler mit double durcheinander
    public static void printRueckgeld1(double rueckgeld) {
        double[] muenzen = { 0.50, 0.20, 0.10, 0.05, 0.02, 0.01};

        System.out.print("Rückgeld für " + rueckgeld + "€: ");
        for (double muenze: muenzen) {
            int anzahl = 0;

            while (rueckgeld >= muenze) {
                anzahl++;
                rueckgeld -= muenze;
            }

            System.out.print(anzahl + "×" + ((int)(100*muenze)) + "c ");
        }
        System.out.println(", Rest: " + rueckgeld + (rueckgeld>0.005?" !!! ":""));
    }

    // der Algorithmus ist mathematisch korrekt, kommt aber wegen der Rundungsfehler mit double durcheinander
    // Alternative
    public static void printRueckgeld2(double rueckgeld) {
        double[] muenzen = { 0.50, 0.20, 0.10, 0.05, 0.02, 0.01};

        System.out.print("Rückgeld für " + rueckgeld + "€: ");
        for (double muenze: muenzen) {
            int anzahl = (int) Math.floor (rueckgeld/muenze);

            rueckgeld -= anzahl * muenze;

            System.out.print(anzahl + "×" + ((int)(100*muenze)) + "c ");
        }
        System.out.println(", Rest: " + rueckgeld + (rueckgeld>0.005?" !!! ":""));
    }

    public static void main(String[] args) {

        // gibt aus: Rundungsfehler
        if (0.7 + 0.1 == 0.8) {
            System.out.println("0.7 + 0.1 == 0.8");
        } else {
            System.out.println("0.7 + 0.1 != 0.8");
        }

        // d: -1.1102230246251565E-16 (ca. -1 * 10^-16)
        double d = 9 / 100.0 * 10 - 90 / 100.0;
        System.out.println("9 / 100.0 * 10 - 90 / 100.0: " + d);

        double d1 = 100 + d;

        System.out.println((100 == d1) ?
                "100 -1.1102230246251565E-16 == 100" :
                "100 -1.1102230246251565E-16 != 100");



        System.out.println("printRueckgeld1():");
        printRueckgeld1(0.03);
        printRueckgeld1(0.02);

        System.out.println();
        System.out.println("printRueckgeld2():");
        printRueckgeld2(0.03);
        printRueckgeld2(0.02);

        System.out.println();
        System.out.println("3 cent minus 2 cent (0,03 - 0,02): " + (0.03 - 0.02));

        System.out.println();
        System.out.println("Rückgeld für 100 - 0 cent");

        for (int cent = 100; cent >= 0; cent--) {
            printRueckgeld1(cent/100.0);
            printRueckgeld2(cent/100.0);
        }


    }
}
