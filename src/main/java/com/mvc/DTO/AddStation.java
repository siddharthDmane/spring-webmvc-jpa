package com.mvc.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddStation {
    public String name;
    public int stationNo;
    public boolean isAlightning; 
    public int fare;
    public int route_id;    
}
