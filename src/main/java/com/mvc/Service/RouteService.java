package com.mvc.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mvc.DTO.AddRoute;
import com.mvc.Entity.Route;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class RouteService {
    @PersistenceContext
    EntityManager em;

    public void addRoute(AddRoute addRouteDto){
        Route new_route = new Route();
        new_route.setfromStation(addRouteDto.fromStation);
        new_route.settoStation(addRouteDto.toStation);
        em.persist(new_route);
        return;
    }

    public List<Route> getRoutes(){
        return em.createQuery("from Route",Route.class).getResultList();
    }

    public Route getRouteById(int id){
        return (Route) em.createNativeQuery("select * from route where id=?",Route.class)
        .setParameter(1, id)
        .getSingleResult();
    }

    public void deleteRouteById(int id){
        Route delete_route = em.find(Route.class,id);
        em.remove(delete_route);
    }    
    
}
