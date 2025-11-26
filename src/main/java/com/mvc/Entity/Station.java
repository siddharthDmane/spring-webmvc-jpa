package com.mvc.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Station {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE ,generator = "station_seq")
    @SequenceGenerator(name ="station_seq",sequenceName = "station_seq",allocationSize = 1)
    private int id;
    private String name;
    @Column(name = "station_no")
    private int stationNo;
    @Column(name = "is_alightning")
    private boolean isAlightning;
    private int fare;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "route_id")
    private Route route;

    // default constructor
    public Station() { }

    // getters & setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAlightning() {
        return isAlightning;
    }

    public void setAlightning(boolean isAlightning) {
        this.isAlightning = isAlightning;
    }

    public int getFare() {
        return fare;
    }

    public void setFare(int fare) {
        this.fare = fare;
    }

    public int getStationNo() {
        return stationNo;
    }

    public void setStationNo(int stationNo) {
        this.stationNo = stationNo;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }    

    @Override
    public String toString() {
        return "Station [id=" + id + ", name=" + name + ", stationNo=" + stationNo + ", isAlightning=" + isAlightning
                + ", fare=" + fare + "]";
    }

}
