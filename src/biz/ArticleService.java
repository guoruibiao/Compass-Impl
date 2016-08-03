package biz;

import dao.ArticleIndexDao;
import domain.Article;
import domain.Page;

/**
 * 用于支持页面显示层的业务逻辑类
 * 
 * @author Administrator
 *
 */
public class ArticleService {
	/**
	 * 保存数据到索引库
	 * 
	 * @param a
	 */
	public void save(Article a) {
		ArticleIndexDao dao = new ArticleIndexDao();
		dao.save(a);
	}

	/**
	 * 删除对应索引库中相关索引值的索引信息
	 * 
	 * @param id
	 */
	public void delete(Integer id) {
		ArticleIndexDao dao = new ArticleIndexDao();
		dao.delete(id);
	}

	/**
	 * 更新索引值信息
	 * 
	 * @param a
	 */
	public void update(Article a) {
		ArticleIndexDao dao = new ArticleIndexDao();
		dao.update(a);
	}

	/**
	 * 不带高亮的支持分页的索引
	 * 
	 * @param queryString
	 * @param firstResult
	 * @param maxResult
	 * @return
	 */
	public Page<Article> search(String queryString, int firstResult, int maxResult) {
		ArticleIndexDao dao = new ArticleIndexDao();
		return dao.search(queryString, firstResult, maxResult);
	}

	/**
	 * 支持高亮，支持分页的查询方法
	 * 
	 * @param queryString
	 * @param firstResult
	 * @param maxResult
	 * @return
	 */
	public Page<Article> searchWithHighLighter(String queryString, int firstResult, int maxResult) {
		ArticleIndexDao dao = new ArticleIndexDao();
		return dao.searchWithHighLighter(queryString, firstResult, maxResult);
	}

}
