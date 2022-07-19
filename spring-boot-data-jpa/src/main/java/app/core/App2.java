package app.core;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import app.core.entities.Book;
import app.core.services.BookService;

@Component
public class App2 implements CommandLineRunner {
	@Autowired
	private BookService service;

	@Override
	public void run(String... args) throws Exception {
		doFindByAuthor("Dan");
//		doAddBook();
//		doGetBook(1);
//		doUpdate();
//		doDelete(1);
	}

	private void doFindByAuthor(String author) {
		List<Book> books = service.getBooksByAuthor(author);
		System.out.println("================");
		for (Book book : books) {
			System.out.println(book);
		}
		System.out.println("================");
	}

	private void doDelete(int id) {
		service.deleteBook(id);
	}

	private void doUpdate() {
		Book book = new Book(1, "Java 3 intro", "Eldar");
		service.updateBook(book);
	}

	private void doGetBook(int id) {
		Book book = service.getBook(id);
		System.out.println(book);
	}

	private void doAddBook() {
		Book book = new Book(0, "History 2", "Dan");
		service.addBook(book);
	}

}
