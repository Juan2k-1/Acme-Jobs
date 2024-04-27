
package domain;

import java.sql.Time;
import java.util.Date;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Access(AccessType.PROPERTY)

public class Curso extends DomainEntity {

	@NotBlank
	private String				titulo;

	private Nivel				nivel;

	private Date				fechaInicio;

	private Date				fechaFin;

	private Time				hora;

	//Relaciones

	@ManyToOne(optional = true)
	private Estilo				estilo;

	@ManyToOne(optional = false)
	private Academia			academia;

	@OneToMany(mappedBy = "involucra")
	private List<registeredFor>	registeredFor;


	//getters and setters
	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(final String titulo) {
		this.titulo = titulo;
	}

	public Estilo getEstilo() {
		return this.estilo;
	}

	public void setEstilo(final Estilo estilo) {
		this.estilo = estilo;
	}

	public Nivel getNivel() {
		return this.nivel;
	}

	public void setNivel(final Nivel nivel) {
		this.nivel = nivel;
	}

	public Date getFechaInicio() {
		return this.fechaInicio;
	}

	public void setFechaInicio(final Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return this.fechaFin;
	}

	public void setFechaFin(final Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Time getHora() {
		return this.hora;
	}

	public void setHora(final Time hora) {
		this.hora = hora;
	}

	public Academia getAcademia() {
		return this.academia;
	}

	public void setAcademia(final Academia academia) {
		this.academia = academia;
	}

	public List<registeredFor> getRegisteredFor() {
		return this.registeredFor;
	}

	public void setRegisteredFor(final List<registeredFor> registeredFor) {
		this.registeredFor = registeredFor;
	}

}
