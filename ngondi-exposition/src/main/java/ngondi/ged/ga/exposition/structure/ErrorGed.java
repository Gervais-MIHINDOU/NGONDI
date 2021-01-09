/**
 * 
 */
package ngondi.ged.ga.exposition.structure;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author gmihindou
 *
 */
public class ErrorGed {
	@JsonProperty
	private String code;
	@JsonProperty
	private List<String> message;

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the message
	 */
	public List<String> getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(List<String> message) {
		this.message = message;
	}

}
