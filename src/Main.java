import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

class MainFrame implements ActionListener {
    JFrame mainFrame = new JFrame();

    Converter converter = new Converter();
    JPanel converterPanel = converter.getConverter();

    SideMenu sideMenu = new SideMenu();
    JPanel sideMenuPanel = sideMenu.getSideMenu();

    public MainFrame() {
        sideMenu.distance.activeButton();
        sideMenu.distanceButton.addActionListener(this);
        sideMenu.temperatureButton.addActionListener(this);
        sideMenu.timeButton.addActionListener(this);

        URL iconUrl = getClass().getClassLoader().getResource("main/resources/icon.png");
        ImageIcon appIcon = new ImageIcon(iconUrl);
        mainFrame.setIconImage(appIcon.getImage());
        mainFrame.setTitle("Ador Converter");
        mainFrame.setLayout(new BorderLayout());
        mainFrame.add(sideMenuPanel, BorderLayout.WEST);
        mainFrame.add(converterPanel, BorderLayout.CENTER);
        mainFrame.setSize(new Dimension(600,500));
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == sideMenu.distanceButton) {
            converter.input.setText("");
            converter.resultLabel.setVisible(false);
            sideMenu.distance.activeButton();
            sideMenu.temperature.disableButton();
            sideMenu.time.disableButton();
            converter.setConversionType("Distance");
        }

        if(e.getSource() == sideMenu.temperatureButton) {
            converter.input.setText("");
            converter.resultLabel.setVisible(false);
            sideMenu.distance.disableButton();
            sideMenu.temperature.activeButton();
            sideMenu.time.disableButton();
            converter.setConversionType("Temperature");
        }

        if(e.getSource() == sideMenu.timeButton) {
            converter.input.setText("");
            converter.resultLabel.setVisible(false);
            sideMenu.distance.disableButton();
            sideMenu.temperature.disableButton();
            sideMenu.time.activeButton();
            converter.setConversionType("Time");
        }
    }
}

class Main {
    public static void main(String[]args){
        new MainFrame();
    }
}