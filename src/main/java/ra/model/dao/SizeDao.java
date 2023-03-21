package ra.model.dao;

import ra.model.entity.Color;
import ra.model.entity.Size;

import java.util.List;

public interface SizeDao {
    List<Size> getListSize(List<Integer> list);
    List<Color> getListColor(List<Integer>list);
    List<Color> getAllColor();
}
