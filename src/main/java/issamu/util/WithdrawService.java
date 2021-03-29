package issamu.util;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import issamu.model.Rent;
import issamu.model.Withdrawn;

public class WithdrawService extends Services{
    
    public static Double calculateCost(Rent rent){
        Double quantity = rent.getQuantity(); 
        System.out.println(quantity);

        LocalDate dtRent = rent.getDate(); 
        System.out.println(dtRent);
        LocalDate dtNow = LocalDate.now();
        System.out.println(dtNow);

        long dias = ChronoUnit.DAYS.between(dtRent, dtNow); 
        System.out.println(dias);

        Double costPerTon = quantity * 17; 

        return costPerTon * dias; 
    }

    public static boolean update(Withdrawn withdraw, Withdrawn updatedWithdraw){
        ArrayList<Withdrawn> nowList = listReader(DataType.WITHDRAW); 
        for(Withdrawn auxWithdraw : nowList){
            if(RentServices.compareRent(auxWithdraw.getRent(), withdraw.getRent()) &&
                auxWithdraw.getTotalCost().equals(withdraw.getTotalCost()) &&
                auxWithdraw.getPaid().equals(withdraw.getPaid())
            ){
                auxWithdraw.setRent(updatedWithdraw.getRent());
                auxWithdraw.setTotalCost(updatedWithdraw.getTotalCost());
                auxWithdraw.setPaid(updatedWithdraw.getPaid());
            }
        }

        if(writeInFile(nowList, DataType.WITHDRAW)){
            return true; 
        }else {
            return false; 
        }
    }
}
