/* StringToOrganiserConverter.java
 *
 * Copyright (C) 2015 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the 
 * TDG Licence, a copy of which you may download from 
 * http://www.tdg-seville.info/License.html
 * 
 */

package converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import repositories.OrganiserRepository;
import domain.Organiser;

@Component
@Transactional
public class StringToOrganiserConverter implements Converter<String, Organiser> {

	@Autowired
	OrganiserRepository organiserRepository;

	@Override
	public Organiser convert(String key) {		
		Assert.hasText(key);
		
		Organiser result;
		int id;		
		
		id = Integer.valueOf(key);		
		result = organiserRepository.findOne(id);
		Assert.notNull(result);
		
		return result;
	}

}
