package ViewModels;

import Models.Car;

public class UniqueEntryCarViewModel extends Car {
    int nrOfEntries;

    public  UniqueEntryCarViewModel(String plate,int nrOfEntries){
        super(plate);
        this.nrOfEntries = nrOfEntries;
    }


    @Override
    public String toString() {
        return "UniqueEntryCarViewModel{" +
                "nrOfEntries=" + nrOfEntries +
                ", plate=" + super.getLicensePlate() +
                '}';
    }
}
