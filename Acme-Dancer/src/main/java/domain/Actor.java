
package domain;

import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
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
	private String				nombre;

	@NotBlank
	private String				apellidos;

	@Email
	private String				email;

	@Pattern(regexp = "[0-9]{9}")
	private String				telefono;

	private Direccion			direccion;

	@OneToMany(mappedBy = "Autor")
	private List<Comentario>	comentarios;

	@ManyToMany
	private List<Actor>			publicadores;

	@ManyToMany
	private List<Actor>			subscriptores;


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

	public List<Comentario> getComentarios() {
		return this.comentarios;
	}

	public void setComentarios(final List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	public List<Actor> getPublicadores() {
		return this.publicadores;
	}

	public void setPublicadores(final List<Actor> publicadores) {
		this.publicadores = publicadores;
	}

	public List<Actor> getSubscriptores() {
		return this.subscriptores;
	}

	public void setSubscriptores(final List<Actor> subscriptores) {
		this.subscriptores = subscriptores;
	}
}
