package ufn.atos.agfgestaodecoletas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ufn.atos.agfgestaodecoletas.model.PersonDeliveryRoute;

public interface PersonDeliveryRouteRepository 
	extends JpaRepository<PersonDeliveryRoute, Integer> {

}