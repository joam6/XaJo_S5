package cat.institutmarianao.sailing.ws.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import cat.institutmarianao.sailing.ws.model.Trip;

public interface TripRepository extends JpaRepository <Trip, Long>{
	List<Trip> findAll();
	
	List<Trip> findByClientUsername(String username);

}
