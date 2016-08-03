package servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biz.ArticleService;
import domain.Article;

/**
 * Servlet implementation class PublishArticleServlet
 */
@WebServlet("/PublishArticleServlet")
public class PublishArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PublishArticleServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		try {
			ArticleService service = new ArticleService();
			Integer id = Integer.parseInt(request.getParameter("article_id"));
			String title = request.getParameter("article_title");
			String author = request.getParameter("article_author");
			String content = request.getParameter("article_content");

			Article a = new Article();
			a.setId(id);
			a.setAuthor(author);
			a.setContent(content);
			a.setTitle(title);
			a.setPublishDate(new Date());
			a.setFiltermeta(id);
			service.save(a);
			request.getSession().setAttribute("message",
					"Contragulations!<br>Publish Article Success<br><a href='index.jsp'>查看</a>");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		} catch (Exception e) {
			request.getSession().setAttribute("message",
					"Sorry! Publishing Article Failed!<br>Please try agein later!");
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
