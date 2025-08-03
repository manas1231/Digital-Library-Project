package GFG.DigitalLibraryProject.Digital.Library.Project.controller;

import GFG.DigitalLibraryProject.Digital.Library.Project.adapter.BookAdapter;
import GFG.DigitalLibraryProject.Digital.Library.Project.commons.CommonAdapter;
import GFG.DigitalLibraryProject.Digital.Library.Project.entity.input.BookInputEntity;
import GFG.DigitalLibraryProject.Digital.Library.Project.exceptions.ResourceNotFoundException;
import GFG.DigitalLibraryProject.Digital.Library.Project.model.BookModel;
import GFG.DigitalLibraryProject.Digital.Library.Project.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    private BookAdapter bookAdapter;
    @Autowired
    public BookController(BookAdapter bookAdapter)
    {
        this.bookAdapter=bookAdapter;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addBook(@Valid @RequestBody BookInputEntity book)
    {
        return new ResponseEntity<>(this.bookAdapter.save(book), HttpStatus.CREATED);

    }
    @GetMapping("/getBookById/{bookId}")
    public BookModel getBookById(@PathVariable long bookId)
    {
        BookModel book=bookAdapter.getBookById(bookId);
        return book;
    }
    @PutMapping("/update")
    public ResponseEntity<?> updateBook(@Valid @RequestBody BookInputEntity book)
    {
        try{
            return new ResponseEntity<>(this.bookAdapter.update(book),HttpStatus.OK);
        }catch (ResourceNotFoundException e)
        {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/getAllBooks")
    public List<BookModel> getAllBooks()
    {
        List<BookModel> list=this.bookAdapter.getAllBooks();
        return list;
    }

    @DeleteMapping("/deleteBook/{id}")
    public void deleteBookById(@PathVariable long id)
    {
        this.bookAdapter.deleteBookById(id);
    }

}
