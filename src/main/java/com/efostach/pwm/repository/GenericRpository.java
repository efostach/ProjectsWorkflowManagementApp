package com.efostach.pwm.repository;

import com.efostach.pwm.repository.exceptions.ConnectionFailException;
import com.efostach.pwm.repository.exceptions.NotFoundObjectsException;

import java.sql.SQLException;
import java.util.List;

public interface GenericRpository<T, ID> {

    T getById(ID id) throws SQLException, ConnectionFailException, NotFoundObjectsException;

    List<T> getAll() throws SQLException, ConnectionFailException;

    void create(T t) throws SQLException, ConnectionFailException;

    void update(T t) throws SQLException, ConnectionFailException;

    void delete(T t) throws SQLException, ConnectionFailException;
}
