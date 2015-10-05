package demo.bookstore;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CategoryServerStart {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext beanFactory = new ClassPathXmlApplicationContext("/demo/bookstore/bookstore.xml");
		CategoryService categoryService = (CategoryService) beanFactory.getBean("categoryService");
		
		// Server Factory
		JAXRSServerFactoryBean restServer = new JAXRSServerFactoryBean();
		restServer.setResourceClasses(Category.class);
		restServer.setServiceBean(categoryService);
		restServer.setAddress("http://localhost:9002/");
		restServer.create();
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		try {
			bf.readLine();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Server Stopped!");
		System.exit(0);
	}
}
