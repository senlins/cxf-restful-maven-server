package demo.bookstore;

import java.util.Collection;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;

@Path("/categoryservice")
@Produces({"application/json", "application/xml"})
public class CategoryService {
	private CategoryDao categoryDao;
	
	public CategoryDao getCategoryDao() {
		return categoryDao;
	}

	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}

	@GET
	@Path("/category/{id}")
	public Category getCategory(@PathParam("id") String id) {
		Category category = categoryDao.getCategory(id);
		
		if (category == null) {
			ResponseBuilder rb = Response.status(Status.BAD_REQUEST);
			rb.type("application/xml");
			rb.entity("<error>Category Not Found!</error>");
			throw new WebApplicationException(rb.build());
		} else {
			return category;
		}
	}
	
	@POST
	@Path("/category")
	@Consumes({"application/json", "application/xml"})
	public Response addCategory(Category category) {
		Category cat = categoryDao.getCategory(category.getCategoryId());
		if (cat != null) {
			return Response.status(Status.BAD_REQUEST).build();
		} else {
			 categoryDao.addCategory(category);
			 return Response.ok(category).build();
		}
		
		
	}
	
	@DELETE
	@Path("/category/{id}")
	public Response deleteCategory(@PathParam("id") String id) {
		Category cat = categoryDao.getCategory(id);
		
		if (cat == null) {
			return Response.status(Status.BAD_REQUEST).build();
		} else {
			categoryDao.deleteCategory(id);
			return Response.ok().build();
		}
	}
	
	@PUT
	@Path("/category")
	@Consumes({"application/json", "application/xml"})
	public Response updateCategory(Category category) {
		Category cat = categoryDao.getCategory(category.getCategoryId());
		
		if (cat == null) {
			return Response.status(Status.BAD_REQUEST).build();
		} else {
			categoryDao.updateCategory(category);
			return Response.ok().build();
		}
	}
	
	@POST
	@Path("/category/books")
	@Consumes({"application/json", "application/xml"})
	public void addBooks(Collection<Book> books) {
		
	}
	
	@GET
	@Path("/category/{id}/books")
	@Produces({"application/json", "application/xml"})
	public Response getBooksUnderCategory(@PathParam("id") String categoryId) {
		Category cat = categoryDao.getCategory(categoryId);
		
		if (cat == null) {
			return Response.status(Status.NOT_FOUND).build();
		} else {
			return Response.ok(categoryDao.getBooksUnderCategory(categoryId)).build();
		}
	}
}
