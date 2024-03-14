import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ProjectAlarmClock extends JFrame {
    private JTextField textFieldHead1;
    private JTextField textFieldClock;
    private JTextArea textAreaTopic;
    private JButton buttonBackward;
    private JButton buttonForward;
    private JPanel panelMain;
    private JButton buttonPlay;

    public void setProjectData(ProjectData projectData) {
        this.projectData = projectData;
    }

    private ProjectData projectData;
    private final ProjectAlarmClock self = this;

    public ProjectAlarmClock() {
        buttonBackward.addActionListener(e -> {
            textAreaTopic.setText(projectData.getPreviousSheet());
            self.pack();
        });
        buttonForward.addActionListener(e -> {
            textAreaTopic.setText(projectData.getNextSheet());

            self.pack();
        });
        textFieldClock.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(e);
                textAreaTopic.setText("clock clicked");

            }
        });
        buttonPlay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textAreaTopic.setText("play");
            }
        });
    }

    private void formatButton(JButton btn) {

        btn.setBorderPainted(false);
        btn.setFocusPainted(false);
        btn.setContentAreaFilled(false);
        btn.setOpaque(true);

    }

    public void init() {
        this.setContentPane(panelMain);
        this.textFieldClock.setBorder(null);


        this.textFieldHead1.setBorder(null);

        formatButton(buttonForward);
        formatButton(buttonBackward);
        formatButton(buttonPlay);

        Font pressStart2P;
        try {
            pressStart2P = Font.createFont(Font.TRUETYPE_FONT, this.getClass().getResourceAsStream("/fonts/PressStart2P-Regular.ttf"));
            this.textFieldHead1.setFont(pressStart2P.deriveFont(Font.BOLD, 16));

            textFieldClock.setFont(pressStart2P.deriveFont(Font.BOLD, 48));
            textAreaTopic.setFont(pressStart2P.deriveFont(24f));
            buttonForward.setFont(pressStart2P.deriveFont(40f));
            buttonBackward.setFont(pressStart2P.deriveFont(40f));
            // buttonPlay.setFont(pressStart2P.deriveFont(40f));

            // textFieldClock.repaint();
        } catch (FontFormatException | IOException e) {
            throw new RuntimeException(e);
        }
        textFieldHead1.setFocusable(false);
        textFieldClock.setFocusable(false);
        textAreaTopic.setFocusable(false);
        buttonForward.setFocusable(false);
        buttonPlay.setFocusable(false);
        buttonBackward.setFocusable(false);

        this.textAreaTopic.setText(projectData.getPreviousSheet());
        this.pack();

    }
}
