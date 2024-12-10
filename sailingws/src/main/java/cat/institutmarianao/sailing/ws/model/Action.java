package cat.institutmarianao.sailing.ws.model;

import java.io.Serializable;
import java.util.Date;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.experimental.SuperBuilder;

/* Swagger */
@Schema(oneOf = { Booking.class, Rescheduling.class, Cancellation.class, Done.class}, discriminatorProperty = "type")
/* Lombok */
@Data
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) 
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING) // Columna para distinguir los tipos de usuario
@Table(name = "actions")
public abstract class Action implements Serializable {

	private static final long serialVersionUID = 1L;

	/* Values for type - MUST be constants */
	public static final String BOOKING = "BOOKING";
	public static final String RESCHEDULING = "RESCHEDULING";
	public static final String CANCELLATION = "CANCELLATION";
	public static final String DONE = "DONE";

	public enum Type {
		BOOKING, RESCHEDULING, CANCELLATION, DONE
	}

	/* Lombok */
	@EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
	protected Long id;

	/* Lombok */
	@NonNull
	@Column(name = "type", nullable = false, length = 31)
	protected Type type;
	
	@NonNull(message = "No puede ser null")
    @ManyToOne
    @JoinColumn(name = "performer_id", nullable = false)
	protected User performer;

	@Column(name = "date", nullable = false)
	protected Date date = new Date();

	@ManyToOne
	@JoinColumn(name = "trip_id", nullable = false)
	protected Trip trip;
	
	@Column(name = "trip_id", nullable = false, length = 20)
	protected Long idTrip;
	
	public String getInfo() {
		return "";
	}
}
