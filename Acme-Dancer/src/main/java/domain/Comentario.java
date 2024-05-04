
package domain;

import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Access(AccessType.PROPERTY)
public class Comentario extends DomainEntity {

	private Actor	autor;

	@Past
	private Date	momento;

	@NotBlank
	@Size(min = 1, max = 140)
	private String	descripcion;


	//Getters y Setters
	@ManyToOne(optional = true)
	public Actor getAutor() {
		return this.autor;
	}

	public void setAutor(final Actor autor) {
		this.autor = autor;
	}

	@Temporal(TemporalType.TIMESTAMP)
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
