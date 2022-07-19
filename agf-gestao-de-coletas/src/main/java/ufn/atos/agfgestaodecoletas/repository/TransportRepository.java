package ufn.atos.agfgestaodecoletas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ufn.atos.agfgestaodecoletas.model.Transport;

@Repository
public interface TransportRepository extends JpaRepository<Transport, Integer>{

	//Query para realizar o join e em seguida retornar todos os transportes que estão com as coletas com status em ROTA
	
	@Query(value= "select t.* from transport as t join delivery_transport as dt on t.id = dt.transport_id join delivery as d on d.id = dt.delivery_id where d.status like \"ROTA\" group by t.id;",
	nativeQuery = true)
	List<Transport> transportActive();
	
}

