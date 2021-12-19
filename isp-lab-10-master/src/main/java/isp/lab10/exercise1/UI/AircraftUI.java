package isp.lab10.exercise1.UI;

import javax.swing.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class AircraftUI implements PropertyChangeListener {
    private JPanel panel1;
    private JLabel stateLabel;
    private JLabel currentAltitudeLabel;
    private JLabel cruisingTimeLabel;


    private String currentState;
    private String currentAltitude;
    private String cruisingTime;

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

        String propertyName = evt.getPropertyName();

        switch (propertyName)
        {
            case "currentState" :
                this.currentState = evt.getNewValue().toString();
                break;

            case "currentAltitude" :
                this.currentAltitude = evt.getNewValue().toString();
                break;


            case "cruisingTime":
                this.cruisingTime = evt.getNewValue().toString();
                break;


        }
        this.stateLabel.setText(currentState);
        this.currentAltitudeLabel.setText(currentAltitude);
        this.cruisingTimeLabel.setText(cruisingTime);


    }

    public JPanel getPanel1() {
        return panel1;
    }


    private isp.lab10.exercise1.Models.Aircraft aircraft;


    public AircraftUI(isp.lab10.exercise1.Models.Aircraft aircraft) {
        this.aircraft = aircraft;
    }

}
