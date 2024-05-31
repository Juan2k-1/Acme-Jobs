
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

	private static final String		DATE_FORMAT	= "yyyy-MM-dd";
	private final SimpleDateFormat	dateFormat	= new SimpleDateFormat(StringtoDate.DATE_FORMAT);


	@Override
	public Date convert(final String source) {
		try {
			return this.dateFormat.parse(source);
		} catch (final ParseException e) {
			throw new IllegalArgumentException("Invalid date format. Please use the pattern " + StringtoDate.DATE_FORMAT, e);
		}
	}
}
