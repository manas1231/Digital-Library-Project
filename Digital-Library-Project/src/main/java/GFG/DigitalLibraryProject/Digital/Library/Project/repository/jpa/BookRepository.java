package GFG.DigitalLibraryProject.Digital.Library.Project.repository.jpa;

import GFG.DigitalLibraryProject.Digital.Library.Project.entity.output.BookOutputEntity;
import GFG.DigitalLibraryProject.Digital.Library.Project.mappers.output.BookOutputMapper;
import GFG.DigitalLibraryProject.Digital.Library.Project.model.BookModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
        Optional<BookOutputEntity> optional=bookJPARepository.findById(id);
        return optional.isPresent()?bookOutputMapper.mapToModel(optional.get()):null;
    }
}
