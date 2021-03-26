package issamu.util;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Services {
    private static String filePathUsers = "file\\users.dat";
    private static String filePathProducers = "file\\producers.dat";
    private static String filePathSilos = "file\\silos.dat";
    private static String filePathRent = "file\\rents.dat";

    public static String getFilePathUsers() {
        return filePathUsers;
    }

    public static String getFilePathProducers(){
        return filePathProducers;
    }

    public static String getFilePathSilos(){
        return filePathSilos;
    }

    public static <T> void insert(DataType type, T data){
        String filePath = returnFilePath(type);

        ArrayList<T> nowList = listReader(type);
        nowList.add(data);

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(nowList);
        } catch (IOException io) {
            System.out.println("Error insert user!");
        }
    }

    public static <T> ArrayList<T> listReader(DataType type) {
        String filePath = returnFilePath(type);
        ArrayList<T> list = new ArrayList<>();
        
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            list = (ArrayList<T>) ois.readObject();
            return list;
        }catch(FileNotFoundException fnf){
            System.out.println("File not Found");
        }catch(EOFException eof){
            return list;
        }catch(ClassNotFoundException cnf){
            cnf.printStackTrace();
        }catch(IOException io){
            System.out.println("Error read file!");
        }
        return list;
    }

    public static String returnFilePath(DataType type){
        if(type == DataType.USER){
            return filePathUsers;
        }else if(type == DataType.PRODUCER){
            return filePathProducers;
        }else if(type == DataType.SILO){
            return filePathSilos;
        }else if(type == DataType.RENT){
            return filePathRent; 
        }
        return null; 
    }

    public static<T> boolean writeInFile(ArrayList<T> list, DataType type){
        String filePath = returnFilePath(type);

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))){
            oos.writeObject(list);
            return true; 
        }catch (IOException ioex){
            System.out.println("Error update producer!");
            return false;
        }
    }

}
