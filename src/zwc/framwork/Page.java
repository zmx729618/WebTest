package zwc.framwork;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

public class Page<T> implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private static int DEFAULT_PAGE_SIZE=10;
    protected int pageNo = 1;
    protected int pageSize = DEFAULT_PAGE_SIZE;
    protected List<T> result = Collections.emptyList();
    protected long totalCount = -1L;
	  
	public Page(){
		
    }

	public Page(int pageSize) {

		this.pageSize = pageSize;
	}

	public Page(int pageNo, int pageSize, List<T> result, long totalCount) {
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		this.result = result;
		this.totalCount = totalCount;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
	    if (pageNo < 1){
	        this.pageNo = 1;
	    }else{
	    	this.pageNo = pageNo;
	    }
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		
	    if (pageSize < 1){
	        this.pageSize = 1;
	    }else{
	    	this.pageSize = pageSize;
	    }
	    
	}

	public List<T> getResult() {
		return result;
	}

	public void setResult(List<T> result) {
		this.result = result;
	}

	public long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(long totalCount) {
		
		this.totalCount = totalCount;
	}
	
	public long getTotalPages()
	  {
	    if (this.totalCount < -1L) return -1L;

	    long count = this.totalCount % this.pageSize==0 ? this.totalCount/this.pageSize : this.totalCount/this.pageSize+1;

	    return count;
	  }

	public boolean isHasNext()
	  {
	    return (this.pageNo + 1 <= getTotalPages());
	  }

	public int getNextPage()
	  {
	    if (isHasNext())
	      return (this.pageNo + 1);

	    return this.pageNo;
	  }

	public boolean isHasPre()
	  {
	    return (this.pageNo - 1 >= 1);
	  }

	public int getPrePage()
	  {
	    if (isHasPre())
	      return (this.pageNo - 1);

	    return this.pageNo;
	  }
	
	

	
	  

}
