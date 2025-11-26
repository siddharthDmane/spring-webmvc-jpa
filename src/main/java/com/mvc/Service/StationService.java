package com.mvc.Service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.mvc.Entity.Station;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class StationService {
    @PersistenceContext
    EntityManager em;

    public void addStation(Station station){
        em.persist(station);
    }

    public List<Station> getStations(){
        return em.createQuery("from Station",Station.class).getResultList();
    }

    public Station getStationById(int id){
        return (Station)em.createNativeQuery("select * from station where id=?",Station.class)
        .setParameter(1, id)
        .getSingleResult();
    }   
}
