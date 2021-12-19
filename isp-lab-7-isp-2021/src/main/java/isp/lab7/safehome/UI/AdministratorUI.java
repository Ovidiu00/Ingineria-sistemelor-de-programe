package isp.lab7.safehome.UI;

import isp.lab7.safehome.DoorLockController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdministratorUI {
    private JTextField nameTextField;
    private JTextField pinTextField;
    private JButton addTenantButton;
    private JList tenantList;
    private JButton deleteTnantButton;
    private JPanel adminPanel;

    private DoorLockController controller;

    private  DefaultListModel listModel = new DefaultListModel();
;

    public void setController(DoorLockController controller) {
        this.controller = controller;
    }

    public AdministratorUI() {

        JFrame frame = new JFrame("titlu");
        frame.add(adminPanel);

        frame.setVisible(true);


        frame.setLocationRelativeTo(null);
        frame.pack();





        addTenantButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    controller.addTenant(pinTextField.getText(), nameTextField.getText());
                }
                catch (Exception exception){
                    JOptionPane.showMessageDialog(null,exception.getMessage());
                    return;
                }


                tenantList.setModel(listModel);

            listModel.add(listModel.getSize(),nameTextField.getText());

            }
        });
        deleteTnantButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                String nume = (String)tenantList.getSelectedValue();
                int index = tenantList.getSelectedIndex();

                try {
                    controller.removeTenant(nume);
                }
                catch (Exception exception){
                    JOptionPane.showMessageDialog(null,exception.getMessage());
                    return;
                }

                ((DefaultListModel)tenantList.getModel()).remove(index);
            }
        });
    }
}
