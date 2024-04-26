
package domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.CreditCardNumber;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

@Entity
@Access(AccessType.PROPERTY)
public class TarjetaCredito {

	@NotBlank
	private String	titular;

	@NotBlank
	private String	marca;

	@CreditCardNumber
	private String	numero;

	@Range(min = 1, max = 12)
	private int		mes;

	@Range(min = 2024)
	private int		a�o;

	@Pattern(regexp = "[0-9]{3}")
	private String	codigoCVV;


	public String getTitular() {
		return this.titular;
	}

	public void setTitular(final String titular) {
		this.titular = titular;
	}

	public String getMarca() {
		return this.marca;
	}

	public void setMarca(final String marca) {
		this.marca = marca;
	}

	public String getNumero() {
		return this.numero;
	}

	public void setNumero(final String numero) {
		this.numero = numero;
	}

	public int getMes() {
		return this.mes;
	}

	public void setMes(final int mes) {
		this.mes = mes;
	}

	public int getA�o() {
		return this.a�o;
	}

	public void setA�o(final int a�o) {
		this.a�o = a�o;
	}

	public String getCodigoCVV() {
		return this.codigoCVV;
	}

	public void setCodigoCVV(final String codigoCVV) {
		this.codigoCVV = codigoCVV;
	}
}
