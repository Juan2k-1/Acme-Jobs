
package domain;

import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.ElementCollection;
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

	private Collection<String>	video;

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

	@URL
	@ElementCollection
	public Collection<String> getVideo() {
		return this.video;
	}

	public void setVideo(final Collection<String> video) {
		this.video = video;
	}

	@ManyToOne(optional = false)
	public Academia getAcademia() {
		return this.academia;
	}

	public void setAcademia(final Academia academia) {
		this.academia = academia;
	}
}
