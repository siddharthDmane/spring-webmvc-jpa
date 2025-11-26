package com.mvc.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mvc.DTO.AddStation;
import com.mvc.Entity.Station;
import com.mvc.Service.StationService;

@RestController
@RequestMapping("/api")
public class StationController {
    
    @Autowired
    StationService ss;

    @PostMapping("/station")
    public String add(@RequestBody AddStation addStationDto){          
        ss.addStation(addStationDto);
        return "station added";
    }

    @GetMapping("/station")
    public ResponseEntity<List<Station>> getStations(){
        return ResponseEntity.ok(ss.getStations());
    }

    @GetMapping("/station/{id}")
    public ResponseEntity<Station> getStationById(@PathVariable(name = "id") int id){
        return ResponseEntity.ok(ss.getStationById(id));
    }   

    @DeleteMapping("/station/{id}")
    public String deleteStationById(@PathVariable(name = "id") int id){
        ss.deleteStationById(id);
        return "station deleted";
    }
}
