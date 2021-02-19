package com.gIssamu.util;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.gIssamu.model.User;

public class UserServices {
    private static String filePath = "C:\\temp\\facul-class\\subdir\\programmingII\\users.dat";

    public static String getFilePath() {
        return filePath;
    }

    public static void insert(User user){
        ArrayList<User> nowList = listReader();
        nowList.add(user);

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(nowList);
        } catch (IOException io) {
            System.out.println("Error insert user!");
        }
    }

    public static ArrayList<User> listReader() {
        ArrayList<User> list = new ArrayList<>();
        
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            list = (ArrayList<User>) ois.readObject();
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

    public static boolean loginEqualsVerification(String loginUser){
        ArrayList<User> list = listReader();

        for(User user : list){
            if(user.getLogin().equals(loginUser)){
                return true;
            }
        }
        
        return false;
    }

    public static boolean userLogin(String login, String password){
        ArrayList<User> list = listReader();

        for(User user : list){
            if(user.getLogin().equals(login) && user.getPassword().equals(password)){
                return true; 
            }
        }

        return false;
    }
}
