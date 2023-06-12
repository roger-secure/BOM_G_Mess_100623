import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class LaunchAppFrame extends JFrame {

    public LaunchAppFrame() {
        setTitle("Launch Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        JButton launchButton = new JButton("Launch Calculator");
        launchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                launchTargetApplication();
            }
        });
        panel.add(launchButton);
        add(panel);
    }

    private void launchTargetApplication() {
        String targetAppPath = "/System/Applications/Calculator.app" + //
                ""; // Replace with the actual path to your target application
        File targetAppFile = new File(targetAppPath);

        if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.OPEN)) {
            try {
                Desktop.getDesktop().open(targetAppFile);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error launching application: " + e.getMessage(), "Launch Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Desktop open action is not supported.", "Launch Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        LaunchAppFrame frame = new LaunchAppFrame();
        frame.setVisible(true);
    }
}
