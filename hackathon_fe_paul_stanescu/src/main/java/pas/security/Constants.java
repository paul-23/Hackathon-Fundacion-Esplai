/**
 * 
 */
package pas.security;

import java.security.Key;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

/**
 * @author paul_
 *
 */
public class Constants {

	public static final String LOGIN_URL = "/login";
	public static final String HEADER_AUTHORIZACION_KEY = "Authorization";
	public static final String TOKEN_BEARER_PREFIX = "Bearer ";


	public static final String ISSUER_INFO = "admin";
	public static final String SUPER_SECRET_KEY = "2p980453nySRYNHDGFB234634ys34v2676f5rq34bvSDFBHEYJS34f456747iknub45wctgsrfw4w45b7yub6j75uryt45e6n7urytf";
	public static final long TOKEN_EXPIRATION_TIME = 86400000; // 24 horas en milisegundos
	public static final Key SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS512);
	
}
