package com.expenses2.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "director")
public class Manager {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;


    @ManyToOne
    @JoinColumn(name = "director_id", nullable = false)
    private Director director;

    public Manager() {
    }

    public Manager(String name) {
        this.name = name;
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

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    @Override
    public String toString() {
        return "Software [" +
                ",   name=" + name + "]";
    }
}
