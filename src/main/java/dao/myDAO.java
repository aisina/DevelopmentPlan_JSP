package dao;

import java.util.List;

/**
 * Created by innopolis on 27.12.2016.
 */
public interface myDAO<E> {

    public List<E> getAll();
    public void deleteById(int id);
    public void add();
}
