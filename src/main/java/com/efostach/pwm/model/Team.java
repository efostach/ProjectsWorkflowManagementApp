package com.efostach.pwm.model;

public class Team {
    private Integer id;
    private String name;

    private Team() {
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

    public static Builder newBuilder() {
        return new Team().new Builder();
    }

    public class Builder {

        private Builder() {

        }

        public Builder setId(Integer id) {
            Team.this.id = id;

            return this;
        }

        public Builder setName(String name) {
            Team.this.name = name;

            return this;
        }

        public Team build() {
            return Team.this;
        }
    }
}
