package issamu.util;

import java.util.ArrayList;

import issamu.model.Producer;

public class ProducerServices extends Services {
    
    public static boolean delete(Producer producer){
        ArrayList<Producer> nowList = listReader(DataType.PRODUCER);
        for(Producer auxProducer : nowList){
            if(auxProducer.getName().equals(producer.getName()) && 
                auxProducer.getCpf().equals(producer.getCpf())
            ){
                nowList.remove(auxProducer);
                break;
            }
        }
        
        if(writeInFile(nowList, DataType.PRODUCER)){
            return true; 
        }else{
            return false; 
        }
    }

    public static boolean update(Producer producer, Producer updatedProducer){
        ArrayList<Producer> nowList = listReader(DataType.PRODUCER);
        for(Producer auxProducer : nowList){
            if(auxProducer.getName().equals(producer.getName()) && 
                auxProducer.getCpf().equals(producer.getCpf())
            ){
                auxProducer.setName(updatedProducer.getName());
                auxProducer.setCpf(updatedProducer.getCpf());
                auxProducer.setPhone(updatedProducer.getPhone());
            }
        }
        
        if(writeInFile(nowList, DataType.PRODUCER)){
            return true; 
        }else{
            return false; 
        }
    }

    public static boolean producerCpfVerification(String cpfUser){
        ArrayList<Producer> list = listReader(DataType.PRODUCER);
        for(Producer producer : list){
            if(producer.getCpf().equals(cpfUser)){
                return true; 
            }
        }
        return false;
    }
}
