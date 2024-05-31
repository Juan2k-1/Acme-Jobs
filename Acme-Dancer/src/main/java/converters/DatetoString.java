
package converters;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class DatetoString {

	private static final String		DATE_FORMAT	= "yyyy-MM-dd";
	private final SimpleDateFormat	dateFormat	= new SimpleDateFormat(DatetoString.DATE_FORMAT);


	public String convert(final Date source) {
		return this.dateFormat.format(source);
	}
}
