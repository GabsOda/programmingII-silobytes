package com.gIssamu.model;

import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = 1L;
     
    private String name; 
    private String login;
    private String password;

    public User() {
	}

    public User(String name, String login, String password) {
        this.name = name;
        this.login = login;
        this.password = password;
    }

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString(){
        return name;
    } 
}
