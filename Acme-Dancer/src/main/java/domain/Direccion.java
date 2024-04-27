
package domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Embeddable;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

@Embeddable
@Access(AccessType.PROPERTY)
public class Direccion {

	@NotBlank
	private String	direccion;
	@Range(min = 10000, max = 99999)
	private int		codigoPostal;


	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(final String direccion) {
		this.direccion = direccion;
	}

	public int getCodigoPostal() {
		return this.codigoPostal;
	}

	public void setCodigoPostal(final int codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
}
