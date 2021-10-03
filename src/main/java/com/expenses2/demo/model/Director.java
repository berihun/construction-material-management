package com.expenses2.demo.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "director")
public class Director {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chief_id", referencedColumnName = "id")
    private Chief chief;

    @OneToMany(
            mappedBy = "director",
            cascade = CascadeType.PERSIST,
            fetch = FetchType.LAZY
    )
    private Set<Director> director;
//    @ManyToOne
//    @JoinColumn(name="chief_id", nullable=false)
//    private Chief chief;

    public Director() {
    }

    public Director(String name) {
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

    public Chief getChief() {
        return chief;
    }

    public void setChief(Chief chief) {
        this.chief = chief;
    }

    public Set<Director> getDirector() {
        return director;
    }

    public void setDirector(Set<Director> director) {
        this.director = director;
    }

    @Override
    public String toString() {
        return "Software [" +
                ",   name=" + name + "]";
    }
}
