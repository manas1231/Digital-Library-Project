package GFG.DigitalLibraryProject.Digital.Library.Project.controller;

import GFG.DigitalLibraryProject.Digital.Library.Project.adapter.BookAdapter;
import GFG.DigitalLibraryProject.Digital.Library.Project.commons.CommonAdapter;
import GFG.DigitalLibraryProject.Digital.Library.Project.entity.input.BookInputEntity;
import GFG.DigitalLibraryProject.Digital.Library.Project.exceptions.ResourceNotFoundException;
import GFG.DigitalLibraryProject.Digital.Library.Project.model.BookModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.Instant;
import java.util.List;

@ExtendWith(MockitoExtension.class)  // ✅ Enable Mockito annotations
public class BookControllerTest {


//    private CommonAdapter<BookInputEntity,BookModel> adapter= Mockito.mock(BookAdapter.class);
//
//    private final BookController bookController=new BookController((BookAdapter) adapter);
//The above way is one way of creating a mock of the dependency classes and using them inside our
//class.Another way is to use

    @Mock
    private BookAdapter adapter;

    @InjectMocks
    private BookController bookController;

    static BookInputEntity inputEntity;
    static BookModel bookModel;
    //Currently we will be getting null because we have not initialized it
    //and also we need an adapter to run the bookcontroller according to our implementation.
    //So instead of creating and running an entire dependency injection from here itself,
    //we will be using

    @BeforeAll
    static void setup()
    {
         inputEntity=BookInputEntity.builder()
                .id(1L)
                .author("JK Rowling")
                .name("Harry Potter and The Chamber of Secrets")
                .description("Its a fantasy book")
                .publishedDate(Instant.now())
                .build();

        bookModel=BookModel.builder()
                .id(1L)
                .author("JK Rowling")
                .name("Harry Potter and The Chamber of Secrets")
                .description("Its a fantasy book")
                .createdAt(Instant.now())
                .updatedAt(null)
                .build();

    }

    @Test
    void  testAddBook()
    {

        // Idea of UT
        // 1. We expect a certain output for a given input
        // 2. Then we run the function that we want to test with given input
        // 3. We check whether the actual output is the same as expected output.


        Mockito.when(adapter.save(inputEntity)).thenReturn(bookModel);
        ResponseEntity<?> actualResponse=this.bookController.addBook(inputEntity);
        Assertions.assertEquals(HttpStatus.CREATED,actualResponse.getStatusCode());
        Assertions.assertEquals(bookModel,actualResponse.getBody());
    }
    @Test
    @DisplayName("Updating Book TestCase")
    void updateBookTest()
    {
        BookInputEntity updatedInputEntity=inputEntity.withDescription("My favourite fantasy book");
        BookModel updatedBookModel=bookModel.withDescription("My favourite fantasy book");
        Mockito.when(adapter.update(updatedInputEntity)).thenReturn(updatedBookModel);
        ResponseEntity<?> actualResponse=this.bookController.updateBook(updatedInputEntity);
        Assertions.assertEquals(HttpStatus.OK,actualResponse.getStatusCode());
        Assertions.assertEquals(updatedBookModel,actualResponse.getBody());
    }

    @Test
    @DisplayName("Updating Book Failed Test Case")
    void updateBookTestFailed()
    {
        BookInputEntity updatedInputEntity=inputEntity.withDescription("My favourite fantasy book").withId(2);
        Mockito.when(adapter.update(updatedInputEntity)).thenThrow(new ResourceNotFoundException(Mockito.any()));
        ResponseEntity<?> actualResponse=this.bookController.updateBook(updatedInputEntity);
        Assertions.assertEquals(HttpStatus.BAD_REQUEST,actualResponse.getStatusCode());
    }
    @Test
    @DisplayName("Get all books")
    void getAllBooks()
    {
        List<BookModel> list = List.of(bookModel);
        Mockito.when(adapter.getAllBooks()).thenReturn(list);
        List<BookModel> actualResponse= this.bookController.getAllBooks();
        Assertions.assertEquals(list,actualResponse);

    }

    @Test
    @DisplayName("Get Book By Id Test Case")
    void getBookById()
    {
        long id=52;
        Mockito.when(adapter.getBookById(id)).thenReturn(bookModel);
        BookModel actualResponse=this.bookController.getBookById(id);
        Assertions.assertEquals(bookModel,actualResponse);

    }
}
