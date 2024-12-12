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
@DiscriminatorValue("DONE")
public class Done extends Action {
	private static final long serialVersionUID = 1L;

	@Column(name="comments", lenght=255, nullable = true)
	private String comments;
	
	@Override
	public String getInfo() {
		return this.comments;
	}
}
