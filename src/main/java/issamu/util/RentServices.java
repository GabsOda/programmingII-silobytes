package issamu.util;

import java.util.ArrayList;

import issamu.model.Rent;
import issamu.model.Silo;

public class RentServices extends Services {
    
    public static boolean delete(Rent rent){
        ArrayList<Rent> rentsList = Services.listReader(DataType.RENT);
        for(Rent auxRent: rentsList){
            System.out.println(auxRent);
            if(auxRent.getDate().equals(rent.getDate()) && 
                auxRent.getQuantity().equals(rent.getQuantity()) &&
                auxRent.getSilo().getName().equals(rent.getSilo().getName()) &&
                auxRent.getProducer().getCpf().equals(rent.getProducer().getCpf())
            ){
                rentsList.remove(auxRent);
                break; 
            }
        }

        if(writeInFile(rentsList, DataType.RENT)){
            return true; 
        }else{
            return false; 
        }
    }

    public static boolean update(Rent rent, Rent updatedRent){
        ArrayList<Rent> rentList = Services.listReader(DataType.RENT); 
        System.out.println("in update: ");
        for(Rent auxRent : rentList){
            System.out.println(auxRent);
            System.out.println("-> " + rent);
            System.out.println("update->  "+updatedRent);
        
            if(auxRent.getDate().equals(rent.getDate()) &&
                auxRent.getQuantity().equals(rent.getQuantity()) &&
                auxRent.getSilo().getName().equals(rent.getSilo().getName()) &&
                auxRent.getProducer().getCpf().equals(rent.getProducer().getCpf())
            ){ 
                System.out.println("aqui entrou!");
                auxRent.setDate(updatedRent.getDate());
                auxRent.setQuantity(updatedRent.getQuantity());
                auxRent.setSilo(updatedRent.getSilo());
                auxRent.setProducer(updatedRent.getProducer());
            }
        }

        if(writeInFile(rentList, DataType.RENT)){
            return true; 
        }else {
            return false; 
        }
    }

    public static ArrayList<Rent> searchRentsOnSilo(Silo silo){
        ArrayList<Rent> rentsList = Services.listReader(DataType.RENT);
        ArrayList<Rent> siloRentsList = new ArrayList<>(); 
        for(Rent rent : rentsList){
            if(rent.getSilo().getName().equals(silo.getName())){
                siloRentsList.add(rent);
            }
        }
        return siloRentsList;
    }

}
