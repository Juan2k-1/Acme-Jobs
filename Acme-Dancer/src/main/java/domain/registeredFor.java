
package domain;

import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Past;

@Entity
@Access(AccessType.PROPERTY)
public class RegisteredFor extends DomainEntity {

	private Alumno	alumno;

	private Curso	curso;

	@Past
	private Date	momento;

	private Estado	estado;


	//Getters y Setters
	@ManyToOne
	public Alumno getAlumno() {
		return this.alumno;
	}

	public void setAlumno(final Alumno alumno) {
		this.alumno = alumno;
	}

	@ManyToOne
	public Curso getCurso() {
		return this.curso;
	}

	public void setCurso(final Curso curso) {
		this.curso = curso;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getMomento() {
		return this.momento;
	}

	public void setMomento(final Date momento) {
		this.momento = momento;
	}

	@Enumerated(EnumType.STRING)
	public Estado getEstado() {
		return this.estado;
	}

	public void setEstado(final Estado estado) {
		this.estado = estado;
	}

}
