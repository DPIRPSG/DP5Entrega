/* OrganiserToStringConverter.java
 *
 * Copyright (C) 2015 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the 
 * TDG Licence, a copy of which you may download from 
 * http://www.tdg-seville.info/License.html
 * 
 */

package converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import domain.Organiser;

@Component
@Transactional
public class OrganiserToStringConverter implements Converter<Organiser, String> {
	
	@Override
	public String convert(Organiser organiser) {
		Assert.notNull(organiser);
		
		String result;		
		
		result = String.valueOf(organiser.getId());
		
		return result;
	}

}
