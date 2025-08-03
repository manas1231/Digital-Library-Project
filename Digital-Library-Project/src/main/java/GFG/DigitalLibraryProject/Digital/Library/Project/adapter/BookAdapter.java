package GFG.DigitalLibraryProject.Digital.Library.Project.adapter;

import GFG.DigitalLibraryProject.Digital.Library.Project.commons.CommonAdapter;
import GFG.DigitalLibraryProject.Digital.Library.Project.entity.input.BookInputEntity;
import GFG.DigitalLibraryProject.Digital.Library.Project.mappers.input.BookInputMapper;
import GFG.DigitalLibraryProject.Digital.Library.Project.model.BookModel;
import GFG.DigitalLibraryProject.Digital.Library.Project.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

//In this layer we are handling the conversion of the input entity to model and feeds it back to service.
@Component
public class BookAdapter implements CommonAdapter<BookInputEntity,BookModel> {
    private BookService bookService;
    private BookInputMapper bookInputMapper;

    @Autowired
    public BookAdapter(BookService bookService,BookInputMapper bookInputMapper)
    {
        this.bookService=bookService;
        this.bookInputMapper=bookInputMapper;
    }

    public BookModel save(BookInputEntity bookInputEntity)
    {
        BookModel bookModel=bookInputMapper.mapToModel(bookInputEntity);
        return bookService.addBook(bookModel);
    }
    public BookModel getBookById(long id)
    {
        return bookService.getBookById(id);
    }
    public BookModel update(BookInputEntity bookInputEntity)
    {
        BookModel bookModel=bookInputMapper.mapToModel(bookInputEntity);
        System.out.println(bookModel);
        return this.bookService.updateBook(bookModel);
    }
    public List<BookModel> getAllBooks()
    {
        return bookService.getAllBooks();
    }

    public void deleteBookById(long id)
    {
        this.bookService.deleteBookById(id);
    }
}
