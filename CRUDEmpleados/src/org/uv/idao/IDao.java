package org.uv.idao;

import java.util.List;

/**
 *
 * @author citla
 */
public interface IDao<T> {
    public boolean insertRecord(T pojo);
    public boolean deleteRecord(long clave);
    public boolean updateRecord(T pojo);
    public T readOneRecord(long clave);
    public List<T> readRecords();
}
