package dao;

import java.util.List;

/**
 * Created by innopolis on 27.12.2016.
 */

/**
 *
 * @param <E> - тип сущности
 * @param <K> - ключ сущности
 */
public abstract class AbstractDAO<E, K> {

    public abstract List<E> getAll();
    public abstract E getEntityById(K key);
    public abstract E update(E entity);
    public abstract boolean delete(K id);
    public abstract boolean create(E entity);

}
