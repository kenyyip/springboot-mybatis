package com.keny.pager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Page<T> {  
  
    public static final int DEFAULT_PAGE_SIZE = 10;  
  
    private Integer pageNo = 1; // 当前页, 默认为第1页  
    private Integer pageSize = DEFAULT_PAGE_SIZE; // 每页记录数  
    private Long totalRecord = -1L; // 总记录数, 默认为-1, 表示需要查询  
    private Long totalPage = -1L; // 总页数, 默认为-1, 表示需要计算  
  
    private List<T> results; // 当前页记录List形式  
    
    private Map<String, Object> params = new HashMap<String, Object>();//设置页面传递的集合查询参数
  
    public Page() {
		super();
	}

	public Page(Integer pageNo, Integer pageSize) {
		super();
		this.pageNo = pageNo;
		this.pageSize = pageSize;
	}
  
    public Integer getPageNo() {  
        return pageNo;  
    }  
  
    public void setPageNo(Integer pageNo) {  
        this.pageNo = pageNo;  
    }  
  
    public Integer getPageSize() {  
        return pageSize;  
    }  
  
    public void setPageSize(Integer pageSize) {  
        this.pageSize = pageSize;  
        computeTotalPage();  
    }  
  
    public Long getTotalRecord() {  
        return totalRecord;  
    }  
  
    public Long getTotalPage() {  
        return totalPage;  
    }  
  
    public void setTotalRecord(Long totalRecord) {  
        this.totalRecord = totalRecord;  
        computeTotalPage();  
    }  
  
    protected void computeTotalPage() {  
        if (getPageSize() > 0 && getTotalRecord() > -1) {  
            this.totalPage = (Long) (getTotalRecord() % getPageSize() == 0 ? getTotalRecord() / getPageSize() : getTotalRecord() / getPageSize() + 1);  
        }  
    }  
  
    public List<T> getResults() {  
        return results;  
    }  
  
    public void setResults(List<T> results) {  
        this.results = results;  
    }  
  
    public Map<String, Object> getParams() {
		return params;
	}

	public void setParams(Map<String, Object> params) {
		this.params = params;
	}

	public void setTotalPage(Long totalPage) {
		this.totalPage = totalPage;
	}

	@Override  
    public String toString() {  
        StringBuilder builder = new StringBuilder().append("Page [pageNo=").append(pageNo).append(", pageSize=").append(pageSize)  
                .append(", totalRecord=").append(totalRecord < 0 ? "null" : totalRecord).append(", totalPage=")  
                .append(totalPage < 0 ? "null" : totalPage).append(", curPageObjects=").append(results == null ? "null" : results.size()).append("]");  
        return builder.toString();  
    }  
  
}