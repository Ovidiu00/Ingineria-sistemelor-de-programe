package isp.lab6.exercise2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EquipmentController {

    private List<Equipment> equipments = new ArrayList<>();

    /**
     * Add new equipment to the list of equipments
     *
     * @param equipment - equipment to be added
     */
    public void addEquipment(final Equipment equipment) {
        equipments.add(equipment);
    }

    /**
     * Get current list of equipments
     *
     * @return list of equipments
     */
    public List<Equipment> getEquipments() {
        return equipments;
    }

    /**
     * Get number of equipments
     *
     * @return number of equipments
     */
    public int getNumberOfEquipments() {
       return equipments.size();


    }

    /**
     * Group equipments by owner
     *
     * @return a dictionary where the key is the owner and value is represented by list of equipments he owns
     */
    public Map<String, List<Equipment>> getEquipmentsGroupedByOwner() {
        Map<String, List<Equipment>> resultDictionary = new HashMap<>();

        for (int i = 0; i < equipments.size(); i++) {

            String owner = equipments.get(i).getOwner();
            if (resultDictionary.containsKey(owner) == false) {

                List<Equipment> equipmentsForOwner = new ArrayList<>();
                for (int j = i ; j < equipments.size(); j++) {
                    if (equipments.get(j).getOwner().equals(owner)){
                        equipmentsForOwner.add(equipments.get(j));
                    }
                }


                resultDictionary.put(owner, equipmentsForOwner);

            }


        }
        return  resultDictionary;
    }

    /**
     * Remove a particular equipment from equipments list by serial number
     *
     * @param serialNumber - unique serial number
     * @return deleted equipment instance or null if not found
     */
    public Equipment removeEquipmentBySerialNumber(final String serialNumber) {

        for(Equipment equipment : equipments){
            if(equipment.getSerialNumber().equals(serialNumber)){

                equipments.remove(equipment);
                return  equipment;
            }
        }

        return  null;
    }
}
