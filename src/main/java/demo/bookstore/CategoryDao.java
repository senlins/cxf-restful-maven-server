package demo.bookstore;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CategoryDao {
	private static Map<String, Category> categoryMap = new HashMap<>();
	private static Map<String, Collection<Book>> bookMap = new HashMap<>();
	
	static {
		Category c1 = new Category("1", "Technology", null);
		Category c2 = new Category("2", "Fiction", null);
		
		categoryMap.put("1", c1);
		categoryMap.put("2", c2);
		
		Book b1 = new Book("1", "Java SE");
		Book b2 = new Book("2", "Java Web");
		Collection<Book> list1 = new ArrayList<Book>();
		list1.add(b1);
		list1.add(b2);
		c1.setBooks(list1);;
		bookMap.put("1", list1);
		
		Book b3 = new Book("3", "Fiction 3");
		Book b4 = new Book("4", "Harry Potter");
		Collection<Book> list2 = new ArrayList<Book>();
		list2.add(b3);
		list2.add(b4);
		c2.setBooks(list2);
		bookMap.put("2", list2);
	}
	
	public Category getCategory(String id) {
		return categoryMap.get(id);
	}
	
	public void addCategory(Category category) {
		categoryMap.put(category.getCategoryId(), category);
	}
	
	public void deleteCategory(String id) {
		categoryMap.remove(id);
	}
	
	public void updateCategory(Category category) {
		Category c = categoryMap.get(category.getCategoryId());
		c.setCategoryName(category.getCategoryName());
	}
	
	// To clarify
	public void addBooks(Collection<Book> books) {
		
	}
	
	public Collection<Book> getBooksUnderCategory(String categoryId) {
		return categoryMap.get(categoryId).getBooks();
	}
}
