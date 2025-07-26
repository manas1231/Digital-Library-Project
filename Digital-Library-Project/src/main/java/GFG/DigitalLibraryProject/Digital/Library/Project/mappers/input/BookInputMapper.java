package GFG.DigitalLibraryProject.Digital.Library.Project.mappers.input;

import GFG.DigitalLibraryProject.Digital.Library.Project.entity.input.BookInputEntity;
import GFG.DigitalLibraryProject.Digital.Library.Project.model.BookModel;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class BookInputMapper {
     public BookModel mapToModel(BookInputEntity inputEntity)
     {
         return BookModel.builder()
                 .id(inputEntity.getId())
                 .name(inputEntity.getName())
                 .author(inputEntity.getAuthor())
                 .description(inputEntity.getDescription())
                 .publishedData(inputEntity.getPublishedDate())
                 .createdAt(Instant.now())
                 .updatedAt(Instant.now())
                 .build();
     }
}
