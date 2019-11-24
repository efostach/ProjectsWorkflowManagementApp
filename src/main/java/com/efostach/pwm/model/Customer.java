package com.efostach.pwm.model;

public class Customer {
    private Integer id;
    private String name;

    private Customer() {
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
    public String toString() {
        return new StringBuilder().append(id).append(",")
                .append(name)
                .append("\n").toString();
    }

    public static Builder newBuilder() {
        return new Customer().new Builder();
    }

    public class Builder {

        private Builder() {

        }

        public Builder setId(Integer id) {
            Customer.this.id = id;

            return this;
        }

        public Builder setName(String name) {
            Customer.this.name = name;

            return this;
        }

        public Customer build() {
            return Customer.this;
        }
    }
}
