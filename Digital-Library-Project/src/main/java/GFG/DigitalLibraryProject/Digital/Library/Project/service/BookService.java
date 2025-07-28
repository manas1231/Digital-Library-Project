package GFG.DigitalLibraryProject.Digital.Library.Project.service;

import GFG.DigitalLibraryProject.Digital.Library.Project.model.BookModel;
import GFG.DigitalLibraryProject.Digital.Library.Project.repository.jpa.BookJPARepository;
import GFG.DigitalLibraryProject.Digital.Library.Project.repository.jpa.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    public BookRepository bookRepository;
    @Autowired
    public BookService(BookRepository bookRepository)
    {
        this.bookRepository=bookRepository;
    }

    public BookModel addBook(BookModel book){
       return  this.bookRepository.save(book);
    }

    public BookModel getBookById(long id)
    {
        return this.bookRepository.findById(id);
    }
    public BookModel updateBook(BookModel book)
    {
        //When we are trying to update there are 2 things which can happen:
        //1.It would update the existing entity
        //2.Either throw an error or create a new record in DB(this is referred to as UPSERT)
        return this.bookRepository.updateBook(book);
    }
    public List<BookModel> getAllBooks()
    {
        return this.bookRepository.getAllBooks();
    }
    public void deleteBookById(long id)
    {
        this.bookRepository.deleteBookById(id);
    }
}
