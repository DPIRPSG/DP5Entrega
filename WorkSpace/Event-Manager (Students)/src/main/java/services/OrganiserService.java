/* OrganiserService.java
 *
 * Copyright (C) 2015 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the 
 * TDG Licence, a copy of which you may download from 
 * http://www.tdg-seville.info/License.html
 * 
 */

package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import repositories.OrganiserRepository;
import security.LoginService;
import security.UserAccount;
import domain.Organiser;

@Service
@Transactional
public class OrganiserService {

	// Managed repository -------------------------------------------------

	@Autowired
	private OrganiserRepository organiserRepository;

	// Constructors -------------------------------------------------------

	public OrganiserService() {
		super();
	}

	// Business methods ---------------------------------------------------

	public Organiser findByPrincipal() {
		Organiser result;
		UserAccount userAccount;

		userAccount = LoginService.getPrincipal();
		Assert.notNull(userAccount);
		result = findByUserAccount(userAccount);
		Assert.notNull(result);

		return result;
	}

	public Organiser findByUserAccount(UserAccount userAccount) {
		Assert.notNull(userAccount);

		Organiser result;

		result = organiserRepository.findByUserAccountId(userAccount.getId());
		Assert.notNull(result);

		return result;
	}

}
