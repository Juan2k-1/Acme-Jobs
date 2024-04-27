
package domain;

import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.URL;

@Entity
@Access(AccessType.PROPERTY)
public class Tutorial extends DomainEntity {

	@NotBlank
	private String				titulo;

	@NotBlank
	private String				descripcion;

	@URL
	private Collection<String>	video;

	//Relaciones

	@ManyToOne(optional = false)
	private Academia			academia;


	//Getters y Setters

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(final String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(final String descripcion) {
		this.descripcion = descripcion;
	}

	public Collection<String> getVideo() {
		return this.video;
	}

	public void setVideo(final Collection<String> video) {
		this.video = video;
	}

	public Academia getAcademia() {
		return this.academia;
	}

	public void setAcademia(final Academia academia) {
		this.academia = academia;
	}
}
