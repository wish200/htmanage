package com.huiting.manage.system.exp;

import java.io.PrintStream;
import java.io.PrintWriter;

/**
 * @ClassName: DAOException
 * @Description: dao层异常
 * @author Zou_ZhuoQi
 * @date 2013-12-30 下午3:10:51
 */

public class DAOException extends Exception {
	private static final long serialVersionUID = 8014536628694723159L;
	private Throwable paramThrowable = null;

	public DAOException() {
	}

	public DAOException(String paramString) {
		super(paramString);
	}

	public DAOException(Throwable paramThrowable) {
		this.paramThrowable = paramThrowable;
	}

	public DAOException(String paramString, Throwable paramThrowable) {
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

	public String getMessage() {
		String msg = super.getMessage();
		if (null != msg && msg.indexOf("ORA-20001:") != -1) {
			return msg.substring(msg.indexOf("ORA-20001:") + 10,
					msg.indexOf("\n"));
		}
		return msg;
	}
}