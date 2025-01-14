package cat.institutmarianao.sailing.ws.service;

import java.util.List;

import cat.institutmarianao.sailing.ws.model.TripType;
import jakarta.validation.constraints.NotBlank;


public interface TripTypeService {
	List<TripType> findAll();
	
	TripType getById(long id);
}
