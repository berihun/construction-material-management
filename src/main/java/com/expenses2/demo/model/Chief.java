package com.expenses2.demo.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "chief")
public class Chief {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;
    @OneToMany(
            mappedBy = "chief",
            cascade = CascadeType.PERSIST,
            fetch = FetchType.LAZY
    )
    private Set<Chief> chief;

    public Chief() {
    }

    public Chief(String name) {
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

    @Override
    public String toString() {
        return "Software [" +
                ",   name=" + name + "]";
    }

    public Set<Chief> getChief() {
        return chief;
    }

    public void setChief(Set<Chief> chief) {
        this.chief = chief;
    }
}
