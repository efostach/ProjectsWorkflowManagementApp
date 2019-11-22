package com.efostach.pwm.model;

public class Skill {
    Integer id;
    String name;

    public Skill() {
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
