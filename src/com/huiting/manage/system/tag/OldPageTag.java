package com.huiting.manage.system.tag;


import java.io.IOException;
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
public class OldPageTag extends BodyTagSupport {

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
                    value = request.getParameter(key);
//                    System.out.println(value+"-----------------++++++++++++");
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
        int n = 0;

        StringBuilder buf = new StringBuilder();

        String strUrl;
        if(maxPerPage!=0){
        	if (totalPut % maxPerPage == 0) {
                n = totalPut / maxPerPage;
            } else {
                n = totalPut / maxPerPage + 1;
            }
        }

        buf.append("<table align='right' style='font-size:12px';class='text_hx'><tr><td>");

        if (showTotal == true) {
            buf.append("共<b>").append(totalPut).append("</b>").append(strUnit).append("&nbsp;");
        }

        strUrl = JoinChar(url);

        if (currentPage < 2) {

            buf.append("首页 上一页 ");

        } else {

            buf.append("<a href='").append(strUrl).append("page.currentPage=1&page.totalCount=").append(totalPut).append("' title='首页'>首页</a>&nbsp;");

            buf.append("<a href='").append(strUrl).append("page.currentPage=").append(currentPage - 1).append("&page.totalCount=").append(totalPut).append("' title='上一页'>上一页</a>&nbsp;");

        }

        if (n - currentPage < 1) {
            buf.append(" 下一页 尾页 ");
        } else {

            buf.append("<a href='").append(strUrl).append("page.currentPage=").append(currentPage + 1).append("&page.totalCount=").append(totalPut).append("' title='下一页'>下一页</a>&nbsp;");

            buf.append("<a href='").append(strUrl).append("page.currentPage=").append(n).append("&page.totalCount=").append(totalPut).append("' title='尾页'>尾页</a>");
        }
        buf.append("&nbsp;<input type=text id='mysearchpage' size=4 value=").append(currentPage).
        		append(" onblur=\"if(this.value>").append(n).
        		append("||this.value<1){ alert('请输入正确的页码'); return;} if(!this.value.match('^[0-9]{0,}$')){ alert('请输入数字');return;} location.href='").
        		append(strUrl).append("page.currentPage='+this.value +'&page.totalCount=" ).append(totalPut).append( "' \">&nbsp;页次：<strong><font color=red>").
        		append(currentPage).append("</font>/").append(n).append("</strong>页 ");
                buf.append("<select  onchange=\"javascript:  var url;    url='").append(strUrl).append("'; if('").append(strUrl)
                .append("'.indexOf('page.pageSize')!=-1){ var reg=new RegExp('page.pageSize=[0-9]+','g');  url=url.replace(reg,''); }; window.location=url+'page.totalCount=")
                .append(totalPut).append("&").append("page.pageSize=").append("'+this.value;\">");
                if(maxPerPage==20){
                	buf.append("<option value=20 selected >20</option><option value=40 >40</option><option value=60 >60</option><option value=").append(totalPut).append(" >全部</option>").
                    append("<select >").append(strUnit).append("/页");
                }else if(maxPerPage==40){
                	buf.append("<option value=20 >20</option><option value=40 selected>40</option><option value=60 >60</option><option value=").append(totalPut).append(" >全部</option>").
                    append("<select >").append(strUnit).append("/页");
                }else if(maxPerPage==60){
                	buf.append("<option value=20 >20</option><option value=40 >40</option><option value=60 selected >60</option><option value=").append(totalPut).append(" >全部</option>").
                    append("<select >").append(strUnit).append("/页");
                }else{
                	buf.append("<option value=20 >20</option><option value=40 >40</option><option value=60 >60</option><option value=").append(totalPut).append(" selected>全部</option>").
                    append("<select >").append(strUnit).append("/页");
                }
                
        if (showAllPages == true) {
            buf.append("&nbsp;转到：<select name='page' size='1' onchange=\"javascript:window.location='").append(strUrl).append("page.to	talCount=").append(totalPut).append("&").append("page.currentPage=").append("'+this.options[this.selectedIndex].value;\">");

            for (int i = 1; i <= n; i++) {

                buf.append("<option value='").append(i).append("'");

                if (currentPage == i) {
                    buf.append(" selected ");
                }

                buf.append(">第").append(i).append("页</option>");
            }
            buf.append("</select>");
        }

        buf.append("</td></tr></table>");

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
