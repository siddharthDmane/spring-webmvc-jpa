package com.mvc.DTO;

public class AddStation {
    public String name;
    public int stationNo;
    public boolean isAlightning;
    public int fare;
    public int route_id;

    public AddStation(String name, int stationNo, boolean isAlightning, int fare, int route_id) {
        this.name = name;
        this.stationNo = stationNo;
        this.isAlightning = isAlightning;
        this.fare = fare;
        this.route_id = route_id;
    }

    @Override
    public String toString() {
        return "AddStation [name=" + name + ", stationNo=" + stationNo + ", isAlightning=" + isAlightning + ", fare="
                + fare + ", route_id=" + route_id + "]";
    }
    
}
