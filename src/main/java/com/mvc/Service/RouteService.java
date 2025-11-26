package com.mvc.Service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.mvc.Entity.Route;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class RouteService {
    @PersistenceContext
    EntityManager em;

    public void addRoute(Route route){
        em.persist(route);
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
    
}
