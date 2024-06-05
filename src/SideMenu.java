import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SideMenu implements ActionListener {

    JPanel sideMenu = new JPanel();
    SideMenuButton distance = new SideMenuButton("Distance","main/resources/distance.png");
    JButton distanceButton = distance.getButton();
    SideMenuButton temperature = new SideMenuButton("Temperature", "main/resources/temperature.png");
    JButton temperatureButton = temperature.getButton();
    SideMenuButton time = new SideMenuButton("Time","main/resources/time.png");
    JButton timeButton = time.getButton();

    GridBagConstraints sideMenuGBC = new GridBagConstraints();

    public SideMenu() {
        sideMenuGBC.insets = new Insets(5,5,5,5);

        sideMenu.setLayout(new GridBagLayout());
        sideMenu.setBackground(Color.decode("#7F00FF"));

        sideMenuGBC.gridx = 0;
        sideMenuGBC.gridy = 0;
        sideMenu.add(distanceButton,sideMenuGBC);

        sideMenuGBC.gridx = 0;
        sideMenuGBC.gridy = 1;
        sideMenu.add(temperatureButton,sideMenuGBC);

        sideMenuGBC.gridx = 0;
        sideMenuGBC.gridy = 2;
        sideMenu.add(timeButton,sideMenuGBC);
    }

    public JPanel getSideMenu() {
        return sideMenu;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
