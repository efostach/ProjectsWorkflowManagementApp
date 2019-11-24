package com.efostach.pwm.repository.io;

import com.efostach.pwm.model.Customer;
import com.efostach.pwm.repository.CustomerRepository;
import com.efostach.pwm.repository.exceptions.ConnectionFailException;

import java.util.ArrayList;
import java.util.List;

import java.sql.*;

import static com.efostach.pwm.repository.io.JDBCUtilSQL.*;

public class JDBCCustomerRepoImpl implements CustomerRepository {

    public Customer getById(Integer id) throws SQLException, ConnectionFailException {

        PreparedStatement statement = JDBCConnection.getConnection().prepareStatement(CUSTOMER_GETBYID_SQL);
        statement.setInt(1, id);

        ResultSet rs = statement.executeQuery(CUSTOMER_GETBYID_SQL);

        Customer customer = Customer.newBuilder()
                .setId(rs.getInt("id"))
                .setName(rs.getString("name"))
                .build();

        rs.close();
        statement.close();

        return customer;
    }

    public List<Customer> getAll() throws SQLException, ConnectionFailException {

        List<Customer> customerSet = new ArrayList<Customer>();

        Statement statement = JDBCConnection.getConnection().createStatement();

        ResultSet rs = statement.executeQuery(CUSTOMER_GETALL_SQL);

        while (rs.next()) {
            customerSet.add(Customer.newBuilder()
                    .setId(rs.getInt("id"))
                    .setName(rs.getString("name"))
                    .build());
        }

        rs.close();
        statement.close();

        return customerSet;
    }

    public Customer create(Customer customer) throws SQLException, ConnectionFailException {

        PreparedStatement statement = JDBCConnection.getConnection().prepareStatement(CUSTOMER_CREATE_SQL);
        statement.setString(1, customer.getName());

        ResultSet rs = statement.executeQuery(CUSTOMER_CREATE_SQL);

        Customer createdObj = Customer.newBuilder()
                .setId(rs.getInt("id"))
                .setName(rs.getString("name"))
                .build();

        rs.close();
        statement.close();

        return createdObj;
    }

    public Customer update(Customer customer) throws SQLException, ConnectionFailException {

        PreparedStatement statement = JDBCConnection.getConnection().prepareStatement(CUSTOMER_UPDATE_SQL);
        statement.setString(1, customer.getName());
        statement.setInt(2, customer.getId());

        ResultSet rs = statement.executeQuery(CUSTOMER_DELETE_SQL);

        Customer updatedObj = Customer.newBuilder()
                .setId(rs.getInt("id"))
                .setName(rs.getString("name"))
                .build();

        rs.close();
        statement.close();

        return updatedObj;
    }

    public Customer delete(Customer customer) throws SQLException, ConnectionFailException {

        PreparedStatement statement = JDBCConnection.getConnection().prepareStatement(CUSTOMER_DELETE_SQL);
        statement.setInt(1, customer.getId());

        ResultSet rs = statement.executeQuery(CUSTOMER_DELETE_SQL);

        Customer deletedObj = Customer.newBuilder()
                .setId(rs.getInt("id"))
                .setName(rs.getString("name"))
                .build();

        rs.close();
        statement.close();

        return deletedObj;
    }
}
