package com.expenses2.demo.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = " license")
public class License {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "licence_number")
    private String licenceNumber;
    @Column(name = "capacity")
    private int capacity;
    @Column(name = "amount")
    private float amount;
    @Column(name = "licence_type")
    private String licenceType;
    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "expiry_date")
    private Date expiryDate;
    @Column(name = "remark")
    private String remark;


    public License() {
    }

    public License(String licenceNumber, int capacity, float amount, String licenceType,
                   Date startDate, Date expiryDate, String remark) {
        this.licenceNumber = licenceNumber;
        this.capacity = capacity;
        this.amount = amount;
        this.licenceType = licenceType;
        this.startDate = startDate;
        this.expiryDate = expiryDate;
        this.remark = remark;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLicenceNumber() {
        return licenceNumber;
    }

    public void setLicenceNumber(String licenceNumber) {
        this.licenceNumber = licenceNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getLicenceType() {
        return licenceType;
    }

    public void setLicenceType(String licenceType) {
        this.licenceType = licenceType;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "License [" + licenceNumber +
                ", capacity=" + capacity +
                ", amount=" + amount +
                ", licensetype=" + licenceType +
                ", start date=" + startDate +
                ", expiry date=" + expiryDate +
                ", remark=" + remark +
                "]";
    }
}
