
package domain;

import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Access(AccessType.PROPERTY)
public class Comentario extends DomainEntity {

	@ManyToOne(optional = true)
	private Actor	autor;

	@Past
	private Date	momento;

	@NotBlank
	@Size(min = 1, max = 140)
	private String	descripcion;


	//Getters y Setters

	public Actor getActor() {
		return this.autor;
	}

	public void setAutor(final Actor autor) {
		this.autor = autor;
	}

	public Date getMomento() {
		return this.momento;
	}

	public void setMomento(final Date momento) {
		this.momento = momento;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(final String descripcion) {
		this.descripcion = descripcion;
	}

}
