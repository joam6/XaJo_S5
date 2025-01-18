package cat.institutmarianao.sailing.ws.model;

import lombok.Data;

import cat.institutmarianao.sailing.ws.validation.groups.OnActionCreate;
import cat.institutmarianao.sailing.ws.validation.groups.OnActionUpdate;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/* Lombok */
@Data
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@Entity
@DiscriminatorValue(Action.CANCELLATION)
public class Cancellation extends Action {
	private static final long serialVersionUID = 1L;

	@Column(name = "reason", length = 255, nullable = true)
	private String reason;
	
	@Override
	public String getInfo() {
		return this.reason;
	}
}
