package web.bookstore;
import org.bson.types.ObjectId;
public class Books {
	private ObjectId id;
	private String name;
	private String price;
	private String author;
	private String review;
	public Books(String name, String price, String author, String review) {
		super();
		this.name=name;
		this.price=price;
		this.author=author;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public ObjectId getId() {
		return id;
	}
	public void setId(ObjectId id) {
		this.id = id;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}

}

