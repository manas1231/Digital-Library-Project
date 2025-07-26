package GFG.DigitalLibraryProject.Digital.Library.Project.service;

import GFG.DigitalLibraryProject.Digital.Library.Project.model.BookModel;
import GFG.DigitalLibraryProject.Digital.Library.Project.repository.jpa.BookJPARepository;
import GFG.DigitalLibraryProject.Digital.Library.Project.repository.jpa.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
