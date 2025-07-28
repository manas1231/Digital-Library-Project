package GFG.DigitalLibraryProject.Digital.Library.Project.entity.input;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;
import lombok.With;

import java.time.LocalDate;

@Data
@Builder
@With
public class UserInputEntity {

    private int id;

    @NotBlank(message = "First Name is mandatory")
    private String firstName;

    @NotBlank(message = "Last Name is mandatory")
    private String lastName;


    private LocalDate dob;
    private String number;
    @NotBlank(message = "Email is mandatory")
    private String email;
}
