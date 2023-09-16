package emisoft.appbooksstorespringboot.Services;

import emisoft.appbooksstorespringboot.Entities.Book;
import emisoft.appbooksstorespringboot.Repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService
{
    @Autowired
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository)
    {
        this.bookRepository = bookRepository;
    }

    public  void Save(Book book)
    {
        bookRepository.save(book);
    }

    public List<Book> GetAllBooks()
    {
        return  bookRepository.findAll();
    }

    public Book GetBookById(int id)
    {
        return  bookRepository.findById(id).get();
    }

    public void DeleteBook(int id)
    {
        bookRepository.deleteById(id);
    }
}
