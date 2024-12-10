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
	protected Long id;

	/* Lombok */
	@NonNull
	@Column(name = "type", nullable = false, length = 31)
	protected Type type;
	
	@NonNull(message = "No puede ser null")
	protected User performer;

	protected Date date = new Date();

	protected Trip trip;
	
	@Column(name = "trip_id", nullable = false, length = 20)
	protected Long idTrip;
	
	public String getInfo() {
		return "";
	}
}
