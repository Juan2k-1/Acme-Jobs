
package converters;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import domain.Estilo;
import services.EstiloService;

@Component
@Transactional
public class StringtoEstilo implements Converter<String, Estilo> {

	@Autowired
	private EstiloService estiloService;


	@Override
	public Estilo convert(final String source) {
		return this.estiloService.findByName(source);
	}
}
