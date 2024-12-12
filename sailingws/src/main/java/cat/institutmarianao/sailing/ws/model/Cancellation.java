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
public class Cancellation extends Action {
	private static final long serialVersionUID = 1L;

	@Column(name="reason", nullable=true)
	private String reason;
	
	@Override
	public String getInfo() {
		return this.reason;
	}
}
