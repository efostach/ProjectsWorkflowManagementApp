package com.efostach.pwm.repository;

import com.efostach.pwm.repository.exceptions.ConnectionFailException;

import java.sql.SQLException;
import java.util.List;

public interface GenericRpository<T, ID> {

    T getById(ID id) throws SQLException, ConnectionFailException;

    List<T> getAll() throws SQLException, ConnectionFailException;

    T create(T t) throws SQLException, ConnectionFailException;

    T update(T t) throws SQLException, ConnectionFailException;

    T delete(T t) throws SQLException, ConnectionFailException;
}
