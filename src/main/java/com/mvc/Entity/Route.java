package com.mvc.Entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "route_seq")
    @SequenceGenerator(name = "route_seq", sequenceName = "route_seq", allocationSize = 1)
    private int id;
    @Column(name = "from_station")
    private String fromStation;
    @Column(name = "to_station")
    private String toStation;

    @OneToMany(mappedBy = "route", fetch = FetchType.EAGER)
    private List<Station> stations;

    // default constructor
    public Route() { }

    // getters & setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getfromStation() {
        return fromStation;
    }

    public void setfromStation(String fromStation) {
        this.fromStation = fromStation;
    }

    public String gettoStation() {
        return toStation;
    }

    public void settoStation(String toStation) {
        this.toStation = toStation;
    }

    public List<Station> getStations() {
        return stations;
    }

    public void setStations(List<Station> stations) {
        this.stations = stations;
    }

    @Override
    public String toString() {
        return "Route [id=" + id + ", from=" + fromStation + ", to=" + toStation + ", stations=" + stations + "]";
    }

}
