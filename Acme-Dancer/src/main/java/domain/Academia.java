
package domain;

import java.util.Collection;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Access(AccessType.PROPERTY)
public class Academia extends Actor {

	@NotBlank
	@Column(unique = true)
	private String					nombreComercial;

	private Collection<Curso>		cursos;

	private Collection<Tutorial>	tutoriales;


	//Getters y Setters

	public String getNombreComercial() {
		return this.nombreComercial;
	}

	public void setNombreComercial(final String nombreComercial) {
		this.nombreComercial = nombreComercial;
	}

	@OneToMany(mappedBy = "academia")
	public Collection<Curso> getCursos() {
		return this.cursos;
	}

	public void setCursos(final List<Curso> cursos) {
		this.cursos = cursos;
	}

	@OneToMany(mappedBy = "academia")
	public Collection<Tutorial> getTutoriales() {
		return this.tutoriales;
	}

	public void setTutoriales(final List<Tutorial> tutoriales) {
		this.tutoriales = tutoriales;
	}
}
