package com.gIssamu.util;

import java.util.ArrayList;

import com.gIssamu.model.Silo;

public class SiloServices extends Services{
    
    public static boolean delete(Silo silo){
        ArrayList<Silo> nowList = listReader(DataType.SILO);
        for(Silo auxSilo: nowList){
            if(auxSilo.getName().equals(silo.getName()) && auxSilo.getCapacity().equals(silo.getCapacity())){
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

    public static boolean update(Silo silo, Silo updatedSilo){
        ArrayList<Silo> nowList = listReader(DataType.SILO);
        for(Silo auxSilo : nowList){
            if(auxSilo.getName().equals(silo.getName()) && auxSilo.getCapacity().equals(silo.getCapacity())){
                auxSilo.setName(updatedSilo.getName());
                auxSilo.setCapacity(updatedSilo.getCapacity());
            }
        }
        if(writeInFile(nowList, DataType.SILO)){
            return true; 
        }else {
            return false; 
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
