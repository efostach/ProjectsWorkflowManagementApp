package com.efostach.pwm.model;

public class Employee {
    private Integer id;
    private String firstName;
    private String lastName;
    private Integer workExperience;
    private Integer teamId;

    private Employee() {
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

    public static Builder newBuilder() {
        return new Employee().new Builder();
    }

    public class Builder {

        private Builder() {

        }

        public Employee.Builder setId(Integer id) {
            Employee.this.id = id;

            return this;
        }

        public Employee.Builder setFirstName(String firstName) {
            Employee.this.firstName = firstName;

            return this;
        }

        public Employee.Builder setLastName(String lastName) {
            Employee.this.lastName = lastName;

            return this;
        }

        public Employee.Builder setWorkExperience(Integer workExp) {
            Employee.this.workExperience = workExp;

            return this;
        }

        public Employee.Builder setTeamId(Integer teamId) {
            Employee.this.teamId = teamId;

            return this;
        }

        public Employee build() {
            return Employee.this;
        }
    }
}
