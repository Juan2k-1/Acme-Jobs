
package domain;

import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Access(AccessType.PROPERTY)
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Actor extends DomainEntity {

	@NotBlank
	private String					nombre;

	@NotBlank
	private String					apellidos;

	@Email
	@Column(unique = true)
	private String					email;

	@Pattern(regexp = "\\+\\d{2}\\d{9}")
	@Column(unique = true)
	private String					telefono;

	private Direccion				direccion;

	private Collection<Comentario>	comentarios;

	private Collection<Actor>		publicadores;

	private Collection<Actor>		subscriptores;


	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(final String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(final String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(final String email) {
		this.email = email;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(final String telefono) {
		this.telefono = telefono;
	}

	public Direccion getDireccion() {
		return this.direccion;
	}

	public void setDireccion(final Direccion direccion) {
		this.direccion = direccion;
	}

	@OneToMany
	public Collection<Comentario> getComentarios() {
		return this.comentarios;
	}

	public void setComentarios(final Collection<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	@ManyToMany
	@JoinTable(name = "actor_publicadores", joinColumns = @JoinColumn(name = "actor_id"), inverseJoinColumns = @JoinColumn(name = "publicador_id"))
	public Collection<Actor> getPublicadores() {
		return this.publicadores;
	}

	public void setPublicadores(final Collection<Actor> publicadores) {
		this.publicadores = publicadores;
	}

	@ManyToMany(mappedBy = "publicadores")
	public Collection<Actor> getSubscriptores() {
		return this.subscriptores;
	}

	public void setSubscriptores(final Collection<Actor> subscriptores) {
		this.subscriptores = subscriptores;
	}
}
