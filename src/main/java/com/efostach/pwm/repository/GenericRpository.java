package com.efostach.pwm.repository;

import java.util.List;

public interface GenericRpository<T, ID> {

    T getById(ID id);

    List<T> getAll();

    T create(T t);

    T update(T t);

    T delete(T t);
}
