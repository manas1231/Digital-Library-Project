package GFG.DigitalLibraryProject.Digital.Library.Project.mappers.output;

import GFG.DigitalLibraryProject.Digital.Library.Project.entity.output.BookOutputEntity;
import GFG.DigitalLibraryProject.Digital.Library.Project.model.BookModel;
import org.springframework.stereotype.Component;

@Component
public class BookOutputMapper {


    public BookModel mapToModel(BookOutputEntity bookOutputEntity)
    {
        return BookModel.builder()
                .id(bookOutputEntity.getId())
                .name(bookOutputEntity.getName())
                .author(bookOutputEntity.getAuthor())
                .description(bookOutputEntity.getDescription())
                .createdAt(bookOutputEntity.getCreatedAt())
                .updatedAt(bookOutputEntity.getUpdatedAt())
                .build();
    }
    public BookOutputEntity mapFromModel(BookModel bookModel)
    {
        return BookOutputEntity.builder()
                .id(bookModel.getId())
                .name(bookModel.getName())
                .author(bookModel.getAuthor())
                .description(bookModel.getDescription())
                .publishedData(bookModel.getPublishedData())
                .createdAt(bookModel.getCreatedAt())
                .updatedAt(bookModel.getUpdatedAt())
                .build();
    }
}
