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
@Table(name = "users")
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
	@Column(name = username)
	protected String username;

	@Column(name = "password")
	protected String password;
	
	@Column(name = "role")
	protected Role role;
	
	public abstract String getInfo(); 
	
	public boolean isAdmin() {
		return false;
	}

}
