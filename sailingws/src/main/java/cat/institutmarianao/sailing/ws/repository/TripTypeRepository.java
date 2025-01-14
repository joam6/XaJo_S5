package cat.institutmarianao.sailing.ws.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cat.institutmarianao.sailing.ws.model.User;
import cat.institutmarianao.sailing.ws.model.User.Role;

public interface TripTypeRepository extends JpaRepository<User, String> {
		@Query("SELECT  FROM TripType")
		List<User> findAllByFilters(Role[] roles, String fullName);
}
