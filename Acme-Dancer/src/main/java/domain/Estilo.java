
package domain;

import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.URL;

@Entity
@Access(AccessType.PROPERTY)
public class Estilo extends DomainEntity {

	@Column(unique = true)
	@NotBlank
	private String				nombre;

	private String				descripcion;

	private Collection<String>	imagen;

	private Collection<String>	video;

	private Collection<Curso>	cursos;


	//Getter and setters
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(final String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(final String descripcion) {
		this.descripcion = descripcion;
	}

	@NotBlank
	@URL
	@ElementCollection
	public Collection<String> getImagen() {
		return this.imagen;
	}

	public void setImagen(final Collection<String> imagen) {
		this.imagen = imagen;
	}

	@NotBlank
	@URL
	@ElementCollection
	public Collection<String> getVideo() {
		return this.video;
	}

	public void setVideo(final Collection<String> video) {
		this.video = video;
	}

	@OneToMany(mappedBy = "estilo")
	public Collection<Curso> getCursos() {
		return this.cursos;
	}

	public void setCursos(final Collection<Curso> cursos) {
		this.cursos = cursos;
	}

}
