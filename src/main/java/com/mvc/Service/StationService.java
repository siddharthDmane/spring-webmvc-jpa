package com.mvc.Service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.mvc.DTO.AddStation;
import com.mvc.Entity.Route;
import com.mvc.Entity.Station;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class StationService {
    @PersistenceContext
    EntityManager em;

    public void addStation(AddStation addStationDto){

        Route route = em.find(Route.class,addStationDto.route_id);

        Station new_station = new Station();
        new_station.setName(addStationDto.name);
        new_station.setStationNo(addStationDto.stationNo);
        new_station.setAlightning(addStationDto.isAlightning);
        new_station.setFare(addStationDto.fare);
        new_station.setRoute(route);

        em.persist(new_station);
    }

    public List<Station> getStations(){
        return em.createQuery("from Station",Station.class).getResultList();
    }

    public Station getStationById(int id){
        return (Station)em.createNativeQuery("select * from station where id=?",Station.class)
        .setParameter(1, id)
        .getSingleResult();
    } 
    
    public void deleteStationById(int id){
        Station delete_station = em.find(Station.class,id);
        em.remove(delete_station);
    }
}
