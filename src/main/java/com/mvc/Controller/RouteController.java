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

import com.mvc.DTO.AddRoute;
import com.mvc.Entity.Route;
import com.mvc.Service.RouteService;

@RestController
@RequestMapping("/api")
public class RouteController {
    @Autowired
    RouteService rs;

    @PostMapping("/route")
    public String addRoute(@RequestBody AddRoute r){
        rs.addRoute(r);
        return "route added.";
    }

    @GetMapping("/route")
    public ResponseEntity<List<Route>> getRoute(){
        return ResponseEntity.ok(rs.getRoutes());
    }

    @GetMapping("/route/{id}")
    public ResponseEntity<Route> getRouteById(@PathVariable(name = "id") int id){
        return ResponseEntity.ok(rs.getRouteById(id));
    }   

    @DeleteMapping("/route/{id}")
    public String deleteRouteById(@PathVariable(name = "id") int id){
        rs.deleteRouteById(id);
        return "route deleted";
    }
}
