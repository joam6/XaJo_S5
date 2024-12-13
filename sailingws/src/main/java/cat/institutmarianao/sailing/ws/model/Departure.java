package cat.institutmarianao.sailing.ws.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.hibernate.annotations.Formula;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/* Lombok */
@Data
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "departures")
public class Departure implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final String TZ = "Europe/Madrid";
	
	/* Lombok */
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Positive
	@Column (name = "id", nullable = false, length = 20)
	protected Long id;
	
    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    @JoinColumn (name = "trip_type_id", nullable = false, length=20)
	private TripType tripType;
	
    @NotNull
	@Column (name  = "date" , nullable = false)
	private Date date;

	private Date departure;
	
	/* Hibernate */
	@Formula("(SELECT COALESCE(SUM(t.places), 0) "
			+ "FROM trips t INNER JOIN actions a ON a.trip_id = t.id " 
			+ "WHERE a.type <> '"+Action.CANCELLATION+"' AND "
			+ "t.departure_id = id AND "
			+ "a.date = (SELECT MAX(last.date) FROM actions last WHERE last.trip_id = a.trip_id) "
			+ ")")
	// Lombok
	@Setter(AccessLevel.NONE)
	private int bookedPlaces;
}
