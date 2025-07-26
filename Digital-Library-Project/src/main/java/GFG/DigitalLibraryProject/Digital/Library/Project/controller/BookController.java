package GFG.DigitalLibraryProject.Digital.Library.Project.controller;

import GFG.DigitalLibraryProject.Digital.Library.Project.adapter.BookAdapter;
import GFG.DigitalLibraryProject.Digital.Library.Project.entity.input.BookInputEntity;
import GFG.DigitalLibraryProject.Digital.Library.Project.model.BookModel;
import GFG.DigitalLibraryProject.Digital.Library.Project.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
