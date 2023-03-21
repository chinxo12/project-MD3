package ra.model.entity;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

public class Bill {
    private int billId;
    private List<BillDetail> listBillDetail;
    private float totalPrice;
    private User user;
    private Date createDate;

    public Bill() {
    }

    public Bill(int billId, List<BillDetail> listBillDetail, float totalPrice, User user, Date createDate) {
        this.billId = billId;
        this.listBillDetail = listBillDetail;
        this.totalPrice = totalPrice;
        this.user = user;
        this.createDate = createDate;
    }

    public int getBillId() {
        return billId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    public List<BillDetail> getListBillDetail() {
        return listBillDetail;
    }

    public void setListBillDetail(List<BillDetail> listBillDetail) {
        this.listBillDetail = listBillDetail;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
