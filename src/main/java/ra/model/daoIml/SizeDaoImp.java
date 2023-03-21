package ra.model.daoIml;

import ra.model.dao.SizeDao;
import ra.model.entity.Color;
import ra.model.entity.Size;
import ra.model.util.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SizeDaoImp implements SizeDao {
    @Override
    public List<Size> getListSize(List<Integer> list) {
        Connection conn = null;
        List<Size> sizeList = null;
        CallableStatement calSt = null;
        try{
            conn = ConnectionDB.openConnection();
            sizeList = new ArrayList<>();
            for (Integer s :list) {
                calSt = conn.prepareCall("{call proc_getSizeById(?)}");
                calSt.setInt(1,s);
                ResultSet rs = calSt.executeQuery();
                if (rs.next()){
                    Size size = new Size();
                    size.setSizeId(rs.getInt("sizeId"));
                    size.setSizeName(rs.getString("sizeName"));
                    size.setCatalogId(rs.getInt("catalogId"));
                    sizeList.add(size);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn,calSt);
        }
        return sizeList;
    }

    @Override
    public List<Color> getListColor(List<Integer> list) {
        Connection conn = null;
        List<Color> listColor = null;
        CallableStatement calSt = null;
        try{
            conn = ConnectionDB.openConnection();
            listColor = new ArrayList<>();
            for (Integer s :list) {
                calSt = conn.prepareCall("{call proc_getColorById(?)}");
                calSt.setInt(1,s);
                ResultSet rs = calSt.executeQuery();
                if (rs.next()){
                    Color color = new Color();
                    color.setColorId(rs.getInt("colorId"));
                    color.setColorName(rs.getString("colorName"));
                    listColor.add(color);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn,calSt);
        }
        return listColor;

    }

    @Override
    public List<Color> getAllColor() {
        Connection conn = null;
        List<Color> listColor = null;
        CallableStatement calSt = null;
        try{
            conn = ConnectionDB.openConnection();
            listColor = new ArrayList<>();
                calSt = conn.prepareCall("{call proc_getAllListColor()}");
                ResultSet rs = calSt.executeQuery();
                while (rs.next()){
                    Color color = new Color();
                    color.setColorId(rs.getInt("colorId"));
                    color.setColorName(rs.getString("colorName"));
                    listColor.add(color);
                }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn,calSt);
        }
        return listColor;

    }
}
