/**
 * 
 */
package br.med.maisvida.jobchallenger.exception;

/**
 * @author gekson
 *
 */
public class JobNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6370951820692236751L;

	public JobNotFoundException(String exception) {
		super(exception);
	}

}
