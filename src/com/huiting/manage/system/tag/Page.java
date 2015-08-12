package com.huiting.manage.system.tag;

import java.io.Serializable;

/**
 * @ClassName: Page
 * @Description:  分页实体类
 * @author Zou_ZhuoQi
 * @date 2013-12-18 下午1:55:17
 *
 */
public class Page implements Serializable {

    private static final long serialVersionUID = 1L;
    private int totalPages; // 总页数
    private int pageSize = 20; // 每页条数
    private int totalCount; // 总条数
    private int currentPage = 1; // 当前页
    private int startIndex; // 从第几条开始取
    private int endIndex; // 从第几条开始取

    public Page() {
    	super();
    }

    public Page(int currentPage, int totalCount, int pageSize) {
        this.currentPage = currentPage;
        this.totalCount = totalCount;
        if (0 == totalCount % pageSize) {
            totalPages = totalCount / pageSize;
        } else {
            totalPages = totalCount / pageSize + 1;
        }
        this.totalPages = totalPages;
        this.pageSize = pageSize;

        this.startIndex = (currentPage - 1) * pageSize;
        this.endIndex = currentPage * pageSize;

    }

    /**
     * @return Returns the currentPage.
     */
    public int getCurrentPage() {
        return currentPage;
    }

    /**
     * @param currentPage The currentPage to set.
     */
    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    /**
     * @return Returns the startIndex.
     */
    public int getStartIndex() {
        return (currentPage - 1) * pageSize;
    }

    /**
     * @param startIndex The startIndex to set.
     */
    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    /**
     * @return Returns the totalPages.
     */
    public int getTotalPages() {
        if (0 == totalCount % pageSize) {
            totalPages = totalCount / pageSize;
        } else {
            totalPages = totalCount / pageSize + 1;
        }
        return totalPages;
    }

    /**
     * @param totalPages The totalPages to set.
     */
    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getEndIndex() {
        return currentPage * pageSize;
    }

    public void setEndIndex(int endIndex) {
        this.endIndex = endIndex;
    }

    // 查询到下一页
    public int getNextPage() {
        if (currentPage >= totalPages) {
            return totalPages;
        } else if (currentPage < 1) {
            return 1;
        } else {
            return currentPage + 1;
        }
    }

    // 查询到上一页
    public int getPreviousPage() {

        if (currentPage > totalPages) {
            return totalPages;
        } else if (currentPage <= 1) {
            return 1;
        } else {
            return currentPage - 1;
        }
    }
}
