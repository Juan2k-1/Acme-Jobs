
package domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Past;

@Entity
public class registeredFor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long	id;

	@ManyToOne
	@JoinColumn(name = "alumno_id") //Esta anotación se utiliza para especificar la columna de la tabla relacionada que se utilizará para unir las dos entidades.
	private Alumno	alumno;

	@ManyToOne
	@JoinColumn(name = "curso_id")
	private Curso	curso;

	@Past
	private Date	momento;

	@Enumerated(EnumType.STRING)
	private Estado	estado;


	//Getters y Setters

	public Alumno getAlumno() {
		return this.alumno;
	}

	public void setAlumno(final Alumno alumno) {
		this.alumno = alumno;
	}

	public Curso getCurso() {
		return this.curso;
	}

	public void setCurso(final Curso curso) {
		this.curso = curso;
	}

	public Date getMomento() {
		return this.momento;
	}

	public void setMomento(final Date momento) {
		this.momento = momento;
	}

	public Estado getEstado() {
		return this.estado;
	}

	public void setEstado(final Estado estado) {
		this.estado = estado;
	}

}
