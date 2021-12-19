package Exercise2;

import Exercise2.Sensors.HumiditySensor;
import Exercise2.Sensors.PressureSensor;
import Exercise2.Sensors.TemperatureSensor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientUI {
    private JButton temperatureButton;
    private JPanel panel1;
    private JButton humidityButton;
    private JButton pressureButton;
    private JTextField pressureTextField;
    private JTextField temperatureTextField;
    private JTextField humidityTextField;

    SensorController controller;

    public ClientUI(SensorController controller, TemperatureSensor temperatureSensor, HumiditySensor humiditySensor, PressureSensor pressureSensor) {
        this.controller = controller;

        JFrame frame = new JFrame("titlu");
        frame.add(panel1);

        frame.setVisible(true);

        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        humidityButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                humiditySensor.readSensor();



            }
        });
        temperatureButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
