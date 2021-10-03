package com.expenses2.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "workunit")
public class WorkUnit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "unitname")
    private String unitname;
    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private String phone;
    @Column(name = "department")
    private String department;


    public WorkUnit() {
    }

    public WorkUnit(String unitname, String email, String phone, String department) {
        this.unitname = unitname;
        this.email = email;
        this.phone = phone;
        this.department = department;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUnitname() {
        return unitname;
    }

    public void setUnitname(String unitname) {
        this.unitname = unitname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "User [" +
                ",  unite name=" + unitname +
                ", email=" + email +
                ", phone=" + phone +
                ", department=" + department +
                "]";
    }
}
