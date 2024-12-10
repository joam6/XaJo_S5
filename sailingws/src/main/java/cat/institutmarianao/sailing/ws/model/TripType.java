package cat.institutmarianao.sailing.ws.model;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/* Lombok */
@Data
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "trip_types") // El nombre de la tabla
public class TripType implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final int MIN_DEPARTURE_HOUR = 6;
	public static final int MAX_DEPARTURE_HOUR = 14;
	public static final String GROUP = "GROUP";
	public static final String PRIVATE = "PRIVATE";

	public enum Category {
		GROUP, PRIVATE
	}

	/* Lombok */
	@EqualsAndHashCode.Include
	@Column(name = "id", nullable = false)
	private Long id;
	
	@Column(name = "title", nullable = false)
	private String title;

    @Enumerated(EnumType.STRING)  // Esto asegura que el enum se guarda como un String en la base de datos
	@Column(name = "category", nullable = false)
	private Category category;
    
	@Column(name = "description")
	private String description;

    @Column(name = "price", nullable = false)
	private double price;

    @Column(name = "departures")
	private String departures;	// Comma-separated values: 9:30;11:30;13:30
 
    @Column(name = "duration", nullable = false)
	private int duration;

    @Column(name = "max_places")
	private int maxPlaces;
}
