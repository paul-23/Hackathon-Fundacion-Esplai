/**
 * 
 */
package pas.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import pas.dao.IUserDAO;
import pas.dto.Users;

/**
 * @author paul_
 *
 */

 @Service
public class UserDetailsServiceImpl implements UserDetailsService {
	 
	 private IUserDAO iUserDAO;

		public UserDetailsServiceImpl(IUserDAO iUserDao) {
			this.iUserDAO = iUserDao;
		}

		@Override
		public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
			Users user = iUserDAO.findByUsername(username);
			if (user == null) {
				throw new UsernameNotFoundException(username);
			}
			return new User(user.getUsername(), user.getPassword(), mapRolesToAuthorities(user.getRole()));
		}
		
		private Collection<GrantedAuthority> mapRolesToAuthorities(String rol) {
			ArrayList<String> roles = new ArrayList<String>();
			roles.add(rol);
			return roles.stream().map(role -> new SimpleGrantedAuthority(role)).collect(Collectors.toList());
		}
		
}
