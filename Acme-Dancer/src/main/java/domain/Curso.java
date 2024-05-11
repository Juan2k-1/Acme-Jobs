
package domain;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Access(AccessType.PROPERTY)
public class Curso extends DomainEntity {

	@NotBlank
	private String						titulo;

	private Nivel						nivel;

	private Date						fechaInicio;

	private Date						fechaFin;

	private String						hora;

	private Estilo						estilo;

	private Academia					academia;

	private Collection<RegisteredFor>	registeredFor;


	//getters and setters
	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(final String titulo) {
		this.titulo = titulo;
	}

	@ManyToOne(optional = true)
	public Estilo getEstilo() {
		return this.estilo;
	}

	public void setEstilo(final Estilo estilo) {
		this.estilo = estilo;
	}

	@Enumerated(EnumType.STRING)
	public Nivel getNivel() {
		return this.nivel;
	}

	public void setNivel(final Nivel nivel) {
		this.nivel = nivel;
	}

	@Temporal(TemporalType.DATE)
	public Date getFechaInicio() {
		return this.fechaInicio;
	}

	public void setFechaInicio(final Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	@Temporal(TemporalType.DATE)
	public Date getFechaFin() {
		return this.fechaFin;
	}

	public void setFechaFin(final Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	@DateTimeFormat(pattern = "hh:mm:ss")
	public String getHora() {
		return this.hora;
	}

	public void setHora(final String hora) {
		this.hora = hora;
	}

	@ManyToOne(optional = false)
	public Academia getAcademia() {
		return this.academia;
	}

	public void setAcademia(final Academia academia) {
		this.academia = academia;
	}

	@OneToMany(mappedBy = "curso")
	public Collection<RegisteredFor> getRegisteredFor() {
		return this.registeredFor;
	}

	public void setRegisteredFor(final Collection<RegisteredFor> registeredFor) {
		this.registeredFor = registeredFor;
	}

}
