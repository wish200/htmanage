package com.huiting.manage.action.common;

/**
 * @ClassName: NotFoundErrerAction
 * @Description: 输入action找不到对应的跳转
 * @author Zou_ZhuoQi
 * @date 2013-12-30 下午2:16:14
 */

public class NotFoundErrerAction extends BaseAction {
	private static final long serialVersionUID = 6218614965524501080L;

	@Override
	public String execute() throws Exception {
		System.out.println("您访问的action 不存在!");
		return super.execute();
	}

}
