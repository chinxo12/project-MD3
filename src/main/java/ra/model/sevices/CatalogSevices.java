package ra.model.sevices;

import ra.model.entity.Catalog;
import ra.model.entity.Size;

import java.util.List;

public interface CatalogSevices<T,E> extends Sevices<T ,E>{
    List<T> getByParentId (E e);
    List<Size> getSizeByCatalogId(int id);
    Catalog getCatalogById(int id);
}
