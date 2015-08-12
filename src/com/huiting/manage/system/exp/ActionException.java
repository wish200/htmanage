package com.huiting.manage.system.exp;

import java.io.PrintStream;
import java.io.PrintWriter;

/**
 * @ClassName: ActionException
 * @Description: 
 * @author Zou_ZhuoQi
 * @date 2013-12-30 下午3:08:44
 */

public class ActionException extends Exception {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private Throwable paramThrowable = null;

	public ActionException() {
	}

	public ActionException(String paramString) {
		super(paramString);
	}

	public ActionException(Throwable paramThrowable) {
		this.paramThrowable = paramThrowable;
	}

	public ActionException(String paramString, Throwable paramThrowable) {
		super(paramString);
		this.paramThrowable = paramThrowable;
	}

	public void printStackTrace() {
		super.printStackTrace();
		if (this.paramThrowable != null)
			this.paramThrowable.printStackTrace();
	}

	public void printStackTrace(PrintStream paramPrintStream) {
		super.printStackTrace(paramPrintStream);
		if (this.paramThrowable != null)
			this.paramThrowable.printStackTrace(paramPrintStream);
	}

	public void printStackTrace(PrintWriter paramPrintWriter) {
		super.printStackTrace(paramPrintWriter);
		if (this.paramThrowable != null)
			this.paramThrowable.printStackTrace(paramPrintWriter);
	}

}
