package cat.institutmarianao.sailing.ws.model;

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
@DiscriminatorValue("Cancellation")
public class Cancellation extends Action {
	private static final long serialVersionUID = 1L;
<<<<<<< HEAD

	@Column(name="reason", nullable=true)
=======
	
	@Column(name = "reason", length = 255, nullable = true)
>>>>>>> branch 'master' of https://github.com/joam6/XaJo_S5.git
	private String reason;
	
	@Override
	public String getInfo() {
		return this.reason;
	}
}
