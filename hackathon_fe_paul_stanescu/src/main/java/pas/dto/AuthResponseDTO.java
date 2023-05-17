/**
 * 
 */
package pas.dto;

/**
 * @author paul_
 *
 */

public class AuthResponseDTO {

	private String accessToken;
	private String tokenType = "Bearer ";
	
	/* Constructors */
	
	/**
	 * @param accessToken
	 */

	public AuthResponseDTO(String accessToken) {
		this.accessToken = accessToken;
	}

	/**
	 * @param accessToken
	 * @param tokenType
	 */
	public AuthResponseDTO(String accessToken, String tokenType) {
		super();
		this.accessToken = accessToken;
		this.tokenType = tokenType;
	}
	
	/* Getters */

	/**
	 * @return the accessToken
	 */
	public String getAccessToken() {
		return accessToken;
	}

	/**
	 * @return the tokenType
	 */
	public String getTokenType() {
		return tokenType;
	}
	
	/* Setters */

	/**
	 * @param accessToken the accessToken to set
	 */
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	/**
	 * @param tokenType the tokenType to set
	 */
	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}

}