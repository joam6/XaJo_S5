package cat.institutmarianao.sailing.ws.service;

import java.util.List;

import cat.institutmarianao.sailing.ws.model.Trip;
import cat.institutmarianao.sailing.ws.model.User;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public interface TripService {
	List<Trip> findAll();
	
	Trip getById(long id);
	
	Trip getByClientUsername(@NotBlank String username);	
	
	Trip save(@NotNull @Valid Trip trip);
	
	Trip action(@NotNull @Valid Trip trip);
}
