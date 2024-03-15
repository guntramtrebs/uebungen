public class ProjectData {

    // TODO stattdessen Listener
    public void setProjectAlarmClock(ProjectAlarmClock projectAlarmClock) {
        this.projectAlarmClock = projectAlarmClock;
    }

    ProjectAlarmClock projectAlarmClock;


    /*
    Der Countdown ist initial bei 600.000 ms (10 Minuten) gestoppt.
    Zustandsvariablen der Countdown-Uhr:
    clockIsRunning - wahr, wenn Countdown läuft. Falsch, wenn gestoppt.
    lastStop - Zeitpunkt des letzten Stopp in ms Systemzeit
    lastStart - Zeitpunkt des letzten Starts in ms Systemzeit
     */

    private boolean clockIsRunning = false;

    private long countDown = 600000;

    // als wenn der Countdown jetzt (in der gleichen ms) einmal gestartet und dann gestoppt wäre
    private long lastStop = System.currentTimeMillis();
    private long lastStart = lastStop;

    private long nextFinish;

    private final String[] sheets = {"""
        bla
        bla
        bla
          """, """
        ble
        ble
        ble
""", """
    bli
    bli
    bli
    """, """
blo
blo
blo
""", """
blu
blu
blu
"""};

    public String getNextSheet() {
        if (sheetCounter < sheets.length - 1) {
            sheetCounter++;
        }
        return (sheetCounter + 1) + "/" + sheets.length + "\n" + sheets[sheetCounter];
    }

    public String getPreviousSheet() {
        if (sheetCounter > 0) {
            sheetCounter--;
        }
        return (sheetCounter + 1) + "/" + sheets.length + "\n" + sheets[sheetCounter];
    }

    public void tick() {

        if (clockIsRunning) {
            countDown = nextFinish - System.currentTimeMillis();

            projectAlarmClock.setClock((int) (countDown / 1000));
        }
    }

    // TODO stop count down
    public void  startCountDown() {
        synchronized (this) {
            if (!clockIsRunning) {
                clockIsRunning = true;
                nextFinish = System.currentTimeMillis() + countDown;
            }
        }
    }

    public void stopCountDown() {
        if (clockIsRunning) {
            lastStop = System.currentTimeMillis();
        }
    }


    private int sheetCounter = 0;

}
