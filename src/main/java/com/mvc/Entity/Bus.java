package com.mvc.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Bus {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bus_seq")
    @SequenceGenerator(name = "bus_seq", sequenceName = "bus_seq", allocationSize = 1)
    private int id;
    private String name;
    @Column(name = "vehicle_number")
    private String vehicleNumber;
    @Column(name = "total_seats")
    private int totalSeats;
    @Column(name = "window_seats")
    private int windowSeats;
    @Column(name = "basic_fare")
    private int basicFare;

    @OneToOne
    // @JsonIgnore
    @JoinColumn(name = "route_id")
    private Route route;

    // default constructor
    public Bus() { }

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

    public String getvehicleNumber() {
        return vehicleNumber;
    }

    public void setvehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public int getWindowSeats() {
        return windowSeats;
    }

    public void setWindowSeats(int windowSeats) {
        this.windowSeats = windowSeats;
    }

    public int getBasicFare() {
        return basicFare;
    }

    public void setBasicFare(int basicFare) {
        this.basicFare = basicFare;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    @Override
    public String toString() {
        return "Bus [id=" + id + ", name=" + name + ", vehicleNumber=" + vehicleNumber + ", totalSeats=" + totalSeats
                + ", windowSeats=" + windowSeats + ", basicFare=" + basicFare + ", route=" + route + "]";
    }
}
