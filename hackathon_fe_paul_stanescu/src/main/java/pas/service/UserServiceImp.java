/**
 * 
 */
package pas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pas.dao.IUserDAO;
import pas.dto.Users;

/**
 * @author paul_
 *
 */

@Service
public class UserServiceImp implements IUserService {
	
	@Autowired
	IUserDAO iUserDAO;

	@Override
	public List<Users> listUsers() {
		return iUserDAO.findAll();
	}

	@Override
	public Users saveUser(Users user) {
		return iUserDAO.save(user);
	}

	@Override
	public Users userById(Long id) {
		return iUserDAO.findById(id).get();
	}

	@Override
	public Users updateUser(Users user) {
		return iUserDAO.save(user);
	}

	@Override
	public void deleteUser(Long id) {
		iUserDAO.deleteById(id);
	}

}
