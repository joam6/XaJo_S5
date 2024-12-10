package cat.institutmarianao.sailing.ws.model;

import java.io.Serializable;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/* Swagger */
@Schema(oneOf = { Client.class, Admin.class }, discriminatorProperty = "role")
/* Lombok */
@Data
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // Usamos una sola tabla para todas las subclases
@DiscriminatorColumn(name = "role", discriminatorType = DiscriminatorType.STRING) // Columna para distinguir los tipos de usuario
@Table(name = "users") // El nombre de la tabla
public abstract class User implements Serializable {
	private static final long serialVersionUID = 1L;

	/* Values for role - MUST be constants (can not be enums) */
	public static final String ADMIN = "ADMIN";
	public static final String CLIENT = "CLIENT";

	public enum Role {
		ADMIN, CLIENT
	}

	public static final int MIN_USERNAME = 2;
	public static final int MAX_USERNAME = 25;
	public static final int MIN_PASSWORD = 10;

	/* Lombok */
	@EqualsAndHashCode.Include
	@Column(name = "username", nullable = false, length = MAX_USERNAME)
	protected String username;

	@Column(name = "password", nullable = false, length = MIN_PASSWORD)
	protected String password;
	
	@Column(name = "role", nullable = false, length = 31)
	protected Role role;
	
	public abstract String getInfo(); 
	
	public boolean isAdmin() {
		return false;
	}

}
