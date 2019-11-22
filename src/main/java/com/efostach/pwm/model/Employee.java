package com.efostach.pwm.model;

public class Employee {
    Integer id;
    String firstName;
    String lastName;
    Integer workExperience;
    Integer teamId;

    public Employee() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getWorkEcperience() {
        return workExperience;
    }

    public void setWorkEcperience(Integer workEcperience) {
        this.workExperience = workEcperience;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    @Override
    public String toString(){
        return new StringBuilder().append(id).append(",")
                .append(firstName).append(",")
                .append(lastName).append(",")
                .append(workExperience).append(",")
                .append(teamId)
                .append("\n").toString();
    }
}
