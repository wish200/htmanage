package com.huiting.manage.system.interceptor;

import java.util.Collections;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptorUtil;
import com.opensymphony.xwork2.util.TextParseUtil;
import com.huiting.manage.action.common.BaseAction;
import com.huiting.manage.action.common.CcUserLoginAction;
import com.huiting.manage.dto.common.CcUserDto;
import com.huiting.manage.system.util.Constants;

/**
 *
 * @ClassName: SessionIterceptor
 * @Description: 自定义session拦截器,处理session过期
 * @author Zou_ZhuoQi
 * @date 2013-12-22 下午1:02:57
 */
@SuppressWarnings("serial")
public class SessionIterceptor extends AbstractInterceptor {
    // 不被拦截的方法

    protected Set<String> excludeMethods = Collections.emptySet();
    protected Set<String> includeMethods = Collections.emptySet();
    private static Logger logger = Logger.getLogger(SessionIterceptor.class);

    @Override
    public String intercept(ActionInvocation ai) throws Exception {
        Object action = ai.getAction();System.out.println("1----1-----2-----------------------------"+action.getClass());
        ActionContext ctx = ai.getInvocationContext();
        // 确认Session中是否存在用户对象
        Map<String, Object> session = ctx.getSession();
        HttpServletResponse response = ServletActionContext.getResponse();
        HttpServletRequest request = ServletActionContext.getRequest();
        CcUserDto ccUserDto = (CcUserDto) session.get(Constants.USERLOGIN);
System.out.println("1--------------------------------------"+ccUserDto);
        logger.info("拦截器session校验开始");
        System.out.println(action instanceof CcUserLoginAction );
        System.out.println(applyMethodInterceptor(ai) );
        if (ccUserDto != null) {
            // 存在的情况下进行后续操作。
            if (isAjaxRequest(request)) {
                logger.info("ajax访问,用户信息session存在");
                BaseAction ba = (BaseAction) ai.getAction();
                ba.setServletRequest(request);
                ba.setServletResponse(response);
                ba.setSession(ctx.getSession());
                return ai.invoke();
            } else {
                logger.info("用户信息session存在");
                return ai.invoke();
            }
        } else if (action instanceof CcUserLoginAction
                && applyMethodInterceptor(ai)) {
            logger.info("访问登录action,login、logout方法");
            return ai.invoke();
        } else {
            // 否则终止后续操作，返回LOGIN
            logger.info("session过期，退出登录");
            return "logout";
        }

    }

    /**
     * @Title: applyMethodInterceptor
     * @Description: 允许通过的方法名称用逗号分开
     * @param
     * @param invocation
     * @return boolean
     */
    protected boolean applyMethodInterceptor(ActionInvocation invocation) {
        String method = invocation.getProxy().getMethod();
        // ValidationInterceptor
        boolean applyMethod = MethodFilterInterceptorUtil.applyMethod(
                excludeMethods, includeMethods, method);
        System.out.println(method+excludeMethods.toString()+includeMethods.toString());
        if (logger.isDebugEnabled()) {
            if (!applyMethod) {
                logger.debug("Skipping Interceptor... Method [" + method
                        + "] found in exclude list.");
            }
        }
        return applyMethod;
    }

    /**
     * @Title: isAjaxRequest
     * @Description: 判断是否是ajax访问
     * @param
     * @param request
     * @return boolean
     */
    private boolean isAjaxRequest(HttpServletRequest request) {
        String header = request.getHeader("X-Requested-With");
        if (header != null && "XMLHttpRequest".equals(header)) {
            return true;
        } else {
            return false;
        }
    }

    public void setExcludeMethods(String excludeMethods) {
        this.excludeMethods = TextParseUtil
                .commaDelimitedStringToSet(excludeMethods);
    }

    public Set<String> getExcludeMethodsSet() {
        return excludeMethods;
    }

    public void setIncludeMethods(String includeActions) {
        this.includeMethods = TextParseUtil
                .commaDelimitedStringToSet(includeActions);
    }

    public Set<String> getIncludeMethodsSet() {
        return includeMethods;
    }
}
