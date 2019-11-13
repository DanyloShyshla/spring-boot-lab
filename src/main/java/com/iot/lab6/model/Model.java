package com.iot.lab6.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "model")

public class Model implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "model_id")
    private Integer model_id;

    @Column(name = "name", length = 8)
    private String name;

    @Column(name = "model", length = 45)
    private String model;

    @Column(name = "seats")
    private Integer seats;

    public Model(String name, String model, Integer seats) {
        this.name = name;
        this.model = model;
        this.seats = seats;
    }

    public Model() {
    }

    @Override
    public String toString() {
        return "Model{" +
                "model_id=" + model_id +
                ", name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", seats=" + seats +
                '}';
    }

    public Integer getModel_id() {
        return model_id;
    }

    public void setModel_id(Integer model_id) {
        this.model_id = model_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getSeats() {
        return seats;
    }

    public void setSeats(Integer seats) {
        this.seats = seats;
    }
}
