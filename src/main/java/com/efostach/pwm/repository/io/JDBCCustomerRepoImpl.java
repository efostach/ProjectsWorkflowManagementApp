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

        PreparedStatement statement = JDBCConnection.getConnection().prepareStatement(CUSTOMER_GETBY_ID_SQL);
        statement.setInt(1, id);

        ResultSet rs = statement.executeQuery();

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

        ResultSet rs = statement.executeQuery(CUSTOMER_GET_ALL_SQL);

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

    public void create(Customer customer) throws SQLException, ConnectionFailException {

        PreparedStatement statement = JDBCConnection.getConnection().prepareStatement(CUSTOMER_CREATE_SQL);
        statement.setString(1, customer.getName());

        statement.executeQuery();

        statement.close();
    }

    public void update(Customer customer) throws SQLException, ConnectionFailException {

        PreparedStatement statement = JDBCConnection.getConnection().prepareStatement(CUSTOMER_UPDATE_SQL);
        statement.setString(1, customer.getName());
        statement.setInt(2, customer.getId());

        statement.executeQuery();

        statement.close();
    }

    public void delete(Customer customer) throws SQLException, ConnectionFailException {

        PreparedStatement statement = JDBCConnection.getConnection().prepareStatement(CUSTOMER_DELETE_SQL);
        statement.setInt(1, customer.getId());

        statement.executeQuery();

        statement.close();
    }
}
