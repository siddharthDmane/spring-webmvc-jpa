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

import com.mvc.DTO.AddBus;
import com.mvc.Entity.Bus;
import com.mvc.Service.BusService;

@RestController
@RequestMapping("/api")
public class BusController {
    @Autowired
    BusService ss;

    @PostMapping("/bus")
    public String add(@RequestBody AddBus bus){
        ss.addBus(bus);
        return "bus added";
    }    

    @GetMapping("/bus")
    public ResponseEntity<List<Bus>> getBus(){
        return ResponseEntity.ok(ss.getBuses());
    }

    @GetMapping("/bus/{id}")
    public ResponseEntity<Bus> getBusById(@PathVariable(name = "id") int id){
        return ResponseEntity.ok(ss.getBusById(id));
    }

    @DeleteMapping("/bus/{id}")
    public String deleteBusById(@PathVariable(name = "id") int id){
        ss.deleteBusById(id);
        return "bus deleted";
    }

}
