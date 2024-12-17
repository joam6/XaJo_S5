package cat.institutmarianao.sailing.ws.model;

import java.io.Serializable;

import cat.institutmarianao.sailing.ws.validation.groups.OnTripTypeCreate;
import cat.institutmarianao.sailing.ws.validation.groups.OnTripTypeUpdate;

<<<<<<< HEAD

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance; 
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

=======
>>>>>>> branch 'master' of https://github.com/joam6/XaJo_S5.git
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
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, length = 20)
	private Long id;
	
	@NotBlank
	@Column(name = "title", nullable = false, length = 255)
	private String title;

	@NotNull
    @Enumerated(EnumType.STRING)  // Esto asegura que el enum se guarda como un String en la base de datos
	@Column(name = "category", nullable = false)
	private Category category;
    
	@NotBlank
	@Column(name = "description", nullable = false, length = 255)
	private String description;

	@NotNull
    @Column(name = "price", nullable = false)
	private double price;

    @Column(name = "departures", nullable = true, length = 255)
	private String departures;	// Comma-separated values: 9:30;11:30;13:30
 
	@NotNull
	@Positive
    @Column(name = "duration", nullable = false, length = 11)
	private int duration;

    @Column(name = "max_places", nullable = true, length = 11)
	private int maxPlaces;
}
