package com.toologranizer.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity(name = "Worker")
public class Worker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    @OneToMany
   private List<CordlessDrill> currentTools;

    public Worker() {
    }

    public Worker(Long id, String name, List<CordlessDrill> currentTools) {
        this.id = id;
        this.name = name;
        this.currentTools = currentTools;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CordlessDrill> getCurrentTools() {
        return currentTools;
    }

    public void setCurrentTools(List<CordlessDrill> currentTools) {
        this.currentTools = currentTools;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Worker worker)) return false;
        return Objects.equals(getId(), worker.getId()) && Objects.equals(getName(), worker.getName()) && Objects.equals(getCurrentTools(), worker.getCurrentTools());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getCurrentTools());
    }

    @Override
    public String toString() {
        return "Worker{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", currentTools=" + currentTools +
                '}';
    }
}
