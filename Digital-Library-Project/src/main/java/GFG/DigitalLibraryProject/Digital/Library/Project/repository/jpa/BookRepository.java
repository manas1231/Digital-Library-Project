package GFG.DigitalLibraryProject.Digital.Library.Project.repository.jpa;

import GFG.DigitalLibraryProject.Digital.Library.Project.entity.output.BookOutputEntity;
import GFG.DigitalLibraryProject.Digital.Library.Project.exceptions.ResourceNotFoundException;
import GFG.DigitalLibraryProject.Digital.Library.Project.mappers.output.BookOutputMapper;
import GFG.DigitalLibraryProject.Digital.Library.Project.model.BookModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Component
public class BookRepository {
    public BookJPARepository bookJPARepository;
    public BookOutputMapper bookOutputMapper;
    @Autowired
    public BookRepository(BookJPARepository bookJPARepository,BookOutputMapper bookOutputMapper)
    {
        this.bookJPARepository=bookJPARepository;
        this.bookOutputMapper=bookOutputMapper;
    }

    public BookModel save(BookModel book)
    {
       //Convert model to output entity
        BookOutputEntity convertedOutputEntity=bookOutputMapper.mapFromModel(book);
        //save in db

        BookOutputEntity savedEntity=bookJPARepository.save(convertedOutputEntity);

        //convert the saved output entity into model
        //return the model
        return bookOutputMapper.mapToModel(savedEntity);
    }

    public BookModel findById(long id)
    {
        Optional<BookOutputEntity> optional = bookJPARepository.findById(id);
        if (optional.isPresent()) {
            return bookOutputMapper.mapToModel(optional.get());
        } else {
            throw new ResourceNotFoundException("Book with given id not found");
        }
    }

    public BookModel updateBook(BookModel book)
    {
        BookModel b=this.findById(book.getId());
        if(b==null)
        {
            return null;
        }
        book.setUpdatedAt(Instant.now());
        book.setCreatedAt(b.getCreatedAt());
        return this.save(book);
    }

    public List<BookModel> getAllBooks()
    {
        List<BookOutputEntity> list=this.bookJPARepository.findAll();

        List<BookModel> ans = new java.util.ArrayList<>(List.of());
        for (BookOutputEntity b : list) {
            BookModel bookModel = bookOutputMapper.mapToModel(b);
            ans.add(bookModel);
        }
        return ans;
    }

    public void deleteBookById(long id)
    {
        this.bookJPARepository.deleteById(id);
    }
}
