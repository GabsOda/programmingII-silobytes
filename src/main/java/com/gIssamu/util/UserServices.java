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
    private static String filePath = "silobyte\\file\\users.dat";

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

    public static boolean delete(User user){
        ArrayList<User> nowList = listReader();
        for(User auxUser : nowList){
            if(auxUser.getLogin().equals(user.getLogin()) && auxUser.getPassword().equals(user.getPassword())){
                nowList.remove(auxUser);
                break;
            }
        }

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(nowList);
            return true;
        } catch (IOException io) {
            System.out.println("Error delete user!");
            return false;
        }
    }

    public static boolean update(User user, User updatedUser){
        ArrayList<User> nowList = listReader();
        System.out.println("updatedUser -> name: "+updatedUser.getName()+
                " login: "+updatedUser.getLogin() +
                " password: "+updatedUser.getPassword());
        for(User auxUser: nowList){
            if(auxUser.getLogin().equals(user.getLogin()) && auxUser.getPassword().equals(user.getPassword())){
                auxUser.setName(updatedUser.getName());
                auxUser.setLogin(updatedUser.getLogin());
                auxUser.setPassword(updatedUser.getPassword());
            }
        }

        for(User auxUser: nowList){
            System.out.println("name: "+auxUser.getName()+
                " login: "+auxUser.getLogin() +
                " password: "+auxUser.getPassword());
        }

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(nowList);
            return true;
        } catch (IOException io) {
            System.out.println("Error update user!");
            return false;
        }
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

    public static String generateHidePassword(int lenght){
        String hidePassword = "";
        for(int i = 0; i < lenght; i++){
            hidePassword += "*";
        }
        return hidePassword;
    }
}
