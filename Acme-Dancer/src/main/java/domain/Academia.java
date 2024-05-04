
package domain;

import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Access(AccessType.PROPERTY)
public class Academia extends Actor {

	@NotBlank
	private String			nombreComercial;

	//Relaciones

	@OneToMany(mappedBy = "academia")
	private List<Curso>		cursos;

	@OneToMany(mappedBy = "academia")
	private List<Tutorial>	tutoriales;


	//Getters y Setters

	public String getNombreComercial() {
		return this.nombreComercial;
	}

	public void setNombreComercial(final String nombreComercial) {
		this.nombreComercial = nombreComercial;
	}

	public List<Curso> getCursos() {
		return this.cursos;
	}

	public void setCursos(final List<Curso> cursos) {
		this.cursos = cursos;
	}

	public List<Tutorial> getTutoriales() {
		return this.tutoriales;
	}

	public void setTutoriales(final List<Tutorial> tutoriales) {
		this.tutoriales = tutoriales;
	}
}
