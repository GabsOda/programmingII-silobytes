package com.gIssamu.util;

import java.util.List;

import com.gIssamu.model.User;

import org.junit.Test;

public class UserServiceTest {
    
    @Test
    public void testInsertUser(){
        User user = new User("aaaaaaaa", "bbbbbbbbb", "ccccccccc");

        Services.insert(DataType.USER, user);
        List<User> list2= Services.listReader(DataType.USER);

        for(User auxUser : list2){
            System.out.println(auxUser);
        }
    }

    @Test
    public void testUpdateUser(){
        User user = new User("abc", "abc", "abc");
        Services.insert(DataType.USER, user);

        User updatedUser = new User("abc", "abc", "abc123");
        UserServices.update(user, updatedUser);
    }
}
