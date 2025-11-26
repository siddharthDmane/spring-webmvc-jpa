package com.mvc.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddBus {
    public String name;
    public String vehicleNumber;
    public int totalSeats;
    public int windowSeats;
    public int basicFare;
    public int route_id; 
}
