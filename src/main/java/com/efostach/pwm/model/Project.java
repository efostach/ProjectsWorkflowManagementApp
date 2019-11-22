package com.efostach.pwm.model;

public class Project {
    Integer id;
    String name;
    Integer cost;

    public Project() {
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

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    @Override
    public String toString(){
        return new StringBuilder().append(id).append(",")
                .append(name).append(",")
                .append(cost)
                .append("\n").toString();
    }
}
