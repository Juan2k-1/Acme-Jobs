
package converters;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import domain.Nivel;

@Component
@Transactional
public class StringtoNivel {

	public Nivel convert(final String source) {
		// Lógica para convertir el String a un valor del enumerado Nivel
		switch (source.toUpperCase()) {
		case "PRINCIPIANTE":
			return Nivel.PRINCIPIANTE;
		case "INTERMEDIO":
			return Nivel.INTERMEDIO;
		case "AVANZADO":
			return Nivel.AVANZADO;
		case "PROFESIONAL":
			return Nivel.PROFESIONAL;
		default:
			throw new IllegalArgumentException("Valor de nivel no válido: " + source);
		}
	}
}
