package demo.bookstore;

import java.util.Collection;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Category")
public class Category {
	private String categoryId;
	private String categoryName;
	private Collection<Book> books;
	
	public Category() {
	}
	
	public Category(String categoryId, String categoryName, Collection<Book> books) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.books = books;
	}

	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public Collection<Book> getBooks() {
		return books;
	}
	public void setBooks(Collection<Book> books) {
		this.books = books;
	}
}
