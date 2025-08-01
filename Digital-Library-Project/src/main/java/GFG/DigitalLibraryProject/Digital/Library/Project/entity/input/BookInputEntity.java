package GFG.DigitalLibraryProject.Digital.Library.Project.entity.input;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.With;

import java.time.Instant;

@Data
@Builder
@With
public class BookInputEntity {

    private long id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotBlank(message = "Author is mandatory")
    private String author;

    private String description;

    @NotNull(message = "Published Date is mandatory")
    private Instant publishedDate;

}
