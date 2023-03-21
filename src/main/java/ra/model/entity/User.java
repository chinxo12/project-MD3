package ra.model.entity;

import java.util.Date;

public class User {
    private int userId;
    private String userName;
    private String passwood;
    private String fullName;
    private String address;
    private String email;
    private int permisson;
    private Date createDate;
    private String phoneNumber;
    private boolean userStatus;
    private int sex;
    private Date birthOfDate;

    public User() {
    }

    public User(int userId, String userName, String passwood, String fullName, String address, String email,
                int permisson, Date createDate, String phoneNumber, boolean userStatus, int sex, Date birthOfDate) {
        this.userId = userId;
        this.userName = userName;
        this.passwood = passwood;
        this.fullName = fullName;
        this.address = address;
        this.email = email;
        this.permisson = permisson;
        this.createDate = createDate;
        this.phoneNumber = phoneNumber;
        this.userStatus = userStatus;
        this.sex = sex;
        this.birthOfDate = birthOfDate;
    }

    public int getSex() {
        return sex;
    }

    public Date getBirthOfDate() {
        return birthOfDate;
    }

    public void setBirthOfDate(Date birthOfDate) {
        this.birthOfDate = birthOfDate;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPasswood() {
        return passwood;
    }

    public void setPasswood(String passwood) {
        this.passwood = passwood;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPermisson() {
        return permisson;
    }

    public void setPermisson(int permisson) {
        this.permisson = permisson;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isUserStatus() {
        return userStatus;
    }

    public void setUserStatus(boolean userStatus) {
        this.userStatus = userStatus;
    }
}
