package dao;

import java.util.ArrayList;
import java.util.List;

import org.compass.core.CompassHits;
import org.compass.core.CompassSession;
import org.compass.core.CompassTransaction;

import domain.Article;
import domain.Page;
import util.CompassUtils;

/**
 * 业务逻辑相关底层实现
 * 
 * @author Administrator
 *
 */
public class ArticleIndexDao {

	/**
	 * 将数据存储到索引库中
	 * 
	 * @param a
	 */
	public void save(Article a) {
		CompassSession session = CompassUtils.getCompassSessionFactory().openSession();
		CompassTransaction tx = null;
		try {
			tx = session.beginTransaction();
			session.create(a);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			throw new RuntimeException(e);
		} finally {
			session.close();
		}
	}

	/**
	 * 删除指定的索引对应的数据信息
	 * 
	 * @param id
	 */
	public void delete(Integer id) {
		CompassSession session = CompassUtils.getCompassSessionFactory().openSession();
		CompassTransaction tx = null;
		try {
			tx = session.beginTransaction();
			session.delete(Article.class, id);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			throw new RuntimeException(e);
		} finally {
			session.close();
		}
	}

	/**
	 * 更新索引库中对应的数据，为了效率更高，代价更低。底层采用先删除再创建的方式
	 * 
	 * @param a
	 */
	public void update(Article a) {
		CompassSession session = CompassUtils.getCompassSessionFactory().openSession();
		CompassTransaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(a);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			throw new RuntimeException(e);
		} finally {
			session.close();
		}
	}

	/**
	 * 支持分页技术的查询操作，基于给定的搜索词的数据信息
	 * 
	 * @param queryString
	 * @param firstResult
	 * @param maxResult
	 * @return
	 */
	public Page<Article> search(String queryString, int firstResult, int maxResult) {
		CompassSession session = CompassUtils.getCompassSessionFactory().openSession();
		CompassTransaction tx = null;
		try {
			tx = session.beginTransaction();
			// 查询，得到结果
			CompassHits hits = session.find(queryString);
			Page page = new Page();
			page.setTotalResults(hits.getLength());
			List<Article> articles = new ArrayList<Article>();
			// 分页机制，获取一段数据
			firstResult = firstResult >= 0 ? firstResult : 0;
			int endResult = Math.min(firstResult + maxResult, hits.getLength());
			for (int i = firstResult; i < endResult; i++) {
				Article a = (Article) hits.data(i);
				articles.add(a);
			}
			page.setLists(articles);
			tx.commit();
			return page;
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			throw new RuntimeException(e);
		} finally {
			session.close();
		}
	}

	/**
	 * 基于给定词的查询，返回高亮的结果集信息
	 * 
	 * @param queryString
	 * @param firstResult
	 * @param maxResult
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Page<Article> searchWithHighLighter(String queryString, int firstResult, int maxResult) {
		CompassSession session = CompassUtils.getCompassSessionFactory().openSession();
		CompassTransaction tx = null;
		try {
			tx = session.beginTransaction();
			// 查询，得到结果
			CompassHits hits = session.find(queryString);
			Page page = new Page();
			page.setTotalResults(hits.getLength());
			List<Article> articles = new ArrayList<Article>();
			// 分页机制，获取一段数据
			firstResult = firstResult >= 0 ? firstResult : 0;
			int endResult = Math.min(firstResult + maxResult, hits.getLength());
			for (int i = firstResult; i < endResult; i++) {
				Article a = (Article) hits.data(i);
				// -------------------------------------高亮开始
				String text = hits.highlighter(i).fragment("content");
				// 如果有需要高亮的词，则存储高亮后的数据
				if (text != null) {
					a.setContent(text);
				}

				articles.add(a);
			}
			page.setLists(articles);
			tx.commit();
			return page;
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			throw new RuntimeException(e);
		} finally {
			session.close();
		}
	}

}
