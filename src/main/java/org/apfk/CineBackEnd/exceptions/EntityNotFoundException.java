package org.apfk.CineBackEnd.exceptions;

public class EntityNotFoundException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EntityNotFoundException(ErrorEnum error) {
		super(error.getKey());
	}
}
