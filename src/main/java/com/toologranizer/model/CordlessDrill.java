package com.toologranizer.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;


@Entity(name = "Cordless Drills")
public class CordlessDrill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String brand;
    @Column
    private String model;
    @Column
    private Boolean isTaken;


    public CordlessDrill() {
    }

    public CordlessDrill(Long id, String brand, String model, Boolean isTaken) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.isTaken = isTaken;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Boolean getTaken() {
        return isTaken;
    }

    public void setTaken(Boolean taken) {
        isTaken = taken;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CordlessDrill that)) return false;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getBrand(), that.getBrand()) && Objects.equals(getModel(), that.getModel()) && Objects.equals(isTaken, that.isTaken);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getBrand(), getModel(), isTaken);
    }

    @Override
    public String toString() {
        return "CordlessDrill{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", isTaken=" + isTaken +
                '}';
    }
}
