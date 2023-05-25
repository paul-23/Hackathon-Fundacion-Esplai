/**
 * 
 */
package pas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import pas.dao.IUserDAO;
import pas.dto.AuthResponseDTO;
import pas.dto.Users;
import pas.security.JwtGenerator;
import pas.service.UserServiceImp;

/**
 * @author paul_
 *
 */

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
		RequestMethod.DELETE })
public class UsersController {
	
	@Autowired
	UserServiceImp userServiceImpl;
	
	private AuthenticationManager authenticationManager;

	private IUserDAO iUserDAO;

	private PasswordEncoder passwordEncoder;

	private JwtGenerator jwtGenerator;

	public UsersController(IUserDAO iUsersDAO, PasswordEncoder PasswordEncoder, JwtGenerator jwtGenerator,
			AuthenticationManager authenticationManager) {
		this.iUserDAO = iUsersDAO;
		this.passwordEncoder = PasswordEncoder;
		this.jwtGenerator = jwtGenerator;
		this.authenticationManager = authenticationManager;
	}
	
	@GetMapping("/welcome")
	public String login() {
		return "Login & Register server";
	}
	
	@PostMapping("/login")
	public String login(@RequestBody Users user) throws JsonProcessingException {
		UsernamePasswordAuthenticationToken test = new UsernamePasswordAuthenticationToken(user.getUsername(),
				user.getPassword());

		Authentication authentication = authenticationManager.authenticate(test);

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String token = jwtGenerator.generateToken(authentication);
		AuthResponseDTO authResponseDTO = new AuthResponseDTO(token);
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(authResponseDTO);
	}

	@PostMapping("/register")
	public Users saveUsuario(@RequestBody Users user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		iUserDAO.save(user);
		return user;
	}

	@GetMapping("/users")
	public List<Users> listUsers() {
		return userServiceImpl.listUsers();
	}

	@GetMapping("/users/{id}")
	public Users getUserById(@PathVariable(name = "id") Long id) {
		return userServiceImpl.userById(id);
	}

	@PutMapping("/users/{id}")
	public Users updateUser(@PathVariable(name = "id") Long id, @RequestBody Users user) {

		Users selectedUser = new Users();

		selectedUser = userServiceImpl.userById(id);
		selectedUser.setUsername(user.getUsername());
		selectedUser.setPassword(user.getPassword());
		selectedUser.setRole(user.getRole());

		return userServiceImpl.updateUser(selectedUser);
	}

	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable(name = "id") Long id) {
		userServiceImpl.deleteUser(id);
	}
	
}
