package com.huiting.manage.system.exp;

import java.io.PrintStream;
import java.io.PrintWriter;

/**
 * @ClassName: AjaxException
 * @Description: 
 * @author Zou_ZhuoQi
 * @date 2013-12-30 下午3:09:52
 */

public class AjaxException extends Exception {
	private static final long serialVersionUID = 1L;

	private Throwable paramThrowable = null;

	public Throwable getParamThrowable() {
		return paramThrowable;
	}

	public void setParamThrowable(Throwable paramThrowable) {
		this.paramThrowable = paramThrowable;
	}

	public AjaxException() {
	}

	public AjaxException(String paramString) {
		super(paramString);
	}

	public AjaxException(Throwable paramThrowable) {
		this.paramThrowable = paramThrowable;
	}

	public AjaxException(String paramString, Throwable paramThrowable) {
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
