package com.mvc.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mvc.DTO.AddBus;
import com.mvc.Entity.Bus;
import com.mvc.Entity.Route;
import com.mvc.Entity.Station;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class BusService {
    @PersistenceContext
    EntityManager em;

    public void addBus(AddBus addBusDto){

        Route route = em.find(Route.class,addBusDto.route_id);

        Bus new_bus = new Bus();
        new_bus.setName(addBusDto.name);
        new_bus.setvehicleNumber(addBusDto.vehicleNumber);
        new_bus.setTotalSeats(addBusDto.totalSeats);
        new_bus.setWindowSeats(addBusDto.windowSeats);
        new_bus.setBasicFare(addBusDto.basicFare);
        new_bus.setRoute(route);

        em.persist(new_bus);
    }

    public List<Bus> getBuses(){
        return em.createQuery("from Bus",Bus.class).getResultList();
    }

    public  Bus getBusById(int id){
        return (Bus) em.createNativeQuery("select * from bus where id=?",Bus.class)
        .setParameter(1, id)
        .getSingleResult();
    } 

    public void deleteBusById(int id){
        Bus delete_bus = em.find(Bus.class,id);
        em.remove(delete_bus);
    }    
}
