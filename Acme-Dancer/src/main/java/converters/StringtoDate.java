
package converters;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class StringtoDate implements Converter<String, Date> {

	private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");


	@Override
	public Date convert(final String source) {
		try {
			final Date date = this.dateFormat.parse(source);
			return date;
		} catch (final ParseException e) {
			throw new IllegalArgumentException("Invalid date format. Please use the pattern ", e);
		}
	}
}
