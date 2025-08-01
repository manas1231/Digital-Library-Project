package GFG.DigitalLibraryProject.Digital.Library.Project.model;

import lombok.Builder;
import lombok.Data;
import lombok.With;

import java.time.Instant;

@Data
@Builder
@With
public class BookModel {

    private long id;
    private String name;
    private String author;
    private String description;
    private Instant publishedData;
    private Instant createdAt;
    private Instant updatedAt;

}
