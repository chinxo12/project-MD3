package ra.model.daoIml;

import ra.model.dao.CatalogDao;
import ra.model.entity.Catalog;
import ra.model.entity.Size;
import ra.model.sevices.CatalogSevices;
import ra.model.sevicesImp.CatalogSevicesImp;
import ra.model.util.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CatalogDaoImp implements CatalogDao <Catalog,Integer> {

    @Override
    public List<Catalog> getAll() {
        List<Catalog> listCatalog = null;
        Connection conn = null;
        CallableStatement calst = null;
        try {
            conn = ConnectionDB.openConnection();
            calst = conn.prepareCall("{Call proc_getAllCatalog}");
            listCatalog = new ArrayList<>();
            ResultSet rs = calst.executeQuery();
            while (rs.next()){
                Catalog catalog = new Catalog();
                catalog.setCatalogId(rs.getInt("catalogId"));
                catalog.setCatalogName(rs.getString("catalogName"));
                catalog.setParentId(rs.getInt("parentId"));
                listCatalog.add(catalog);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn,calst);
        }
        return listCatalog;
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
    public List<Catalog> getByParentId(Integer id) {
        List<Catalog> catalogList = null;
        Connection conn = null;
        CallableStatement calst = null;
        try {
            catalogList = new ArrayList<>();
            conn = ConnectionDB.openConnection();
            calst = conn.prepareCall("{call proc_getCatalogByParentId(?)}");
            calst.setInt(1,id);
           ResultSet rs = calst.executeQuery();
            while (rs.next()){
                Catalog catalog = new Catalog();
                catalog.setCatalogId(rs.getInt("catalogId"));
                catalog.setCatalogName(rs.getString("catalogName"));
                catalog.setParentId(rs.getInt("parentId"));
                catalogList.add(catalog);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn,calst);
        }
        return catalogList;
    }

    @Override
    public List<Size> getSizeByCatalogId(int id) {
        List<Size> listSize = null;
        Connection conn = null;
        CallableStatement calst = null;
        try {
            conn = ConnectionDB.openConnection();
            listSize = new ArrayList<>();

            calst = conn.prepareCall("{call proc_getSizeByCatalogId(?)}");
            calst.setInt(1,id);
            ResultSet rs = calst.executeQuery();
            while (rs.next()){
                Size size = new Size();
                size.setSizeId(rs.getInt("sizeId"));
                size.setSizeName(rs.getString("sizeName"));
                size.setCatalogId(rs.getInt("catalogId"));
                listSize.add(size);
            }
        } catch (SQLException e) {
           e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn,calst);
        }
        return listSize;
    }

    @Override
    public Catalog getCatalogById(int id) {
        Connection conn = null;
        CallableStatement calst = null;
        Catalog catalog = null;
        try {
            catalog = new Catalog();
            conn = ConnectionDB.openConnection();
            calst = conn.prepareCall("{call proc_getCatalogById(?)}");
            calst.setInt(1,id);
            ResultSet rs = calst.executeQuery();
            if (rs.next()){
                catalog.setCatalogId(rs.getInt("catalogId"));
                catalog.setCatalogName(rs.getString("catalogName"));
                catalog.setParentId(rs.getInt("parentId"));
                catalog.setCatalogStatus(true);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn,calst);
        }
        return catalog;
    }
}
