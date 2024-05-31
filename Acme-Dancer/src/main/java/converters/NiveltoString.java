
package converters;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import domain.Nivel;

@Component
@Transactional
public class NiveltoString {

	public String convert(final Nivel source) {
		// Convertir el valor del enumerado Nivel a un String
		return source.name(); // Esto devuelve el nombre del enum en forma de String
	}
}
