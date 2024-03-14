import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {

        ProjectData projectData = new ProjectData();

        ProjectAlarmClock projectAlarmClock = new ProjectAlarmClock();
        projectAlarmClock.setProjectData(projectData);

        projectAlarmClock.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // TODO vorher checken, ob das unterstützt wird.
        // ist auf den Projektrechnern aber der Fall.
        projectAlarmClock.setUndecorated(true);
        projectAlarmClock.setAlwaysOnTop(true);
        projectAlarmClock.setOpacity(0.7f);

        // TODO exakt ausrechnen mit Bildschirmbreite
        projectAlarmClock.setLocation(1100, 50);
        projectAlarmClock.setBackground(new Color(0x88888888));

        projectAlarmClock.init();

        projectAlarmClock.setVisible(true);

    }
}