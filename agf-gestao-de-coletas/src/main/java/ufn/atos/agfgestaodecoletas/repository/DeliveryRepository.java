package ufn.atos.agfgestaodecoletas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ufn.atos.agfgestaodecoletas.model.Delivery;

public interface DeliveryRepository extends JpaRepository<Delivery, Integer>{
	
	@Query(value = 
	"select * from delivery where status like \"AGENDADO\";", 
	nativeQuery = true)
	List<Delivery> deliveryActive();
	
	@Query(value = 
	"select * from delivery where status like \"ROTA\";", 
	nativeQuery = true)
	List<Delivery> deliveryEmRota();
	
	@Query(value = 
	"select * from delivery where status like \"ENCERRADO\";", 
	nativeQuery = true)
	List<Delivery> deliveryEncerrado();
	
	@Query(value = 
	"select * from delivery where status like \"CANCELADO\";", 
	nativeQuery = true)
	List<Delivery> deliveryCancelado();
	

}
