package isp.lab10.exercise1.UI;

import isp.lab10.exercise1.Commands.AtcCommand;
import isp.lab10.exercise1.Commands.LandCommand;
import isp.lab10.exercise1.Commands.TakeOffCommand;
import isp.lab10.exercise1.Models.Aircraft;
import isp.lab10.exercise1.Services.IATC;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UI {
    private JButton addAircraftButton;
    private JPanel panel;
    private JTextField aircraftIdTextField;
    private JButton takeOffCommandButton;
    private JButton landCommandButton;
    private JTextField commandAircraftIdTextField;
    private JTextField altitudeTextField;

    private final IATC atcService;


    public UI(IATC atcService) {

        this.atcService = atcService;



        JFrame frame = new JFrame("ATC UI");
        frame.add(panel);
        frame.setVisible(true);


        frame.setLocationRelativeTo(null);
        frame.pack();




        addAircraftButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFrame aircraftFrame = new JFrame("Aircraft");

                Aircraft aircraft = atcService.addAircraft(aircraftIdTextField.getText());




                Thread thread = new Thread(aircraft);



                AircraftUI aircraftUI = new AircraftUI(aircraft);

                aircraftFrame.add(aircraftUI.getPanel1());


                aircraft.addPropertyChangeListener(aircraftUI);

                aircraftFrame.setVisible(true);


                aircraftFrame.setLocationRelativeTo(null);
                aircraftFrame.pack();


                thread.start();




            }
        });
        landCommandButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                atcService.sendCommand(commandAircraftIdTextField.getText(),new LandCommand());
            }
        });
        takeOffCommandButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                int altitude = Integer.parseInt(altitudeTextField.getText());

                atcService.sendCommand(commandAircraftIdTextField.getText(),new TakeOffCommand(altitude));
            }
        });
    }
}
