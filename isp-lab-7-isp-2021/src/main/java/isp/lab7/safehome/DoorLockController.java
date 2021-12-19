package isp.lab7.safehome;

import isp.lab7.safehome.exceptions.InvalidPinException;
import isp.lab7.safehome.exceptions.TenantAlreadyExistsException;
import isp.lab7.safehome.exceptions.TenantNotFoundException;
import isp.lab7.safehome.exceptions.TooManyAttemptsException;

import java.time.LocalDateTime;
import java.util.*;

public class DoorLockController implements  ControllerInterface{
    private Door door;
    private List<AccesLog> accesLogs;
    private Map<Tenant,AccesKey> validAcces = new HashMap<>();

    private Integer currentTries = 0;
    private  final Integer maxTries = 3;


    public DoorStatus getDoorStatus(){
        return door.getStatus();
    }

    public DoorLockController(Door door, List<AccesLog> accesLogs) {
        this.door = door;
        this.accesLogs = accesLogs;

        this.validAcces.put(new Tenant(ControllerInterface.MASTER_TENANT_NAME),new AccesKey(ControllerInterface.MASTER_KEY));
    }

    private Optional<Map.Entry<Tenant,AccesKey>> GetCurrentTenantPinPair(String pin){

       return validAcces.entrySet().stream().
                filter(tennantAccesKeyPair -> tennantAccesKeyPair.getValue().getPin().equals(pin)).findFirst();

    }
    @Override
    public DoorStatus enterPin(String pin) throws Exception {

      Optional<Map.Entry<Tenant,AccesKey>> currentTenantAccesKeyPair = GetCurrentTenantPinPair(pin);

      if(!currentTenantAccesKeyPair.isPresent()){     //pin gresit
          currentTries++;
          if(currentTries >= maxTries){
              this.accesLogs.add(new AccesLog("", LocalDateTime.now() , "Enter PIN",this.door.getStatus(),"Too many attempts!"));

              throw new TooManyAttemptsException();
          }
          else{
              this.accesLogs.add(new AccesLog("", LocalDateTime.now() , "Enter PIN",this.door.getStatus(),"Invalid Pin!"));

              throw new InvalidPinException(pin);
          }
      }
      else {  //pin corect

          if(currentTenantAccesKeyPair.get().getKey().getName().equals(ControllerInterface.MASTER_TENANT_NAME)){
              currentTries = 0;
          }

          if(currentTries >= maxTries){
              this.accesLogs.add(
                      new AccesLog(currentTenantAccesKeyPair.get().getKey().getName(), LocalDateTime.now() , "Enter PIN",this.door.getStatus(),"Too many attempts!"));

              throw new TooManyAttemptsException();
          }

          this.accesLogs.add(
                  new AccesLog(currentTenantAccesKeyPair.get().getKey().getName(), LocalDateTime.now() , "Enter PIN",this.door.getStatus(),""));


          if(door.getStatus() == DoorStatus.CLOSE){
              door.unlockDoor();
          }
          else{
              door.lockDoor();
          }



      }

      return  this.door.getStatus();

    }

    @Override
    public void addTenant(String pin, String name) throws Exception {

        Tenant tenant = new Tenant(name);

       if(this.validAcces.containsKey(tenant)){
            this.accesLogs.add(new AccesLog(name,LocalDateTime.now(),"Add tenant",this.door.getStatus(),"Tenant already exists!"));
            throw  new TenantAlreadyExistsException(name);
        }


        this.accesLogs.add(new AccesLog(name,LocalDateTime.now(),"Add tenant",this.door.getStatus(),""));
        this.validAcces.put(tenant, new AccesKey(pin));


    }

    @Override
    public void removeTenant(String name) throws Exception {

        Tenant tenant = new Tenant(name);

        if(!this.validAcces.containsKey(tenant)){
            this.accesLogs.add(new AccesLog(name,LocalDateTime.now(),"Remove tenant",this.door.getStatus(),"Tenant doesnt exist!"));
            throw  new TenantNotFoundException(name);
        }


        this.accesLogs.add(new AccesLog(name,LocalDateTime.now(),"Remove tenant",this.door.getStatus(),""));
        this.validAcces.remove(tenant);

    }


}
