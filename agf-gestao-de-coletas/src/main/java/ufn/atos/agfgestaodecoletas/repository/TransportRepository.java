package ufn.atos.agfgestaodecoletas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ufn.atos.agfgestaodecoletas.model.Transport;

@Repository
public interface TransportRepository extends JpaRepository<Transport, Integer>{

	
	@Query(value = 
	"select distinct a.* from transport as a inner join delivery as b on (a.id = a.id) where b.status like \"ROTA\"", 
	nativeQuery = true)
	List<Transport> transportActive();
	
}

