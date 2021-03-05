package com.gIssamu.util;

import java.util.ArrayList;

import com.gIssamu.model.User;

public class UserServices extends Services{

    public static boolean delete(User user){
        ArrayList<User> nowList = listReader(DataType.USER);
        for(User auxUser : nowList){
            if(auxUser.getLogin().equals(user.getLogin()) && auxUser.getPassword().equals(user.getPassword())){
                nowList.remove(auxUser);
                break;
            }
        }
        if(writeInFile(nowList, DataType.USER)){
            return true; 
        }else {
            return false;
        }
    }

    public static boolean update(User user, User updatedUser){
        ArrayList<User> nowList = listReader(DataType.USER);
        for(User auxUser: nowList){
            if(auxUser.getLogin().equals(user.getLogin()) && auxUser.getPassword().equals(user.getPassword())){
                auxUser.setName(updatedUser.getName());
                auxUser.setLogin(updatedUser.getLogin());
                auxUser.setPassword(updatedUser.getPassword());
            }
        }
        if (writeInFile(nowList, DataType.USER)){
            return true; 
        }else {
            return false; 
        }
    }

    public static boolean loginEqualsVerification(String loginUser){
        ArrayList<User> list = listReader(DataType.USER);
        for(User user : list){
            if(user.getLogin().equals(loginUser)){
                return true;
            }
        }
        return false;
    }

    public static boolean userLogin(String login, String password){
        ArrayList<User> list = listReader(DataType.USER);
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
