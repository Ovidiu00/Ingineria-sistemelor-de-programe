package ViewModels;

import Models.Car;

import java.io.Serializable;
import java.time.LocalDateTime;

public class CarRecordViewModel extends Car implements Serializable {
    public LocalDateTime entryTime;
    public LocalDateTime exitTime;


    public CarRecordViewModel(){

    }

   public CarRecordViewModel(String plate,LocalDateTime entryTime,LocalDateTime exitTime){
       super(plate);
       this.entryTime = entryTime;
       this.exitTime = exitTime;
   }

}
