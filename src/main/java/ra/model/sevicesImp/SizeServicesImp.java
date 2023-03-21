package ra.model.sevicesImp;

import ra.model.dao.SizeDao;
import ra.model.daoIml.SizeDaoImp;
import ra.model.entity.Color;
import ra.model.entity.Size;
import ra.model.sevices.SizeServices;

import java.util.List;

public class SizeServicesImp implements SizeServices {
    private SizeDao sizeDao = new SizeDaoImp();
    @Override
    public List<Size> getListSize(List<Integer> list) {
        return sizeDao.getListSize(list);
    }

    @Override
    public List<Color> getListColor(List<Integer> list) {
        return sizeDao.getListColor(list);
    }

    @Override
    public List<Color> getAllColor() {
        return sizeDao.getAllColor();
    }
}
