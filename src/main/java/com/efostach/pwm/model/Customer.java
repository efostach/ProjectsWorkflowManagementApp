package com.efostach.pwm.model;

public class Customer {
    Integer id;
    String name;

    public Customer() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString(){
        return new StringBuilder().append(id).append(",")
                .append(name)
                .append("\n").toString();
    }
}
