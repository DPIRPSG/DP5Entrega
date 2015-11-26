/* OrganiserRepository.java
 *
 * Copyright (C) 2015 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the 
 * TDG Licence, a copy of which you may download from 
 * http://www.tdg-seville.info/License.html
 * 
 */

package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.Organiser;

@Repository
public interface OrganiserRepository extends JpaRepository<Organiser, Integer> {

	@Query("select o from Organiser o where o.userAccount.id = ?1")
	Organiser findByUserAccountId(int id);
		
}
