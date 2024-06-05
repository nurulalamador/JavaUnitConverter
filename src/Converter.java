import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

class Converter implements ActionListener {
    ConvertFunction cf = new ConvertFunction();
    DecimalFormat df = new DecimalFormat("#.####");
    JPanel container = new JPanel();
    GridBagConstraints C = new GridBagConstraints();
    JLabel titleLabel = new JLabel();
    JTextField input = new JTextField();
    JComboBox inputUnit = new JComboBox();
    JComboBox outputUnit = new JComboBox();
    String currentType = "Distance";

    JLabel resultLabel = new JLabel();

    String distanceUnit[] = {"Kilometer","Meter","Centimeter","Mile","Inch","Yard","Foot"};
    String temperatureUnit[] = {"Celsius","Fahrenheit","Kelvin"};
    String timeUnit[] = {"Nanosecond","Microsecond","Millisecond","Second","Minute","Hour","Day","Week","Month","Year"};

    public Converter() {
        C.insets = new Insets(5,5,5,5);
        container.setBackground(Color.decode("#EEEEEE"));
        container.setLayout(new GridBagLayout());

        titleLabel.setText("Convert Distance");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setPreferredSize(new Dimension(300, 40));
        titleLabel.setFont(new Font("Arial", Font.BOLD, 25));
        C.gridx = 0;
        C.gridy = 0;
        C.gridwidth = 2;
        container.add(titleLabel,C);


        input.setPreferredSize(new Dimension(100, 40));
        input.setBackground(Color.white);
        input.setForeground(Color.black);
        input.setBorder(new EmptyBorder(10,10,10,10));
        input.setFont(new Font("Arial", Font.PLAIN, 16));
        C.gridx = 0;
        C.gridy = 1;
        C.gridwidth = 2;
        C.fill = GridBagConstraints.HORIZONTAL;
        container.add(input,C);

        JLabel inputLabel = new JLabel("Convert From");
        inputLabel.setPreferredSize(new Dimension(120, 40));
        inputLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        C.gridx = 0;
        C.gridy = 2;
        C.gridwidth = 1;
        container.add(inputLabel,C);


        inputUnit.setModel(new DefaultComboBoxModel(distanceUnit));
        inputUnit.setBackground(Color.white);
        inputUnit.setForeground(Color.black);
        inputUnit.setPreferredSize(new Dimension(200, 40));
        C.gridx = 1;
        C.gridy = 2;
        container.add(inputUnit,C);

        JLabel outputLabel = new JLabel("Convert To");
        outputLabel.setPreferredSize(new Dimension(120, 40));
        outputLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        C.gridx = 0;
        C.gridy = 3;
        container.add(outputLabel,C);

        outputUnit.setModel(new DefaultComboBoxModel(distanceUnit));
        outputUnit.setBackground(Color.white);
        outputUnit.setForeground(Color.black);
        outputUnit.setPreferredSize(new Dimension(200, 40));
        C.gridx = 1;
        C.gridy = 3;
        container.add(outputUnit,C);

        JButton convert = new JButton("Convert");
        convert.setPreferredSize(new Dimension(200, 50));
        convert.setBackground(Color.decode("#7F00FF"));
        convert.setForeground(Color.white);
        convert.setFocusPainted(false);
        convert.setBorder(new EmptyBorder(10,10,10,10));
        convert.setFont(new Font("Arial", Font.BOLD, 18));
        convert.addActionListener(this);
        C.gridx = 0;
        C.gridy = 4;
        C.gridwidth = 2;
        container.add(convert,C);


        resultLabel.setPreferredSize(new Dimension(100, 50));
        resultLabel.setBackground(Color.decode("#CCCCCC"));
        resultLabel.setOpaque(true);
        resultLabel.setForeground(Color.black);
        resultLabel.setBorder(new EmptyBorder(20,20,20,20));
        resultLabel.setFont(new Font("Arial", Font.ITALIC, 16));
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
        resultLabel.setVisible(false);

        C.gridx = 0;
        C.gridy = 5;
        C.gridwidth = 2;
        C.fill = GridBagConstraints.HORIZONTAL;
        container.add(resultLabel,C);
    }

    public JPanel getConverter() {
        return container;
    }

    public void setConversionType(String conversionType){
        titleLabel.setText("Convert "+conversionType);
        currentType = conversionType;

        if(conversionType == "Distance") {
            inputUnit.setModel(new DefaultComboBoxModel(distanceUnit));
            outputUnit.setModel(new DefaultComboBoxModel(distanceUnit));
        }
        if(conversionType == "Temperature") {
            inputUnit.setModel(new DefaultComboBoxModel(temperatureUnit));
            outputUnit.setModel(new DefaultComboBoxModel(temperatureUnit));
        }
        if(conversionType == "Time") {
            inputUnit.setModel(new DefaultComboBoxModel(timeUnit));
            outputUnit.setModel(new DefaultComboBoxModel(timeUnit));
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            resultLabel.setBackground(Color.decode("#CCCCCC"));
            resultLabel.setForeground(Color.black);
            resultLabel.setVisible(true);
            if(inputUnit.getSelectedItem() == outputUnit.getSelectedItem()) {
                resultLabel.setText(input.getText()+" "+inputUnit.getSelectedItem()+" = "+df.format(Double.parseDouble(input.getText()))+" "+outputUnit.getSelectedItem());
            }
            else {
                double convertedValue = cf.Convert(currentType,Double.parseDouble(input.getText()), inputUnit.getSelectedItem(), outputUnit.getSelectedItem());
                resultLabel.setText(input.getText()+" "+inputUnit.getSelectedItem()+" = "+df.format(convertedValue)+" "+outputUnit.getSelectedItem());
            }
        }
        catch (Exception e1){
            resultLabel.setBackground(Color.red);
            resultLabel.setForeground(Color.white);
            if(e1.getMessage() == "empty String") {
                resultLabel.setText("Please Write Any Number!");
            }
            else {
                resultLabel.setText("Please Write Only Number!");
            }
        }
    }
}
