package com.expenses2.demo.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "asset")
public class Asset {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;
    @Column(name = "version")
    private String version;
    @Column(name = "vendor")
    private String vendor;
    @Column(name = "year_of_development")
    private Date yearOfDevelopment;
    @Column(name = "year_of_deployment")
    private Date yearOfDeployment;
    @Column(name = "ownerid")
    private String empId;

    public Asset() {
    }

    public Asset(String name, String version, String vendor, Date yearOfDevelopment, Date yearOfDeployment, String empId) {
        this.name = name;
        this.version = version;
        this.vendor = vendor;
        this.yearOfDevelopment = yearOfDevelopment;
        this.yearOfDeployment = yearOfDeployment;
        this.empId = empId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public Date getYearOfDevelopment() {
        return yearOfDevelopment;
    }

    public void setYearOfDevelopment(Date yearOfDevelopment) {
        this.yearOfDevelopment = yearOfDevelopment;
    }

    public Date getYearOfDeployment() {
        return yearOfDeployment;
    }

    public void setYearOfDeployment(Date yearOfDeployment) {
        this.yearOfDeployment = yearOfDeployment;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    @Override
    public String toString() {
        return "Software [" +
                ",   name=" + name +
                ", version=" + version +
                ", vendor=" + vendor +
                ", year of dev't=" + yearOfDevelopment +
                ", year of devployment=" + yearOfDeployment +
                ", employee id=" + empId +
                "]";
    }
}
