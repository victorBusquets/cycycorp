
package com.fpmislata.banco.persistencia;

import java.util.List;

public interface GenericDAO<T, ID> {

    public T get(ID id);

    public T insert(T t);

    public T update(T t);

    public void delete(ID id);

    public List<T> findAll();
}
