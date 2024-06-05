import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

class SideMenuButton {
    JButton button = new JButton();
    JLabel buttonIcon = new JLabel();
    JLabel buttonName = new JLabel();
    GridBagConstraints buttonGBC = new GridBagConstraints();

    public SideMenuButton(String name, String imageUrl) {
        button.setPreferredSize(new Dimension(100,90));
        button.setBackground(null);
        button.setLayout(new GridBagLayout());
        button.setBorder(new EmptyBorder(0,0,0,0));
        buttonGBC.insets = new Insets(5,10,5,10);
        URL url = getClass().getClassLoader().getResource(imageUrl);
        buttonIcon.setIcon(new ImageIcon(new ImageIcon(url).getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH)));
        buttonName.setText(name);
        buttonName.setFont(new Font("Arial", Font.BOLD, 12));
        buttonName.setForeground(Color.white);
        buttonGBC.gridx = 0;
        buttonGBC.gridy = 0;
        button.add(buttonIcon,buttonGBC);
        buttonGBC.gridx = 0;
        buttonGBC.gridy = 1;
        button.add(buttonName,buttonGBC);
    }

    public JButton getButton() {
        return button;
    }

    public void activeButton() {
        button.setBackground(Color.decode("#6600cc"));
    }

    public void disableButton() {
        button.setBackground(null);
    }
}