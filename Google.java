import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Desktop;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.net.URI;


public class Google implements ActionListener {
    JTextField input;
    JLabel instructions;
    public Google () {
        Color color = new Color(0, 17, 141);
        Color backColor = new Color(97, 116, 225);
        JLabel title = new JLabel("Google");
        title.setFont(new Font("Verdana", Font.BOLD, 30));
        title.setForeground(color);
        title.setBackground(backColor);
        title.setOpaque(true);
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        JLabel spacing = new JLabel();
        instructions = new JLabel("Search Google: ");
        input = new JTextField();
        JButton button = new JButton("Search");
        button.addActionListener(this);
        panel.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
        panel.setLayout(new GridLayout(0, 2));
        panel.add(title);
        panel.add(spacing);
        panel.add(instructions);
        panel.add(input);
        panel.add(button);
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Search Google");
        frame.pack();
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        new Google();
    }
    @Override
    public void actionPerformed(ActionEvent arg0) {
        String searchGoogle = input.getText();
        String[] arrSearch = searchGoogle.split("");
        for (int i = 0; i < arrSearch.length; i++) {
            if (arrSearch[i].equals(" ")) {
                arrSearch[i] = "+";
            } else if (arrSearch[i].equals("+")) {
                arrSearch[i] = "%2B";
            }
        }
        String joinText = "https://www.google.com/search?q=" + String.join("", arrSearch);
        try {
            Desktop desktop = Desktop.getDesktop();
            URI input = new URI(joinText);
            desktop.browse(input);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
