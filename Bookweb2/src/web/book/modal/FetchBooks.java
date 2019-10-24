package web.book.modal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

import web.bookstore.db.ConnectionManager;
import web.bookstore.Books;

/**
 * Servlet implementation class FetchBooks
 */
@WebServlet("/FetchBooks")
public class FetchBooks extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FetchBooks() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		MongoClient connection = ConnectionManager.getMongo();
		MongoDatabase db = ConnectionManager.getDb("BookStore");
		MongoCollection<Document> collection = db.getCollection("book");
		
//		String srch = request.getParameter("srch");
//		if(srch!=null) {
//		cursor = collection.find(Filters.eq("name",srch)).limit(30).iterator();
//		}
//		else {
//			cursor = collection.find().limit(30).iterator();
//		}

		List<Books> dataList = new ArrayList<>();
		String newName=request.getParameter("newName");
		String newPrice=request.getParameter("newPrice");
		String newAuthor=request.getParameter("newAuthor");
		String newReview=request.getParameter("newReview");
	
	Document document = new Document("name",newName).append("price",newPrice).append("author", newAuthor).append("review", newReview);
	List<Document> docs = new ArrayList<>();
	docs.add(document);
	collection.insertMany(docs);
	MongoCursor<Document> cursor = collection.find().limit(30).iterator();
		while (cursor.hasNext()) {
			Document d = (Document) cursor.next();

			 Books books = new Books(d.getString("name"), d.getString("price"), d.getString("author"), d.getString("review"));
			dataList.add(books);
		}

		//ConnectionManager.close();

		request.setAttribute("list", dataList);
		request.getRequestDispatcher("index.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
	}

}
