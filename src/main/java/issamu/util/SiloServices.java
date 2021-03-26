package issamu.util;

import java.util.ArrayList;

import issamu.model.Rent;
import issamu.model.Silo;

public class SiloServices extends Services{
    
    public static boolean delete(Silo silo){
        ArrayList<Silo> nowList = listReader(DataType.SILO);
        for(Silo auxSilo: nowList){
            if(auxSilo.getName().equals(silo.getName()) && 
                auxSilo.getCapacity().equals(silo.getCapacity())
            ){
                nowList.remove(auxSilo);
                break;
            }
        }
        if(writeInFile(nowList, DataType.SILO)){
            return true; 
        }else {
            return false; 
        }
    }

    public static boolean update(Silo silo, Silo updatedSilo, boolean updateRentsNames){
        ArrayList<Silo> nowList = listReader(DataType.SILO);
        for(Silo auxSilo : nowList){
            if(auxSilo.getName().equals(silo.getName()) && 
                auxSilo.getCapacity().equals(silo.getCapacity()) && 
                auxSilo.getCapacityEmpty().equals(silo.getCapacityEmpty())
            ){
                auxSilo.setName(updatedSilo.getName());
                auxSilo.setCapacity(updatedSilo.getCapacity());
                auxSilo.setCapacityEmpty(updatedSilo.getCapacityEmpty());
                if(updateRentsNames) updateNameOnRents(silo, updatedSilo);
            }
        }
       
        if(writeInFile(nowList, DataType.SILO)){
            return true; 
        }else {
            return false; 
        }
        
        
    }

    private static void updateNameOnRents(Silo silo, Silo updatedSilo) {
        ArrayList<Rent> siloRentList = RentServices.searchRentsOnSilo(silo); 
        for(Rent rent : siloRentList){
            System.out.println("rent -> "+ rent);
            Rent updatedRent = new Rent(rent.getQuantity(), rent.getDate(), rent.getProducer(), updatedSilo);
            System.out.println("updatedRent -> "+ updatedRent);
            RentServices.update(rent, updatedRent);
        }
    }

    public static boolean siloNameVerification(String nameSilo){
        ArrayList<Silo> siloList = listReader(DataType.SILO);
        for(Silo auxSilo : siloList){
            if(auxSilo.getName().equals(nameSilo)){
                return true; 
            }
        }
        return false; 
    }
}
