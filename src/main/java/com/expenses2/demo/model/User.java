package com.expenses2.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
//@Table(name = "user")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "empid")
    private String empid;
    @Column(name = "firstname")
    private String firstName;
    @Column(name = "lastname")
    private String lastName;
    @Column(name = "serviceuseid")
    private String serviceUseId;
    @Column(name = "email")
    private String email;
    @Column(name = "mobilephone")
    private String mobilePhone;
    @Column(name = "workunitid")
    private String workUnitId;
    @Column(name = "position")
    private String position;
    @Column(name = "adminuserid")
    private String adminUserId;

    public User() {
    }

    public User(String empid, String firstName, String lastName,
                String serviceUseId, String email, String mobilephone,
                String workunitId, String position, String adminUserId) {

        this.empid = empid;
        this.firstName = firstName;
        this.lastName = lastName;
        this.serviceUseId = serviceUseId;
        this.email = email;
        this.mobilePhone = mobilephone;
        this.workUnitId = workunitId;
        this.position = position;
        this.adminUserId = adminUserId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmpid() {
        return empid;
    }

    public void setEmpid(String empid) {
        this.empid = empid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getServiceUseId() {
        return serviceUseId;
    }

    public void setServiceUseId(String serviceUseId) {
        this.serviceUseId = serviceUseId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getWorkUnitId() {
        return workUnitId;
    }

    public void setWorkUnitId(String workUnitId) {
        this.workUnitId = workUnitId;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getAdminUserId() {
        return adminUserId;
    }

    public void setAdminUserId(String adminUserId) {
        this.adminUserId = adminUserId;
    }

    @Override
    public String toString() {
        return "User [" +
                ", emp id=" + empid +
                ", first name=" + firstName +
                ", last name=" + lastName +
                ", service user id=" + serviceUseId +
                ", email=" + email +
                ", mobile phone=" + mobilePhone +
                ", work unit id=" + workUnitId + "]";
    }
}
