package cat.institutmarianao.sailing.ws.service;

import java.util.Date;
import java.util.List;

import cat.institutmarianao.sailing.ws.model.Trip;
<<<<<<< HEAD
import cat.institutmarianao.sailing.ws.model.User;
=======
import cat.institutmarianao.sailing.ws.model.Trip.Status;
import cat.institutmarianao.sailing.ws.model.TripType.Category;
>>>>>>> branch 'master' of https://github.com/joam6/XaJo_S5.git
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public interface TripService {
	List<Trip> findAll(Category category, Status status, String clientUsername, Date from, Date to);
	
	Trip getById(long id);
	
	Trip getByClientUsername(@NotBlank String username);	
	
	Trip save(@NotNull @Valid Trip trip);
	
	Trip action(@NotNull @Valid Trip trip);
}
