package com.iot.lab6.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "bus")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)
public class Bus implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "bus_id")
    private Integer bus_id;

    @Column(name = "number", length = 8)
    private String number;

    @Column(name = "mileage", length = 45)
    private Integer mileage;

    @Column(name = "production_year")
    private Integer productionYear;

    @Column(name = "is_on_the_route", length = 45)
    private String isOnTheRoute;

    @Column(name = "model_model_id")
    private Integer modelModelId;

    public Bus() {
    }

    public Bus(Integer bus_id, String number, Integer mileage, Integer productionYear, String isOnTheRoute, Integer modelModelId) {
        this.bus_id = bus_id;
        this.number = number;
        this.mileage = mileage;
        this.productionYear = productionYear;
        this.isOnTheRoute = isOnTheRoute;
        this.modelModelId = modelModelId;
    }

    public Integer getBus_id() {
        return bus_id;
    }

    public void setBus_id(Integer bus_id) {
        this.bus_id = bus_id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public Integer getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(Integer productionYear) {
        this.productionYear = productionYear;
    }

    public String getIsOnTheRoute() {
        return isOnTheRoute;
    }

    public void setIsOnTheRoute(String isOnTheRoute) {
        this.isOnTheRoute = isOnTheRoute;
    }

    public Integer getModelModelId() {
        return modelModelId;
    }

    public void setModelModelId(Integer modelModelId) {
        this.modelModelId = modelModelId;
    }

    @Override
    public String toString() {
        return "Bus{" +
                "bus_id=" + bus_id +
                ", number='" + number + '\'' +
                ", mileage=" + mileage +
                ", productionYear=" + productionYear +
                ", isOnTheRoute='" + isOnTheRoute + '\'' +
                ", modelModelId=" + modelModelId +
                '}';
    }
}
