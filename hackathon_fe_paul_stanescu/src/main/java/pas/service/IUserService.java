/**
 * 
 */
package pas.service;

import java.util.List;

import pas.dto.Users;

/**
 * @author paul_
 *
 */
public interface IUserService {

	public List<Users> listUsers(); // List all users

	public Users saveUser(Users user); // Save user

	public Users userById(Long id); // Get User by ID

	public Users updateUser(Users user); // Update user

	public void deleteUser(Long id); // Delete user by ID

}
