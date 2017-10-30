package com.baidu.entity;

import java.io.Serializable;
import java.util.List;


@SuppressWarnings("serial")
public class BaseEntity implements Serializable {
    
    /**
     * 分页查询时传递分页对象
     */
    private Page page;

    /**
     * id数组查询，用于查询传参
     */
    private List queryIds;
    /**
     * 状态数组查询，用于查询传参
     */
    private List queryStatusArray;
    /**
     * 查询开始时间，用于查询传参
     */
    private String queryStartTime;
    /**
     * 查询结束时间，用于查询传参
     */
    private String queryEndTime;
    /**
     * 分页排序
     */
    private String orderBy;
    
    /**
     * 备用查询传参
     */
    private Object querySpare;
    
    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public String getQueryStartTime() {
        return queryStartTime;
    }

    public void setQueryStartTime(String queryStartTime) {
        this.queryStartTime = queryStartTime;
    }

    public String getQueryEndTime() {
        return queryEndTime;
    }

    public void setQueryEndTime(String queryEndTime) {
        this.queryEndTime = queryEndTime;
    }

    public List getQueryIds() {
        return queryIds;
    }

    public void setQueryIds(List queryIds) {
        this.queryIds = queryIds;
    }

    public List getQueryStatusArray() {
        return queryStatusArray;
    }

    public void setQueryStatusArray(List queryStatusArray) {
        this.queryStatusArray = queryStatusArray;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

	public Object getQuerySpare() {
		return querySpare;
	}

	public void setQuerySpare(Object querySpare) {
		this.querySpare = querySpare;
	}
    
}
