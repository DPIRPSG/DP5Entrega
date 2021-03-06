/* UserAccountRepository.java
 *
 * Copyright (C) 2014 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the 
 * TDG Licence, a copy of which you may download from 
 * http://www.tdg-seville.info/License.html
 * 
 */

package security;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface UserAccountRepository extends JpaRepository<UserAccount, Integer> {

	UserAccount findByUsername(String username);
	
	/*@Query("select u from UserAccount u where u.actor.id = ?1")
	UserAccount findByActorId(int ActorId);*/

}
