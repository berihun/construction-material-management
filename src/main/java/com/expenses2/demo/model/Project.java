package com.expenses2.demo.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;
    @Column(name = "location")
    private String location;
    @Column(name = "total_cost")
    private float totalCost;
    @Column(name = "start_date")
    private Date startDate;
    @Column(name = "end_date ")
    private Date endDate;


    public Project() {
    }

    public Project(String name, String location,
                   float totalCost, Date startDate, Date endDate) {
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public float getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(float totalCost) {
        this.totalCost = totalCost;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Project [" +
                ",   name=" + name +
                ", location=" + location +
                ", totalCost=" + totalCost +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                "]";
    }
}


