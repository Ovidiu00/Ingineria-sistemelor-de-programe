package isp.lab7.safehome.UI;

import isp.lab7.safehome.DoorLockController;
import isp.lab7.safehome.DoorStatus;
import isp.lab7.safehome.exceptions.InvalidPinException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SafeHouseUI {
    private JTextField accesCodeTextFiled;
    private JButton enterCodeButton;
    private JTextField doorStatusReadOnlyTextField;
    private JPanel panel;

    private DoorLockController doorLockController;

    public void setDoorLockController(DoorLockController doorLockController) {
        this.doorLockController = doorLockController;
    }


    public SafeHouseUI() {

        JFrame frame = new JFrame("titlu");
        frame.add(panel);

        frame.setVisible(true);


        frame.setLocationRelativeTo(null);
        frame.pack();


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        enterCodeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String pinEntered = accesCodeTextFiled.getText();

                try {
                    doorLockController.enterPin(pinEntered);
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(null, exception.getMessage());
                }


                DoorStatus status = doorLockController.getDoorStatus();
                doorStatusReadOnlyTextField.setText(status.name());
            }
        });
    }


}
