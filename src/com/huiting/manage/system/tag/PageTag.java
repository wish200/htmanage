package com.huiting.manage.system.tag;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;


/**
 *
 * @ClassName: PageTag
 * @Description:  分页标签
 * @author Zou_ZhuoQi
 * @date 2013-12-18 下午2:03:19
 *
 */
public class PageTag extends BodyTagSupport {

    private static final long serialVersionUID = 1L;
    /**
     * 作 用：显示“上一页 下一页”等信息
     *
     * @param url ----链接地址
     * @param totalPut ----总数量
     * @param maxPerPage ----每页数量
     * @param showTotal ----是否显示总数量
     * @param showAllPages ---是否用下拉列表显示所有页面以供跳转。有某些页面不能使用，否则会出现JS错误。
     * @param strUnit ----计数单位
     * @return .
     * @throws IOException
     *
     */
    String url = "";
    boolean showTotal = true;
    boolean showAllPages = false;
    String strUnit = "";

    @Override
    public int doEndTag() throws JspException {
        try {
            HttpServletRequest request = (HttpServletRequest) pageContext
                    .getRequest();
//            SearchDto searchDto = (SearchDto) request.getAttribute("searchDto");
            // Page page = new Page(currentPage, total, pageSize);
            // request.setAttribute("page",page);
            Page page = (Page) request.getAttribute("page"); // searchDto.getPage();
            // // (Sear)
            // request.getAttribute("searchDto");
            Map<String,String[]> map = request.getParameterMap();
            StringBuilder paraList = new StringBuilder("");
            if (map != null) {
                int mapsize = map.size();

                String key;
                String value;
                Object[] keyValuePairs2 = map.keySet().toArray();

                for (int i = 0; i < mapsize; i++) {
                	
                    key = keyValuePairs2[i].toString();
                    value = URLDecoder.decode(request.getParameter(key),"UTF-8");
                    if (!key.equals("page.currentPage")
                            && !key.equals("page.totalCount")/* && !key.equals("page.pageSize")*/) {
                        if (paraList.length() == 0) {
                            paraList.append("?").append(key).append("=").append(value);
                        } else {
                            paraList.append("&").append(key).append("=").append(value);
                        }
                    }
                }
            }
            String out = showPage(page.getCurrentPage(),
                    url + paraList.toString(), page.getTotalCount(),
                    page.getPageSize(), showTotal, showAllPages, strUnit);

            pageContext.getOut().print(out);
        } catch (IOException e) {
            //  Auto-generated catch block
            e.printStackTrace();
        }
        //  Auto-generated method stub
        return EVAL_PAGE;
    }

    private String showPage(int currentPage, String url, int totalPut,
            int maxPerPage, boolean showTotal, boolean showAllPages,
            String strUnit) {
        //  Auto-generated method stub
        int countPage = 0;//总也是

        StringBuilder buf = new StringBuilder();

        String strUrl;
        if(maxPerPage!=0){
        	if (totalPut % maxPerPage == 0) {
        		countPage = totalPut / maxPerPage;
            } else {
            	countPage = totalPut / maxPerPage + 1;
            }
        }
        strUrl = JoinChar(url);
        if(currentPage==1){
        	 buf.append("<a  class='pre no' title='上一页'>上一页</a>");
        }else {
        	 buf.append("<a href=\"javascript:getPage('").append(strUrl).append("page.currentPage=").append(currentPage - 1).append("&page.totalCount=").append(totalPut).append("');\"  class='pre'  title='上一页'>上一页</a>");
		}
        	for(int i=currentPage>countPage-4?countPage-4:currentPage-2;(i<currentPage+3||i<6)&&i<=countPage;i++){
        		if(i<=0){i=1;}
        		buf.append("<a href=\"javascript:getPage('").append(strUrl).append("page.currentPage=").append(i).append("&page.totalCount=").append(totalPut).append("');\" ");
        		if(currentPage==i){
        			buf.append(" class='active'");
        		}
        		buf.append(" > ").append(i).append("</a>");
        	}
        if(currentPage<countPage){
        	buf.append("<a href=\"javascript:getPage('").append(strUrl).append("page.currentPage=").append(currentPage+1).append("&page.totalCount=").append(totalPut).append("');\"  class='next' title='下一页'>下一页</a>");
        }else {
        	buf.append("<a  class='next no' title='下一页'>下一页</a>");
		}
        buf.append("<span>共").append(countPage).
        append("页</span>").
//        append("<span>共").append(totalPut).append("条记录</span>").
        append(" <span>跳转至</span> <input id='toPage' name='' /> <span>页</span>")
        .append("<a style='cursor:pointer;' onclick=\"javascript:var _toPage=$('#toPage').val(); if(_toPage>")
        .append(countPage)
        .append("||_toPage<1){alert('请输入正确的页码'); return;} if(!_toPage.match('^[0-9]{0,}$')){ alert('请输入数字');return;} ").
        append("getPage('").append(strUrl).append("page.currentPage='+_toPage+'&page.totalCount=").append(totalPut).append("');").
        append(" \" class='go'>go</a>");
        return (buf.toString());
    }

    /**
     * 向地址中加入 ? 或 &
     *
     * @param strUrl ----网址.
     * @return 加了 ? 或 & 的网址.
     */
    protected String JoinChar(String strUrl) {

        String result = "";

        if (strUrl.equals("") || strUrl.length() <= 0) {

            return result;

        }

        if (strUrl.indexOf("?") < strUrl.length()) {

            if (strUrl.indexOf("?") > -1) {

                if (strUrl.indexOf("&") < strUrl.length()) {

                    result = strUrl + "&";

                } else {

                    result = strUrl;

                }
            } else {

                result = strUrl + "?";
            }

        } else {
            result = strUrl;
        }

        return result;

    }

    public boolean isShowAllPages() {

        return showAllPages;

    }

    public void setShowAllPages(boolean showAllPages) {

        this.showAllPages = showAllPages;

    }

    public boolean isShowTotal() {

        return showTotal;

    }

    public void setShowTotal(boolean showTotal) {

        this.showTotal = showTotal;

    }

    public String getStrUnit() {

        return strUnit;

    }

    public void setStrUnit(String strUnit) {

        this.strUnit = strUnit;

    }

    public String getUrl() {

        return url;

    }

    public void setUrl(String url) {

        this.url = url;

    }

    @Override
    public int doStartTag() throws JspException {

        return SKIP_BODY;

    }
}
