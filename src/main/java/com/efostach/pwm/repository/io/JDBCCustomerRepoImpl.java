package com.efostach.pwm.repository.io;

import com.efostach.pwm.model.Customer;
import com.efostach.pwm.repository.CustomerRepository;

import java.util.ArrayList;
import java.util.List;

public class JDBCCustomerRepoImpl implements CustomerRepository {

    public Customer getById(Integer integer) {
        return null;
    }

    public List<Customer> getAll() {
        return null;
    }

    public Customer create(Customer customer) {
        return null;
    }

    public Customer update(Customer customer) {
        return null;
    }

    public Customer delete(Customer customer) {
        return null;
    }

    private List<Customer> stringToCustomer() {

        List<Customer> customerSet = new ArrayList<Customer>();
        return customerSet;
    }
}
