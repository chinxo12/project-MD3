package ra.model.entity;

import java.util.Date;
import java.util.List;

public class Order {
    private int orderId;
    private Date createDate;
    private float totalMoney;
    private float discount;
    private float payMoney;
    private boolean oderStatus;
    private List<OrderDetail> listOrderDetail;
    private User user;

    public Order() {
    }

    public Order(int orderId, Date createDate, float totalMoney, float discount, float payMoney, boolean oderStatus,
                 List<OrderDetail> listOrderDetail, User user) {
        this.orderId = orderId;
        this.createDate = createDate;
        this.totalMoney = totalMoney;
        this.discount = discount;
        this.payMoney = payMoney;
        this.oderStatus = oderStatus;
        this.listOrderDetail = listOrderDetail;
        this.user = user;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public float getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(float totalMoney) {
        this.totalMoney = totalMoney;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public float getPayMoney() {
        return payMoney;
    }

    public void setPayMoney(float payMoney) {
        this.payMoney = payMoney;
    }

    public boolean isOderStatus() {
        return oderStatus;
    }

    public void setOderStatus(boolean oderStatus) {
        this.oderStatus = oderStatus;
    }

    public List<OrderDetail> getListOrderDetail() {
        return listOrderDetail;
    }

    public void setListOrderDetail(List<OrderDetail> listOrderDetail) {
        this.listOrderDetail = listOrderDetail;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

