package issamu.model;

import java.io.Serializable;

public class Producer implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name; 
    private String cpf; 
    private String phone;

    public Producer(){
    }

    public Producer(String name, String cpf, String phone) {
        this.name = name;
        this.cpf = cpf;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString(){
        return ""+name+" - "+cpf+" - "+phone;
    }
}