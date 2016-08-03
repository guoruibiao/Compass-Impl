/**
 * @Date 2016年8月3日
 *
 * @author Administrator
 */
package domain;

import java.util.List;

/**
 * @author 郭瑞彪
 *
 */
public class Page<T> {

	private List<T> lists;

	private int totalResults;

	public List<T> getLists() {
		return lists;
	}

	public void setLists(List<T> lists) {
		this.lists = lists;
	}

	public int getTotalResults() {
		return totalResults;
	}

	public void setTotalResults(int totalResults) {
		this.totalResults = totalResults;
	}

	@Override
	public String toString() {
		return "Page [lists=" + lists + ", totalResults=" + totalResults + "]";
	}

}
