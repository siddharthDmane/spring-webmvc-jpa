package com.mvc.Service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.mvc.Entity.Bus;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class BusService {
    @PersistenceContext
    EntityManager em;

    public void addBus(Bus bus){
        em.persist(bus);
    }

    public List<Bus> getBuses(){
        return em.createQuery("from Bus",Bus.class).getResultList();
    }

    public  Bus getBusById(int id){
        return (Bus) em.createNativeQuery("select * from bus where id=?",Bus.class)
        .setParameter(1, id)
        .getSingleResult();
    } 
}
