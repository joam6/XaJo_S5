package cat.institutmarianao.sailing.ws.model;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/* Lombok */
@Data
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@Entity
@DiscriminatorValue("CLIENT")  // El nombre de la tabla
public class Client extends User implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final int MIN_FULL_NAME = 3;
	public static final int MAX_FULL_NAME = 100;

	@Column(name = "full_name" , length = MAX_FULL_NAME)  // Mapea el atributo 'fullName' a la columna 'full_name' en la base de datos
	protected String fullName;

    @Column(name = "phone")  // Mapea el atributo 'phone' a la columna 'phone' en la base de datos
	protected Integer phone;
	
	@Override
	public String getInfo() {
		return this.fullName+" ("+this.phone+")";
	}
	
}
