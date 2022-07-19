package app.core.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.core.entities.Book;
import app.core.repositories.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository repo;

	public int addBook(Book book) {
		if (!repo.existsById(book.getId())) {
			book = repo.save(book);
			return book.getId();
		} else {
			throw new RuntimeException("addBook failed - already exist");
		}
	}

	public Book getBook(int bookId) {
		return repo.findById(bookId).orElseThrow();
	}

	public void updateBook(Book book) {
		if (repo.existsById(book.getId())) {
			book = repo.save(book);
		} else {
			throw new RuntimeException("updateBook failed - not found");
		}
	}

	public void deleteBook(int id) {
		repo.deleteById(id);
	}

}
