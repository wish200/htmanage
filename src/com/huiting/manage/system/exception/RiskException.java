package com.huiting.manage.system.exception;

public class RiskException extends Exception{
    /**
	 * 
	 */
	private String msga;
	private static final long serialVersionUID = 1L;

	public RiskException(String msg){
    	super(msg);
    	msga=msg;
    }

	@Override
	public String toString() {
		return msga;
	}
	
}
