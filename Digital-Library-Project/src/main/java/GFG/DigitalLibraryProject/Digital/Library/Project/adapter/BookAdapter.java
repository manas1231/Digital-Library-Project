package GFG.DigitalLibraryProject.Digital.Library.Project.adapter;

import GFG.DigitalLibraryProject.Digital.Library.Project.entity.input.BookInputEntity;
import GFG.DigitalLibraryProject.Digital.Library.Project.mappers.input.BookInputMapper;
import GFG.DigitalLibraryProject.Digital.Library.Project.model.BookModel;
import GFG.DigitalLibraryProject.Digital.Library.Project.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookAdapter {
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
        return bookService.addBook(bookInputMapper.mapToModel(bookInputEntity));
    }
}
