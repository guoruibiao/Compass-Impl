package test;

import static org.junit.Assert.fail;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import dao.ArticleIndexDao;
import domain.Article;
import domain.Page;

public class ArticleIndexDaoTest {

	private static ArticleIndexDao dao = new ArticleIndexDao();

	@Test
	public void testSave() {
		Article a = new Article();
		a.setId(1);
		a.setTitle("Compass 测试实例");
		a.setAuthor("郭璞");
		a.setFiltermeta(1);
		a.setContent("Compass是一个基于Lucene的免费的搜索引擎框架，简单易用。定制性强。我们可以基于Compass制作出符合我们项目需求的站内搜索，或者全文搜索！");
		a.setPublishDate(new Date());
		dao.save(a);
	}

	@Test
	public void testDelete() {
		dao.delete(1);
	}

	@Test
	public void testUpdate() {
		Article a = new Article();
		a.setId(1);
		a.setTitle("Compass 测试实例修改版");
		a.setAuthor("郭璞");
		a.setFiltermeta(1);
		a.setContent("修改版：Compass是一个基于Lucene的免费的搜索引擎框架，简单易用。定制性强。我们可以基于Compass制作出符合我们项目需求的站内搜索，或者全文搜索！");
		a.setPublishDate(new Date());
		dao.update(a);
	}

	@Test
	public void testSearch() {
		Page page = dao.search("compass", 0, 10);
		List<Article> articles = page.getLists();
		int totalRecords = page.getTotalResults();
		System.out.println("查询到的总的记录数位：" + totalRecords);
		for (Article a : articles) {
			System.out.println(a.toString());
		}
	}

	@Test
	public void testSearchWithHighLighter() {
		Page page = dao.searchWithHighLighter("compass", 0, 100);
		List<Article> articles = page.getLists();
		int totalRecords = page.getTotalResults();
		System.out.println("查询到的总的记录数位：" + totalRecords);
		for (Article a : articles) {
			System.out.println(a.toString());
		}
	}

}
