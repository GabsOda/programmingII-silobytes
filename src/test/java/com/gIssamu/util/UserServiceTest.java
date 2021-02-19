package com.gIssamu.util;

import com.gIssamu.model.User;

import org.junit.Test;

public class UserServiceTest {
    
    @Test
    public void testInsertData(){
        User user = new User("aaaaaaaa", "bbbbbbbbb", "ccccccccc");

        UserServices.insert(user);
    }
}
