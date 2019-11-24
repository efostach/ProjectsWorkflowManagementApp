package com.efostach.pwm.model;

public class Project {
    private Integer id;
    private String name;
    private Integer cost;
    private ProjectStatus status;

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

    public ProjectStatus getStatus() {
        return status;
    }

    public void setStatus(ProjectStatus status) {
        this.status = status;
    }

    @Override
    public String toString(){
        return new StringBuilder().append(id).append(",")
                .append(name).append(",")
                .append(cost).append(",")
                .append(status)
                .append("\n").toString();
    }

    public static Builder newBuilder() {
        return new Project().new Builder();
    }

    public class Builder {

        private Builder() {

        }

        public Builder setId(Integer id) {
            Project.this.id = id;

            return this;
        }

        public Builder setName(String name) {
            Project.this.name = name;

            return this;
        }

        public Builder setCost(Integer cost) {
            Project.this.cost = cost;

            return this;
        }


        public Builder setStatus(ProjectStatus status) {
            Project.this.status = status;

            return this;
        }

        public Project build() {
            return Project.this;
        }
    }
}
