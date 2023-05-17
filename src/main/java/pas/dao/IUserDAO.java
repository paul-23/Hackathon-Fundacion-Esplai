/**
 * 
 */
package pas.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import pas.dto.Users;

/**
 * @author paul_
 *
 */
public interface IUserDAO extends JpaRepository<Users, Long> {
	Users findByUsername(String username);
}
