package domain;

import java.util.Date;

import org.compass.annotations.Index;
import org.compass.annotations.Searchable;
import org.compass.annotations.SearchableId;
import org.compass.annotations.SearchableProperty;
import org.compass.annotations.Store;

@Searchable
public class Article {

	@SearchableId
	private Integer id;
	@SearchableProperty(store = Store.YES, index = Index.ANALYZED)
	private String title;
	@SearchableProperty(store = Store.YES, index = Index.ANALYZED)
	private String author;
	@SearchableProperty(store = Store.YES, index = Index.ANALYZED)
	private String content;
	@SearchableProperty(store = Store.YES, index = Index.ANALYZED)
	private Date publishDate;

	/**
	 * 用于排序所需的冗余字段
	 */
	@SearchableProperty(store = Store.YES, index = Index.ANALYZED)
	private int filtermeta;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public int getFiltermeta() {
		return filtermeta;
	}

	public void setFiltermeta(int filtermeta) {
		this.filtermeta = filtermeta;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", title=" + title + ", author=" + author + ", content=" + content
				+ ", publishDate=" + publishDate + ", filtermeta=" + filtermeta + "]";
	}

}
