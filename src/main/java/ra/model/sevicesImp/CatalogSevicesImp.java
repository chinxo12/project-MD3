package ra.model.sevicesImp;

import ra.model.dao.CatalogDao;
import ra.model.daoIml.CatalogDaoImp;
import ra.model.entity.Catalog;
import ra.model.entity.Size;
import ra.model.sevices.CatalogSevices;

import java.util.List;

public class CatalogSevicesImp implements CatalogSevices<Catalog,Integer> {
    CatalogDao catalogDao = new CatalogDaoImp();
    @Override
    public List<Catalog> getAll() {
        return catalogDao.getAll();
    }

    @Override
    public boolean insert(Catalog catalog) {
        return false;
    }

    @Override
    public boolean delete(Integer integer) {
        return false;
    }

    @Override
    public boolean update(Catalog catalog) {
        return false;
    }

    @Override
    public List<Catalog> getByParentId(Integer integer) {
        return catalogDao.getByParentId(integer);
    }

    @Override
    public List<Size> getSizeByCatalogId(int id) {
        return catalogDao.getSizeByCatalogId(id);
    }

    @Override
    public Catalog getCatalogById(int id) {
        return catalogDao.getCatalogById(id);
    }
}
