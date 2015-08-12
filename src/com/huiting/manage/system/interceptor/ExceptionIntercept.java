package com.huiting.manage.system.interceptor;

import java.sql.SQLException;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.huiting.manage.system.exp.ActionException;
import com.huiting.manage.system.exp.AjaxException;

/**
 * @ClassName: ExceptionIntercept
 * @Description: 异常处理
 * @author Zou_ZhuoQi
 * @date 2013-12-30 下午3:07:23
 */

public class ExceptionIntercept extends AbstractInterceptor {
	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation ac) throws Exception {
		String actionName = ac.getInvocationContext().getName();
		try {
			return ac.invoke();
		} catch (NumberFormatException e) {
			throw new ActionException("数据格式化转换失败，请检查代码！", e);
		} catch (SQLException e) {
			throw new ActionException("数据库查询SQL报错，请检查代码！", e);
		} catch (NullPointerException e) {
			throw new ActionException("执行代码出现空指针异常，请检查代码！", e);
		} catch (IndexOutOfBoundsException e) {
			throw new ActionException("数组下标越界，请检查代码！", e);
		} catch (ActionException e) {
			throw new ActionException(e.getMessage(), e);
		} catch (AjaxException e) {
			throw new AjaxException(e.getMessage(), e);
		} catch (Exception e) {
			// 其他未知异常
			throw new ActionException("发生未知异常！<br/>ACTION名称" + actionName
					+ "<br/>请检查代码！", e);
		}
	}

}
