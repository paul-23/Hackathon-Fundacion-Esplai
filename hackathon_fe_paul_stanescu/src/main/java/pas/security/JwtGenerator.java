/**
 * 
 */
package pas.security;

import java.util.Date;

import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;

/**
 * @author paul_
 *
 */

@Component
public class JwtGenerator {

	 public String generateToken(Authentication authentication) {
	        String username = authentication.getName();
	        Date currentDate = new Date();
	        Date expirationDate = new Date(currentDate.getTime() + Constants.TOKEN_EXPIRATION_TIME);

	        String token = Jwts.builder()
	                .setSubject(username)
	                .setIssuedAt(currentDate)
	                .setExpiration(expirationDate)
	                .signWith(Constants.SECRET_KEY)
	                .compact();

	        return token;
	    }

	    public String getUserNameFromJwt(String token) {
	        Jws<Claims> claims = Jwts.parserBuilder()
	                .setSigningKey(Constants.SECRET_KEY)
	                .build()
	                .parseClaimsJws(token);

	        return claims.getBody().getSubject();
	    }

	    public boolean validateToken(String token) {
	        try {
	            Jwts.parserBuilder()
	                    .setSigningKey(Constants.SECRET_KEY)
	                    .build()
	                    .parseClaimsJws(token);
	            return true;
	        } catch (Exception e) {
	            throw new AuthenticationCredentialsNotFoundException("JWT was expired or incorrect");
	        }
	    }

}
