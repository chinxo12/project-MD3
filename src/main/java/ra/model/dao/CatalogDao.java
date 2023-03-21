package ra.model.dao;

import ra.model.entity.Catalog;
import ra.model.entity.Size;

import java.util.List;

public interface CatalogDao<T,E> extends Dao<T,E>{
    List<T> getByParentId (E e);
    List<Size> getSizeByCatalogId(int id);
    Catalog getCatalogById(int id);

}
