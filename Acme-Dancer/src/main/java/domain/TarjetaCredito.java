
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
	private int		año;

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

	public int getAño() {
		return this.año;
	}

	public void setAño(final int año) {
		this.año = año;
	}

	public String getCodigoCVV() {
		return this.codigoCVV;
	}

	public void setCodigoCVV(final String codigoCVV) {
		this.codigoCVV = codigoCVV;
	}
}
