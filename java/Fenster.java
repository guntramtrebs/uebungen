import javax.swing.*;
import java.awt.*;

public class Fenster extends JFrame {
    private Sternenpfad pfad;


    public Fenster() {
        setSize(400, 400);
        setTitle("Mein Erstes Fenster");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setVisible(true);
    }




    @Override
    public void paint(Graphics g) {

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());


        g.setColor(Color.RED);
        g.fillRect(10, 60, 100,50);

        g.setColor(Color.GREEN);
        g.fillOval(100,200,80,80);

        g.setColor(Color.GRAY);
        int[] xKoords = {150, 270, 150};
        int[] yKoords = {180, 350, 350};
        g.fillPolygon(xKoords, yKoords, xKoords.length);


        g.setColor(Color.BLUE);
        g.fillRect(100, 100, 200, 200);

        // Koordinaten für Sternenpfad berechnen
        pfad = new Sternenpfad(200, 200, 40, 100, 5, 15 );

        xKoords = pfad.getXKoordinaten();
        yKoords = pfad.getYKoordinaten();

        // Debug: grüne Kreise mit ansteigendem Radius um die Ecken
        /*
        g.setColor(Color.GREEN);
        for (int i = 0; i < xKoords.length; i++) {
            g.fillOval(xKoords[i]-2*i-4, yKoords[i]-2*i-4, 4*i+8, 4*i+8);
        }
        */

        g.setColor(Color.YELLOW);
        g.fillPolygon(xKoords, yKoords, xKoords.length);

    }

    public static void main(String[] args) {
        Fenster f = new Fenster();
    }


}

class Sternenpfad {

    private int ecken = 7;
    private int x = 200;
    private int y = 200;

    private int innererRadius = 50;

    private int aeussererRadius = 100;

    // Drehung entg. Uhzeigersinn in Grad
    private double versatz = 0;

    /**
     *
     * @param x x-Koordinate des Mittelpunktes
     * @param y y-Koordinate des Mittelpunktes
     * @param innererRadius Radius der inneren Punkte
     * @param aeussererRadius Radius der äußeren Punkte
     * @param ecken Anzahl der Ecken
     * @param versatz in Grad
     *

     * gibt die x- und y-Pfade zum Zeichnen eines Sterns zurück

     * Der erste Punkt ist rechts vom Mittelpunkt. Der Pfad löuft entgegen des Uhrzeigersinns.
     * Der Versatz dreht den Stern zusätzlich entgegen des Uhrzeigersinns.
     */

    public Sternenpfad(int x, int y, int innererRadius, int aeussererRadius, int ecken, double versatz) {
        this.x = x;
        this.y = y;
        this.innererRadius = innererRadius;
        this.aeussererRadius = aeussererRadius;
        this.ecken = ecken;

        // Umrechnung von Grad in Bogenmaß
        this.versatz = 2* Math.PI * versatz / 360;
    }

    int[] getXKoordinaten() {

        // für jede Ecke ein äußerer und ein innerer Punkt
        int[] koordinaten = new int[this.ecken*2];
        for (int i = 0; i < this.ecken; i++) {
            //äußerer Punkt
            double winkel = Math.PI/this.ecken * i * 2;
            System.out.println("Winkel: " + Math.round(360* winkel / 2 / Math.PI));
            koordinaten[2*i] =  this.x +
                    (int) Math.round(
                            Math.cos(winkel)
                                    * this.aeussererRadius
                    );

            // innerer Punkt
            winkel = Math.PI/this.ecken * (i * 2 +1);
            System.out.println("Winkel: " + Math.round(360* winkel / 2 / Math.PI));
            koordinaten[2*i+1] = this.x +
                    (int) Math.round(
                            Math.cos(winkel)
                                    * this.innererRadius
                    );

        }
        return koordinaten;
    }

    // für jede Ecke ein äußerer und ein innerer Punkt
    int[] getYKoordinaten() {
        int[] koordinaten = new int[this.ecken*2];
        for (int i = 0; i < this.ecken; i++) {
            // äußerer Punkt
            double winkel = Math.PI/this.ecken * i * 2;
            System.out.println("Winkel: " + Math.round(360* winkel / 2 / Math.PI));
            koordinaten[2 * i] =
                    this.y
                            - (int) Math.round(
                            Math.sin(winkel) * this.aeussererRadius
                    );

            // innerer Punkt
            winkel = Math.PI/this.ecken * (i * 2 +1);
            System.out.println("Winkel: " + Math.round(360* winkel / 2 / Math.PI));
            koordinaten[2 * i + 1] =
                    this.y
                            - (int) Math.round(
                            Math.sin(winkel) * this.innererRadius
                    );


            int test = (int) Math.round(4.5f);
        }
        return koordinaten;
    }
}