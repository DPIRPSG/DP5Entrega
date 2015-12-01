/* EventRepository.java
 *
 * Copyright (C) 2015 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the 
 * TDG Licence, a copy of which you may download from 
 * http://www.tdg-seville.info/License.html
 * 
 */

package repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {

	@Query("select e from Event e where ?1 member of e.customers")
	Collection<Event> findByCustomerId(int customerId);
	
	@Query("select e from Event e where ?1 not member of e.customers")
	Collection<Event> findByNotCustomerId(int customerId);

	@Query("select e from Event e where e.organiser.id = ?1")
	Collection<Event> findByOrganiserId(int id);
	
}
